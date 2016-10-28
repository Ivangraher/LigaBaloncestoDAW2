package com.example.Service;

import com.example.Model.Equipo;
import retrofit.Call;
import retrofit.http.*;

import java.util.List;

/**
 * Created by 46419674Q on 28/10/2016.
 */
public interface EquipoService2 {

    @GET("/api/equipos")
    Call<List<Equipo>> getAllEquipos(
            @Header("Authorization") String Authorization
    );

    @POST("/api/equipos")
        Call<Equipo> createEquipo(
            @Header("Authorization") String Authorization,
            @Body Equipo equipo
    );


    @PUT("/api/equipos")
    Call<Equipo> updateEquipo(
            @Header("Authorization") String Authorization,
            @Body Equipo equipo
    );
}
