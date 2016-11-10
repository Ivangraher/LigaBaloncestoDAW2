package com.example.retrofit;
import com.example.Service.JugadorService;
import com.example.Service.JugadorService2;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.io.IOException;
import java.util.List;

/**
 * Created by 46419674Q on 02/11/2016.
 */
public class Menu_Asyn {
    private static Retrofit retrofit;

    public static void main(String[] args) throws IOException {
        retrofit = new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JugadorService2 jugadorService2 = retrofit.create(JugadorService2.class);
    }
}
