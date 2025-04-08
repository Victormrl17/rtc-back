package com.example.rtc_back.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

@OneToMany(mappedBy = "marca", cascade = CascadeType.ALL, orphanRemoval = true)
@JsonBackReference 
private List<Bus> buses;
}
