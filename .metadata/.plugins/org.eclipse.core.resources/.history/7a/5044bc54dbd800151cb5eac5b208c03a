package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectionDB.ConnectionDB;
import model.Profesor;

public class ProfesorDAO {
	
	private static final String FIND_ALL = "SELECT * FROM profesor;";
	private static final String CHECK_LOGIN = "SELECT * FROM profesor WHERE nombre=? AND contrasenya=?";
	
	public ArrayList<Profesor> findAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ArrayList<Profesor> profesores = new ArrayList<Profesor>();
		
		try {
			conn = ConnectionDB.getConnection();
			stmt = conn.prepareStatement(FIND_ALL);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Profesor profesor = new Profesor();
				profesor.setId(rs.getInt("id"));
				profesor.setNombre(rs.getString("nombre"));
				profesor.setContrasenya(rs.getString("contrasenya"));
				
				profesores.add(profesor);
			} 

			return profesores;
			
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionDB.closeStatement(stmt);
			ConnectionDB.closeConnection(conn);
		}
	}
	
	public Profesor check_login(String name, String password) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = ConnectionDB.getConnection();
			stmt = conn.prepareStatement(CHECK_LOGIN);
			stmt.setString(1, name);
			stmt.setString(2, password);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				Profesor profesor = new Profesor();
				profesor.setId(rs.getInt("id"));
				profesor.setNombre(rs.getString("nombre"));
				profesor.setContrasenya(rs.getString("contrasenya"));
				
				return profesor;
			} else {
				return null;
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionDB.closeStatement(stmt);
			ConnectionDB.closeConnection(conn);
		}
	}

}
