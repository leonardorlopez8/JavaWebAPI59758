package com.educacionit.RestClient;

import java.net.URI;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;

import com.educacionit.entidades.Usuario;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		URI URL_SERVICIOS = UriBuilder.fromUri("http://localhost:8082/Rest/servicios").build();

		ClientConfig config = new ClientConfig();
		config.property(ClientProperties.SUPPRESS_HTTP_COMPLIANCE_VALIDATION, true);
		
		Client cliente = ClientBuilder.newClient(config);

		// Creamos un usuario
		Usuario usuario = new Usuario();
		usuario.setCorreo("user9@gmail.com");
		usuario.setClave("1234");

		// WebTarget, identifica una URL especifica
		WebTarget URL_USUARIOS = cliente.target(URL_SERVICIOS).path("usuarios");

		Response respuestaAgregar = URL_USUARIOS.path("agregar").request(MediaType.APPLICATION_JSON_TYPE)
				.post(Entity.entity(usuario, MediaType.APPLICATION_JSON_TYPE));

//		System.out.println(respuestaAgregar);
//		System.out.println(respuestaAgregar.getStatus()); //200 300 400

		Response respuestaUsuarioURN = URL_USUARIOS.path("buscar").path("user1@gmail.com")
				.request(MediaType.APPLICATION_JSON_TYPE).get();
//	    System.out.println(respuestaUsuarioURN);

		Usuario usuarioURN = respuestaUsuarioURN.readEntity(Usuario.class);
		// Reflection - Deserializacion
//	    System.out.println(usuarioURN);

		// Nos traemos la lista

		Response respuestaLista = URL_USUARIOS.path("listar").request(MediaType.APPLICATION_JSON_TYPE).get();
//	    System.out.println(respuestaLista.readEntity(List.class));

//	    respuestaLista.readEntity(List.class).forEach(System.out::println);

		List<Usuario> listaUsuarios = (List<Usuario>) respuestaLista.readEntity(List.class);
//	   	System.out.println(listaUsuarios);

		// Eliminamos un usuario
		Response eliminarUsuario = URL_USUARIOS.path("eliminar").request(MediaType.APPLICATION_JSON_TYPE).method("DELETE",
				Entity.entity(usuario, MediaType.APPLICATION_JSON_TYPE));

		
		
	}
}
