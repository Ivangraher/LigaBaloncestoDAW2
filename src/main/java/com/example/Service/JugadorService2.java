package com.example.Service;

import com.example.Model.Jugador;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

/**
 * Created by 46419674Q on 28/10/2016.
 */
public interface JugadorService2 {

    @GET("/players")
    Call<List<Jugador>> getAllPlayers(
    );

    @POST("/jugadores")
    Call<Jugador> createJugador(
            @Body Jugador jugador
    );

    @PUT("/jugadores")
    Call<Jugador> updateJugador(
            @Body Jugador jugador
    );

    @GET("/jugadoresError")
    Call<List<Jugador>> getError(
    );

    @GET("/jugadores/{id}")
    Call<List<Jugador>> getAllJugadores(
            @Path("id") Long id
    );

    @DELETE("/jugadores/{id}")
    Call<Void> deleteJugador(
          @Path("id") Long id
    );




}


