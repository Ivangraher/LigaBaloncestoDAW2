package com.example.Service;

import com.example.Model.Jugador;
import com.example.Model.Posicion;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by 46419674Q on 28/10/2016.
 */
public interface JugadorService2 {


    @GET("/jugadores")
    Call<List<Jugador>> getAllJugadores();

    @GET("/jugadores/{id}")
    Call<Jugador> getJugador(@Path("id") Long id);

    @GET("/jugadoresError")
    Call<List<Jugador>> getError();

    @POST("/jugadores")
    Call<Jugador> createJugador(@Body Jugador jugador);

    @PUT("/jugadores")
    Call<Jugador> updateJugador(@Body Jugador jugador);

    @DELETE("/jugadores/{id}")
    Call<Void> deleteJugador(@Path("id") Long id);

    @GET("/jugadores/orderByCanastas")
    Call<List<Jugador>> orderByJugadoresCanastas();

    @GET("/jugadores/byCanastas/{canastas}")
    Call<List<Jugador>> findByCanastasGreaterThanEqual(@Path("canastas") int canastas);

    @GET("/jugadores/ByCanastas/{min}/{max}")
    Call<List<Jugador>> findByCanastasBetween(@Path("min") int min, @Path("max") int max);

    @GET("/jugadores/posicionAndMedia")
    Call<Map<Posicion, Collection<Jugador>>> findByPosicionAndMedia();

    @GET("/jugadores/byPosicionAllJugadores")
    Call<Map<Posicion, Collection<Jugador>>> findByAllPosiciones();



}


