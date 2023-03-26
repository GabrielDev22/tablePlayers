package com.example.jugadores.service.implementation;

import com.example.jugadores.model.Jugadores;
import com.example.jugadores.repository.JugadoresRepository;
import com.example.jugadores.service.JugadoresService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Slf4j
public class JugadoresServiceImplementation  implements JugadoresService {

    private final JugadoresRepository jugadoresRepository;

    public JugadoresServiceImplementation(JugadoresRepository jugadoresRepository){
        this.jugadoresRepository = jugadoresRepository;
    }
    @Override
    public List<Jugadores> getAllJugadores() {
        log.info("Empezando getALlJugadores");
        List<Jugadores> allJugadores = jugadoresRepository.findAll();rue)
        log.info("Terminando getAllJugadores");
        return allJugadores;
    }

    @Override
    public Jugadores getJugadoresById(Integer id) {
        Jugadores particularJugadores = jugadoresRepository.getReferenceById(id);
        return particularJugadores;
    }

    @Override
    public Jugadores createJugadores(Jugadores jugadores) {
        if(!StringUtils.hasText(jugadores.getName()))
            return null;
        Jugadores createJugadores = jugadoresRepository.save(jugadores);
        return createJugadores;
    }

    @Override
    public Jugadores updateJugadores(Jugadores jugadores) {
        if (!StringUtils.hasText(jugadores.getName()) || jugadores.getId() == null || jugadores.getPosition() == null) {
            log.error("Falto algun dato");
            return null;
        }
        Jugadores updateJugadores = jugadoresRepository.save(jugadores);
        return updateJugadores;
    }

    @Override
    public void deleteJugadoresById(Integer id) { jugadoresRepository.deleteById(id);}
}
