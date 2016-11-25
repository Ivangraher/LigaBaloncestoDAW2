package com.example.Controller;

import com.example.Model.EstadisticasPosicion;
import com.example.Model.Jugador;
import com.example.Model.Posicion;
import com.example.Repository.JugadorRepository;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import retrofit2.http.Field;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 46419674Q on 02/11/2016.
 */
@RestController
@RequestMapping("/jugadores")
public class JugadorController2 {

    @Autowired
    private JugadorRepository jugadorRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Jugador crearJugador(@RequestBody Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    @PutMapping
    public Jugador updateJugador(@RequestBody Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    @GetMapping
    public List<Jugador> findAll() {
        return jugadorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Jugador findById(@PathVariable Long id) {
        Jugador jugador = jugadorRepository.findOne(id);
        return jugador;
    }

    @GetMapping("/orderByCanastas")
    public List<Jugador> orderByJugadoresCanastas() {
        return jugadorRepository.orderByJugadoresCanastas();
    }

    @GetMapping("/byCanastas/{canastas}")
    public List<Jugador> findByCanastasGreaterThanEqual(@PathVariable Integer canastas) {
        return jugadorRepository.findByCanastasGreaterThanEqual(canastas);
    }

    @GetMapping("ByCanastas/{min}/{max}")
    public List<Jugador> findByCanastasBetween(@PathVariable Integer min, @PathVariable Integer max) {
        return jugadorRepository.findByCanastasBetween(min, max);
    }


    @GetMapping("/posicionAndMedia")
    public Map<String, EstadisticasPosicion> findByPosicionAndMedia() {

        List<Object[]> estadisticasPosicions = jugadorRepository.findByPosicionAndMedia();

        Map<String, EstadisticasPosicion> estadisticasPosicionMap = new HashMap<>();

        estadisticasPosicions.
                forEach(estadisticasPosicion -> {

                    EstadisticasPosicion aux = new EstadisticasPosicion();
                    aux.setPosicion((Posicion) estadisticasPosicion[0]);
                    aux.setMinCanastas((Integer) estadisticasPosicion[1]);
                    aux.setMaxCanastas((Integer) estadisticasPosicion[2]);
                    aux.setAvgCanastas((Double) estadisticasPosicion[3]);

                    estadisticasPosicionMap.put(aux.getPosicion(), aux);

                });

        return estadisticasPosicionMap;

    }

    @GetMapping("/byPosicionAllJugadores")
    public Map<Posicion, Collection<Jugador>> findByAllPosiciones() {
        List<Jugador> jugadores = jugadorRepository.findAll();

        ListMultimap<Posicion, Jugador> jugadorMultiMap = ArrayListMultimap.create();

        jugadores.forEach(jugador ->
            jugadorMultiMap.put(jugador.getPosicion(), jugador));

        System.out.println(jugadorMultiMap.get(Posicion.Base));

        return jugadorMultiMap.asMap();

    }


    @DeleteMapping("/{id}")
    public void deleteJugador(@PathVariable Long id) {
        jugadorRepository.delete(id);
    }
}
