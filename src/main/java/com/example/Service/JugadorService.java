package com.example.Service;

import com.example.Model.Equipo;
import com.example.Model.Jugador;
import com.example.Model.Posicion;
import com.example.Repository.EquipoRepository;
import com.example.Repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Navy on 13/10/2016.
 */
@Service
public class JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;
    @Autowired
    private EquipoRepository equipoRepository;

    public void Registro() {

        //Registro equipos
        Equipo equipo1 = new Equipo("equipo1", "Barcelona", LocalDate.of(2000, 1, 10));
        equipoRepository.save(equipo1);
        Equipo equipo2 = new Equipo("equipo2", "Madrid", LocalDate.of(2012, 4, 23));
        equipoRepository.save(equipo2);
        Equipo equipo3 = new Equipo("equipo3", "Asturias", LocalDate.of(20010, 12, 12));
        equipoRepository.save(equipo3);


        //Registro jugadores
        Jugador jugador1 = new Jugador("jugador1", LocalDate.of(2000, 1, 10), 10, 5, 8, Posicion.Ala);
        jugador1.setEquipo(equipo1);
        jugadorRepository.save(jugador1);
        Jugador jugador2 = new Jugador("jugador2", LocalDate.of(2002, 5, 23), 1, 15, 4, Posicion.Base);
        jugador2.setEquipo(equipo2);
        jugadorRepository.save(jugador2);
        Jugador jugador3 = new Jugador("jugador3", LocalDate.of(2004, 8, 14), 6, 8, 2, Posicion.Alero);
        jugador3.setEquipo(equipo3);
        jugadorRepository.save(jugador3);
        Jugador jugador4 = new Jugador("jugador4", LocalDate.of(2006, 12, 1), 3, 2, 12, Posicion.Escolta);
        jugador4.setEquipo(equipo2);
        jugadorRepository.save(jugador4);
        Jugador jugador5 = new Jugador("jugador5", LocalDate.of(2008, 3, 8), 10, 15, 18, Posicion.Pivot);
        jugador5.setEquipo(equipo1);
        jugadorRepository.save(jugador5);
    }

        public void pruebas() {

        System.out.println(jugadorRepository.findByNombre("jugador"));
        System.out.println(jugadorRepository.findByCanastasGreaterThanEqual(2));
        System.out.println(jugadorRepository.findByfechaNacimientoBefore(LocalDate.of(2000, 1, 1)));
        System.out.println(jugadorRepository.findByPosicionEquals(Posicion.Base));

        jugadorRepository.
                findByMediaCanastasRebotesAsistenciasPosicion().
                forEach(Jugador -> System.out.println(Jugador[0] + ", media de canastas: " + Jugador[1] + ", media de asistencias: " + Jugador[2] + ", media de rebotes: " + Jugador[3]));


    }
}