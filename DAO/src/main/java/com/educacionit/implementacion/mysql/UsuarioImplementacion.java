package com.educacionit.implementacion.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.eduacionit.entidades.Usuario;
import com.educacionit.interfaces.ConexionMySQL;
import com.educacionit.interfaces.DAO;
import com.educacionit.interfaces.UtilidadesFecha;

public class UsuarioImplementacion implements DAO<Usuario, String>, ConexionMySQL {

	private PreparedStatement psBuscar;
	private PreparedStatement psInsertar;
	private PreparedStatement psEliminar;
	private PreparedStatement psActualizar;
	private PreparedStatement psListar;
    private final String KEY = "JavaWebAPI";
	
	@Override
	public Usuario buscar(String correo) {
		Usuario usuario = null;
		String query = "select cast(AES_DECRYPT(clave, ?) as char(50)) as clave, fechaActualizacion, fechaCreacion from usuarios where correo = ?";

		try {
			psBuscar = getConexion().prepareStatement(query);
			psBuscar.setString(1, KEY);
			psBuscar.setString(2, correo);

			ResultSet resultado = psBuscar.executeQuery();
			if (resultado.next()) {
				usuario = new Usuario();
				usuario.setCorreo(correo);
				usuario.setClave(resultado.getString("clave"));
				usuario.setFechaCreacion(UtilidadesFecha.getStringAFecha(resultado.getString("fechaCreacion")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuario;
	}

	@Override
	public Boolean insertar(Usuario e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean eliminar(Usuario e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean actualizar(Usuario e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
