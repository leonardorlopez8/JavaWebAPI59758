package com.educacionit.RestClient;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import com.educacionit.entidades.Usuario;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		URI URL_SERVICIOS = UriBuilder.fromUri("http://localhost:8082/Rest/servicios").build();

		Client cliente = ClientBuilder.newClient();

		// Creamos un usuario
		Usuario usuario = new Usuario();
		usuario.setCorreo("user9@gmail.com");
		usuario.setClave("1234");

		// WebTarget, identifica una URL especifica
		WebTarget URL_USUARIOS = cliente.target(URL_SERVICIOS).path("usuarios");

		Response respuestaAgregar = URL_USUARIOS.path("agregar").request(MediaType.APPLICATION_JSON_TYPE)
				.post(Entity.entity(usuario, MediaType.APPLICATION_JSON_TYPE));
        
		System.out.println(respuestaAgregar);
		System.out.println(respuestaAgregar.getStatus()); //200 300 400
	}
}
