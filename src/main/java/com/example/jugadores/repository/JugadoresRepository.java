package com.example.jugadores.repository;


import com.example.jugadores.model.Jugadores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadoresRepository extends JpaRepository <Jugadores, Integer> {
}
