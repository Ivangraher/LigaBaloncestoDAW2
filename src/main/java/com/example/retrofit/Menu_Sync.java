package com.example.retrofit;

import com.example.Model.Jugador;
import com.example.Service.JugadorService2;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by 46419674Q on 02/11/2016.
 */
public class Menu_Sync {

    private static Retrofit retrofit;

    public static void main(String[] args) throws IOException {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://l92.168.23.11:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JugadorService2 jugadorService2 = retrofit.create(JugadorService2.class);

        Call<List<Jugador>> call = jugadorService2.getAllPlayers();
        Response<List<Jugador>> response = call.execute();

        if(response.isSuccessful()) {
            List<Jugador> playerList = response.body();
            System.out.println("Status code: " + response.code() + System.lineSeparator() +
                    "GET all players: " + playerList);
        } else {
            System.out.println("Status code: " + response.code() +
                    "Message error: " + response.errorBody());
        }
    }




}
