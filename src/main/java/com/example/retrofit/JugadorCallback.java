package com.example.retrofit;

import com.example.Model.Jugador;

import java.util.List;

/**
 * Created by 46419674Q on 28/10/2016.
 */
public interface JugadorCallback {

    void onSuccess(List<Jugador> listaJugadores);

    void onFailure(Throwable t);

}
