package com.example.rtc_back.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bus {

    @Id
    private Long id;

    private String numeroBus;

    private String placa;

    private String caracteristicas;

    private boolean activo;

    private LocalDateTime fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    @JsonIgnoreProperties(value = "buses") 
    private Marca marca;

    @PrePersist
    public void setFechaCreacion() {
        this.fechaCreacion = LocalDateTime.now();
    }
}
