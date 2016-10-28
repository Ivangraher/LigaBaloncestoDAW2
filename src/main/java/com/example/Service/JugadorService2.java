package com.example.Service;

import com.example.Model.Jugador;
import retrofit.Call;
import retrofit.http.*;

import java.util.List;

/**
 * Created by 46419674Q on 28/10/2016.
 */
public interface JugadorService2 {

    @GET("/api/jugadores")
    Call<List<Jugador>> getAllJugadores(
            @Header("Authorization") String Authorization
    );

    @POST("/api/jugadores")
    Call<Jugador> createJugador(
            @Header("Authorization") String Authorization,
            @Body Jugador jugador
    );


    @PUT("/api/jugadores")
    Call<Jugador> updateJugador(
            @Header("Authorization") String Authorization,
            @Body Jugador jugador
    );
}


