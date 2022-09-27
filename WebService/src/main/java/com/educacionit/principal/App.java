package com.educacionit.principal;

import javax.xml.ws.Endpoint;

import com.eduacionit.entidades.Usuario;
import com.educacionit.implementacion.mysql.UsuarioImplementacion;
import com.educacionit.servicios.ServicioBasico;

public class App {

	public static void main(String[] args) {
//		System.out.println(new UsuarioImplementacion().buscar("user1@gmail.com"));
		Endpoint.publish("http://localhost:8081/servicio/suma", new ServicioBasico());
		
	
		
		
		
	}
	
}
