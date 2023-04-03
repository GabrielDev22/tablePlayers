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
       List<Jugadores> allJugadores = jugadoresRepository.findAll();
        try{
            log.info("Empezando getALlJugadores");
            allJugadores = jugadoresRepository.findAll();
            if(allJugadores.isEmpty()){
                log.error("No se encontro ningun jugador ");
                return null;
            }
            return allJugadores;
        }catch (Exception exception){
            log.error(exception.getMessage());
        }
            return allJugadores;
    }

    @Override
    public Jugadores getJugadoresById(Integer id) {
        Jugadores particularJugadores = null;
        try{
            log.info("Empezando el getJugadoresById");
            particularJugadores = jugadoresRepository.getReferenceById(id);
            if(particularJugadores.getId() == null){
                log.error("No se encontro ningun jugador por ese ID");
                return null;
            }
            log.info("Terminando getJugadoresById");
            return particularJugadores;

        }catch (Exception exception){
         log.error(exception.getMessage());
        }
        return particularJugadores;
    }

    @Override
    public Jugadores createJugadores(Jugadores jugadores){
        Jugadores createJugadores = null;
        try{
            log.info("Empezando el createJugadores");
            if(!StringUtils.hasText(jugadores.getName())) {
                return null;
            }
            createJugadores = jugadoresRepository.save(jugadores);
            log.info("Terminando createJugadores");
        }catch(Exception exception){
            log.error(exception.getMessage());
        }
        return createJugadores;
    }

    @Override
    public Jugadores updateJugadores(Jugadores jugadores) {
        Jugadores updateJugadores = null;
        try{
            log.info("Empezando el updateJugadores");
            if (!StringUtils.hasText(jugadores.getName()) || jugadores.getId() == null || jugadores.getPosition() == null) {
                log.error("Falto algun dato");
                return null;
            }
            updateJugadores = jugadoresRepository.save(jugadores);
            log.info("Terminando el updateJugadores");
        }catch (Exception exception){
            log.error(exception.getMessage());
        }
        return updateJugadores;
    }

    @Override
    public void deleteJugadoresById(Integer id) {
        log.info("Empezando la eliminacion del jugador");
        jugadoresRepository.deleteById(id);
        log.info("Finalizando la eliminacion del jugador");
    }
}
