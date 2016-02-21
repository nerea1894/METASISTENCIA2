package DAO;

import java.sql.*;
import java.util.ArrayList;

import connectionDB.ConnectionDB;
import model.Alumno;

/* CLASE DAO DE ALUMNO */
public class AlumnoDAO {

	/*CONSULTAS*/
	private static final String FIND_BY_ID = "SELECT * FROM alumno WHERE id=?;";
	private static final String FIND_BY_ASIGNATURA = "SELECT a.* FROM alumno AS a, nota AS n WHERE a.id = n.id_alumno AND n.id_asignatura = ?;";
	private static final String FIND_BY_NOMBRE = "SELECT * FROM alumno WHERE nombre=?;";
	
	/* BUSCAR POR NOMBRE */
	public Alumno findByNombre(String name) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = ConnectionDB.getConnection();
			stmt = conn.prepareStatement(FIND_BY_NOMBRE);
			stmt.setString(1, name);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				Alumno alumno = new Alumno();
				alumno.setId(rs.getInt("id"));
				alumno.setNombre(rs.getString("nombre"));
				alumno.setApellidos(rs.getString("apellidos"));
				
				return alumno;
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
	
	/* BUSCAR POR ID */
	public Alumno findById(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = ConnectionDB.getConnection();
			stmt = conn.prepareStatement(FIND_BY_ID);
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				Alumno alumno = new Alumno();
				alumno.setId(rs.getInt("id"));
				alumno.setNombre(rs.getString("nombre"));
				alumno.setApellidos(rs.getString("apellidos"));
				
				return alumno;
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
	
	/*BUSCAR POR ASIGNATURA*/
	public ArrayList<Alumno> findByAsignatura(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		
		try {
			conn = ConnectionDB.getConnection();
			stmt = conn.prepareStatement(FIND_BY_ASIGNATURA);
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Alumno alumno = new Alumno();
				alumno.setId(rs.getInt("id"));
				alumno.setNombre(rs.getString("nombre"));
				alumno.setApellidos(rs.getString("apellidos"));
				
				alumnos.add(alumno);
			} 

			return alumnos;
			
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionDB.closeStatement(stmt);
			ConnectionDB.closeConnection(conn);
		}
	}
	
}
