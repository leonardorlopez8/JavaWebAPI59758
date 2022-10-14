package com.educacionit.servicios;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.educacionit.entidades.Usuario;
import com.educacionit.implementacion.mysql.UsuarioImplementacion;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioControlador {
    private UsuarioImplementacion implementacion = new UsuarioImplementacion();
	
    @Path("/listar")
    @GET
    public List<Usuario> listar(){
    	return implementacion.listar();
    }

    @POST
	@Path("/agregar")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response agregar(Usuario usuario) {
		implementacion.guardar(usuario);
		return Response.ok(usuario).build();
	}

    @GET
    @Path("/buscar")
    public Response buscarPorQP(String correo) {
    	  Usuario usuario = implementacion.buscar(correo);
    	  if(null==usuario) {
    		  return Response.status(404).build();
    	  }
    	  
    	  
    	  return Response.ok(usuario).build();
    }
    
    
}
