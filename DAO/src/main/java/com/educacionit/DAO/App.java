package com.educacionit.DAO;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.eduacionit.entidades.Usuario;
import com.educacionit.implementacion.mysql.UsuarioImplementacion;
import com.educacionit.interfaces.UtilidadesFecha;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ParseException
    {
         Usuario usuario = null;
         UsuarioImplementacion impl = new UsuarioImplementacion();
         
       //Listamos todos los Usuarios
 		List<Usuario> lista = impl.listar();
 		lista.forEach(System.out::println);
        
       
    }
}
