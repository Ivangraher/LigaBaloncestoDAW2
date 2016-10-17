package com.example.Service;

import com.example.Model.Equipo;
import com.example.Model.Posicion;
import com.example.Repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * Created by Navy on 13/10/2016.
 */
@Service
public class EquipoService {
    @Autowired
    private EquipoRepository equipoRepository;

    public void registroEquipo() {
        //Registro equipos
        Equipo equipo1 = new Equipo("equipo1", "Barcelona", LocalDate.of(2000, 1, 10));
        equipoRepository.save(equipo1);
        Equipo equipo2 = new Equipo("equipo2", "Madrid", LocalDate.of(2012, 4, 23));
        equipoRepository.save(equipo2);
        Equipo equipo3 = new Equipo("equipo3", "Asturias", LocalDate.of(20010, 12, 12));
        equipoRepository.save(equipo3);
    }

    public void pruebasEquipo(){
        System.out.println(equipoRepository.findByCiudad("Barcelona"));
        equipoRepository.findByJugadoresEquipoNombre("equipo3").forEach(jugador -> System.out.println(jugador));
        equipoRepository.findByJugadoresEquipoNombreAndPosicion("equipo3", Posicion.Base).forEach(jugador -> System.out.println(jugador));
        System.out.println(equipoRepository.findByCanastasEquipo("equipo1").get(0));
    }


}
