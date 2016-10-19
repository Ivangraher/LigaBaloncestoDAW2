package com.example.Controller;

import com.example.Model.Equipo;
import com.example.Repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Navy on 19/10/2016.
 */
@RestController
@RequestMapping("/Equipos")
public class EquipoController {

    @Autowired
    private EquipoRepository equipoRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Equipo save(@RequestBody Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Equipo> findAllEquipos() {
        List<Equipo> equipos = new ArrayList<Equipo>();
        Iterator<Equipo> iterator = equipoRepository.findAll().iterator();
        while (iterator.hasNext()) {
            equipos.add(iterator.next());
        }
        return equipos;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteEquipoById(@PathVariable Long id) {
        Equipo equipo = equipoRepository.findOne(id);
        equipoRepository.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Equipo updateEquipoById(@PathVariable Long id, @RequestBody Equipo equipo) {
        Equipo e = equipoRepository.findOne(id);
        if(e == equipo) return null;
        return equipoRepository.save(equipo);
    }

}