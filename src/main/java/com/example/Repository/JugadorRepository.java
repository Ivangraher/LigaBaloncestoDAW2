package com.example.Repository;

import com.example.Model.Jugador;
import com.example.Model.Posicion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Navy on 13/10/2016.
 */
@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long> {

    List<Jugador> findByNombre(String nombre);

    List<Jugador> findByCanastasGreaterThanEqual(int canastas);

    List<Jugador> findByPosicionEquals(Posicion posicion);

    List<Jugador> findByfechaNacimientoBefore(LocalDate fechaNacimiento);

    @Query("SELECT AVG(j.canastas), AVG(j.asistencias), AVG(j.rebotes), j.posicion FROM Jugador j GROUP BY j.posicion")
    List<Object[]> findByMediaCanastasRebotesAsistenciasPosicion();

    @Query("SELECT j.posicion, AVG(j.canastas), MAX(j.canastas), MIN(j.canastas), AVG(j.rebotes), MAX(j.rebotes), MIN(j.rebotes), AVG(j.asistencias), MAX(j.asistencias), MIN(j.asistencias) FROM Jugador j GROUP BY j.posicion")
    List<Object[]> findByAvgMinMaxOfAllPosicion();

    @Query("SELECT j.id, j.nombre, j.canastas FROM Jugador j ORDER BY j.canastas ASC")
    List<Jugador> findAllJugadoresCanastas();

    List<Jugador> findByCanastasBetween(int min, int max);

    @Query("SELECT j FROM Jugador j ")
    List<Jugador> findByAllPosiciones();

    @Query("SELECT j.posicion, " + " MIN(j.canastas)," + " MAX(j.canastas), " + "AVG(j.canastas)" + " FROM Jugador j " + " GROUP BY j.posicion ")
    List<Object[]> findByPosicionAndMedia();
}

