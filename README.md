
# RTC-Back

Este proyecto es una API REST para gestionar marcas y buses. Permite realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre las entidades `Marca` y `Bus`.

## Tecnologías utilizadas

- **Java 24**
- **Spring Boot**
  - Spring Data JPA
  - Spring Web
- **MySQL** como base de datos
- **Lombok** para reducir el código repetitivo
- **Hibernate** como ORM
- **Maven** como herramienta de construcción

## Configuración del proyecto

### Requisitos previos

1. **Java 24** instalado.
2. **Maven** instalado.
3. **MySQL** instalado y configurado.

### Configuración de la base de datos

Asegúrate de que tu base de datos esté configurada correctamente. Modifica el archivo `application.properties` para que coincida con tu configuración:

```
spring.datasource.url=jdbc:mysql://localhost:3306/prueba
spring.datasource.username=root
spring.datasource.password=admin
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

Cambia `spring.datasource.url`, `spring.datasource.username` y `spring.datasource.password` según tu configuración de MySQL.

### Crear la base de datos

Ejecuta el siguiente comando SQL para crear la base de datos:

```sql
CREATE DATABASE prueba;
```

## Ejecución del proyecto

1. Clona este repositorio:
    ```bash
    git clone (https://github.com/Victormrl17/rtc-back.git)
    cd rtc-back
    ```
2. Compila el proyecto con Maven:
    ```bash
    ./mvnw clean install 
    ```
3. Ejecuta la aplicación:
    ```bash
    ./mvnw spring-boot:run
    ```
4. La API estará disponible en `http://localhost:8080`.

## Endpoints de la API

### Marca

| Método | Endpoint     | Descripción                  | Ejemplo de cuerpo (JSON)         |
|--------|--------------|------------------------------|----------------------------------|
| POST   | /marca       | Crear una nueva marca        | `{ "nombre": "Volvo" }`          |
| GET    | /marca       | Obtener todas las marcas     | -                                |
| GET    | /marca/{id}  | Obtener una marca por ID     | -                                |
| PUT    | /marca/{id}  | Actualizar una marca         | `{ "nombre": "Mercedes" }`       |
| DELETE | /marca/{id}  | Eliminar una marca por ID    | -                                |

### Bus

| Método | Endpoint    | Descripción                  | Ejemplo de cuerpo (JSON)         |
|--------|-------------|------------------------------|----------------------------------|
| POST   | /bus        | Crear un nuevo bus           | `{ "id": 1, "numeroBus": "123", "placa": "ABC123", "caracteristicas": "Bus moderno", "activo": true, "marca": { "id": 1 } }` |
| GET    | /bus        | Obtener todos los buses      | -                                |
| GET    | /bus/{id}   | Obtener un bus por ID        | -                                |
| PUT    | /bus/{id}   | Actualizar un bus existente  | `{ "numeroBus": "456", "placa": "DEF456", "caracteristicas": "Bus actualizado", "activo": false, "marca": { "id": 2 } }` |
| DELETE | /bus/{id}   | Eliminar un bus por ID       | -                                |

## Estructura del proyecto

```
rtc-back/
├── src/
│   ├── main/
│   │   ├── java/com/example/rtc_back/
│   │   │   ├── controller/   # Controladores REST
│   │   │   ├── entity/       # Entidades JPA
│   │   │   ├── repository/   # Repositorios JPA
│   │   │   ├── service/      # Lógica de negocio
│   │   ├── resources/
│   │       ├── application.properties  # Configuración de la aplicación
├── pom.xml                   # Archivo de configuración de Maven
```

## Ejemplo de datos

### Crear una marca

```json
POST /marca
{
    "nombre": "Volvo"
}
```

### Crear un bus

```json
POST /bus
{
    "id": 1,
    "numeroBus": "123",
    "placa": "ABC123",
    "caracteristicas": "Bus moderno",
    "activo": true,
    "marca": {
        "id": 1
    }
}
```

## Notas importantes

1. **Reutilización de IDs eliminados**: Si eliminas una marca o un bus, el sistema reutilizará el ID eliminado al crear un nuevo registro.
2. **Relación entre `Marca` y `Bus`**: Una marca puede tener múltiples buses asociados. Al eliminar una marca, todos los buses asociados también se eliminarán automáticamente.

## Autor

Proyecto desarrollado por Victor Ramirez.
