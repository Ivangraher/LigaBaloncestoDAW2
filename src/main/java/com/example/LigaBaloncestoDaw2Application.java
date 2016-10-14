package com.example;

import com.example.Service.EquipoService;
import com.example.Service.JugadorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LigaBaloncestoDaw2Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(LigaBaloncestoDaw2Application.class, args);

		EquipoService equipoService = context.getBean(EquipoService.class);
		JugadorService jugadorService = context.getBean(JugadorService.class);

		jugadorService.Registro();
		jugadorService.pruebas();

		//equipoService.prueba();
	}
}
