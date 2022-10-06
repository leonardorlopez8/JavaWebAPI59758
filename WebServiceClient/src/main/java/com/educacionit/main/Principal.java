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
	        
	        try {
				usuarios = Arrays.asList(servicioUsuario.listar());
				usuarios.forEach((e)->System.out.println(e));
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
