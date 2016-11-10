package com.example.Controller;

import com.example.Model.Equipo;
import com.example.Model.Jugador;
import com.example.Repository.EquipoRepository;
import com.example.Repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 46419674Q on 02/11/2016.
 */
//@RestController
//@RequestMapping("/equipos")
public class EquipoController2 {

    @Autowired
    private EquipoRepository equipoRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Equipo crearEquipo(@RequestBody Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    @PutMapping
    public Equipo updateEquipo(@RequestBody Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    @GetMapping
    public List<Equipo> findAll() {
        return equipoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Equipo findById(@PathVariable Long id) {
        Equipo equipo = equipoRepository.findOne(id);
        return equipo;
    }

   @DeleteMapping("/{id}")
    public void deleteEquipo(@PathVariable Long id) {
       equipoRepository.delete(id);
   }
}
