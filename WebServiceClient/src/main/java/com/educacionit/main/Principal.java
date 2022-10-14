package com.educacionit.main;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

import com.educacionit.entidades.Usuario;
import com.educacionit.servicios.UsuarioServicio;
import com.educacionit.servicios.UsuarioServicioProxy;

public class Principal {

	public static void main(String[] args) throws RemoteException {
		 List<Usuario> usuarios;
	        UsuarioServicio servicioUsuario = new UsuarioServicioProxy();
	        
	        try {//CRUD
				usuarios = Arrays.asList(servicioUsuario.listar());
				usuarios.forEach((e)->System.out.println(e));
//				servicioUsuario.agregar(new Usuario("2222", "user2@gmail.com", null, null));
	//			servicioUsuario.eliminar(new Usuario("2222", "user2@gmail.com", null, null));
				servicioUsuario.agregar(new Usuario("2222", "user1@gmail.com", null, null));
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
