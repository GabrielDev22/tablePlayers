package com.example.jugadores.service;

import com.example.jugadores.model.Jugadores;
import java.util.List;
public interface JugadoresService {

    List<Jugadores> getAllJugadores();
    Jugadores getJugadoresById(Integer id);

    Jugadores createJugadores(Jugadores jugadores);
    Jugadores updateJugadores(Jugadores jugadores);

    void deleteJugadoresById(Integer id);
}
