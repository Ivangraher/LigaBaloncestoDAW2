package com.example.retrofit;
import java.util.*;

import com.example.Model.Jugador;
import com.example.Service.JugadorService;
import org.apache.commons.logging.Log;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;


public class JugadorManager {
    private static JugadorManager jugadorManager;
    private List<Jugador> jugadores;
    private Retrofit retrofit2;
    private JugadorService jugadorService;

    public synchronized void getAllJugadores(final JugadorCallback jugadorCallback) {
        Call<List<Jugador>> call = jugadorService.getAllJugadores();
        call.enqueue(new Callback<List<Jugador>>() {
            @Override
            public void onResponse(Call<List<Jugador>> call, Response<List<Jugador>> response) {
                jugadores = response.body();

                int code = response.code();

                if (code == 200 || code == 201) {
                    jugadorCallback.onSuccess(jugadores);
                } else {
                    jugadorCallback.onFailure(new Throwable("ERROR" + code + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<List<Jugador>> call, Throwable t) {
                Log.e("JugadorManager->", "getAllJugadores()->ERROR: " + t);

                jugadorCallback.onFailure(t);
            }
        });
    }

}
