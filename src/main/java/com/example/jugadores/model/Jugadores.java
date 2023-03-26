package com.example.jugadores.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name = "Jugadores")


public class Jugadores {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @Column(name = "lastname")
    private String lastName;
    private String position;
}
