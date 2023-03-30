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
            List<Jugadores> allJugadores = jugadoresRepository.findAll();
            if(allJugadores.isEmpty()){
                log.error("No se encontro ningun jugador ");
                return null;
            }
            log.info("Terminando getAllJugadores");
            return allJugadores;
    }

    @Override
    public Jugadores getJugadoresById(Integer id) {
        log.info("Empezando el getJugadoresById");
        Jugadores particularJugadores = jugadoresRepository.getReferenceById(id);
        log.info("Terminando getJugadoresById");
        return particularJugadores;
    }

    @Override
    public Jugadores createJugadores(Jugadores jugadores) {
        log.info("Empezando el createJugadores");
        if(!StringUtils.hasText(jugadores.getName()))
            return null;
        Jugadores createJugadores = jugadoresRepository.save(jugadores);
        log.info("Terminando createJugadores");
        return createJugadores;
    }

    @Override
    public Jugadores updateJugadores(Jugadores jugadores) {
        log.info("Empezando el updateJugadores");
        if (!StringUtils.hasText(jugadores.getName()) || jugadores.getId() == null || jugadores.getPosition() == null) {
            log.error("Falto algun dato");
            return null;
        }
        Jugadores updateJugadores = jugadoresRepository.save(jugadores);
        log.info("Terminando el updateJugadores");
        return updateJugadores;
    }

    @Override
    public void deleteJugadoresById(Integer id) {
        log.info("Empezando la eliminacion del jugador");
        jugadoresRepository.deleteById(id);
        log.info("Finalizando la eliminacion del jugador");
    }
}
