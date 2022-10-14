package com.educacionit.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/inicial")
public class Inicial {

	private static List<String> nombres = new ArrayList<String>();
	
	@GET //URL
	@Path("/holamundo")
	@Produces(MediaType.TEXT_PLAIN)
	public String holaMundo() {
		return "Hola Mundo";
	}
	
	@POST //CUERPO O BODY DEL REQUEST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/agregar")
	public Response agregar(String nombre) { // {"nombre": "Juan"}
	    
		if(nombre.contains("J")) {
	    	return Response.status(406).build();
	    }
	    nombres.add(nombre); 
	    return Response.ok().build();	
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listar")
	public Response listar(){
		return Response.ok(nombres).build();
	}
	
	
	
	
	
	
	
	
	
}
