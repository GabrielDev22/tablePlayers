package com.example.jugadores.controller;

import com.example.jugadores.model.Jugadores;
import com.example.jugadores.service.JugadoresService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jugadores")

public class JugadoresController {

    private final JugadoresService jugadoresService;
    public JugadoresController(JugadoresService jugadoresService) {
        this.jugadoresService = jugadoresService;
    }
    @GetMapping("/getAll")
    public List<Jugadores> getAllJugadores() {return jugadoresService.getAllJugadores();}

    @GetMapping("/get/{id}")
    public Jugadores getJugadoresById(@PathVariable Integer id){return jugadoresService.getJugadoresById(id);}

    @PostMapping("/create")
    public Jugadores createJugadores(@RequestBody Jugadores jugadores){return jugadoresService.createJugadores(jugadores);}

    @PutMapping("/update")
    public Jugadores updateJugadores(@RequestBody Jugadores jugadores){
        return jugadoresService.updateJugadores(jugadores);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteJugadoresById(@PathVariable Integer id) {jugadoresService.deleteJugadoresById(id);}


}
