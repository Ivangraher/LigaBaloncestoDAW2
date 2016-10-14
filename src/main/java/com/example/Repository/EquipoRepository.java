package com.example.Repository;

import com.example.Model.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Navy on 13/10/2016.
 */
@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long> {

    //List<Equipo> findByEquipoCiudad(String ciudad);

}
