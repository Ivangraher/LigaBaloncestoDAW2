package com.example.Repository;

import com.example.Model.Equipo;
import com.example.Model.Jugador;
import com.example.Model.Posicion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Navy on 13/10/2016.
 */
@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long> {

    List<Equipo> findByCiudad(String ciudad);

    @Query("SELECT j FROM Jugador j, Equipo e WHERE e.id = j.equipo and e.nombre = :equipoNombre")
    List<Jugador> findByJugadoresEquipoNombre(@Param("equipoNombre") String Nombre);

    @Query("SELECT j FROM Jugador j, Equipo e WHERE e.id = j.equipo and e.nombre = :equipoNombre and j.posicion = :jugadorPosicion")
    List<Jugador> findByJugadoresEquipoNombreAndPosicion(@Param("equipoNombre") String Nombre, @Param("jugadorPosicion")Posicion posicion);

    @Query("SELECT j FROM Jugador j, Equipo e WHERE e.id = j.equipo and e.nombre = :equipoNombre ORDER BY Canastas DESC")
    List<Jugador> findByCanastasEquipo(@Param("equipoNombre") String Nombre);
}
