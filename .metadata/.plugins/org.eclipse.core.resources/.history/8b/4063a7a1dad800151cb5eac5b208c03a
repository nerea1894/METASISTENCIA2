package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectionDB.ConnectionDB;
import model.Asignatura;

public class AsignaturaDAO {
	
	private static final String FIND_BY_PROFESOR = "SELECT * FROM asignatura WHERE id_profesor = ?;";
	
	public ArrayList<Asignatura> findByProfesor(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ArrayList<Asignatura> asignaturas = new ArrayList<Asignatura>();
		
		try {
			conn = ConnectionDB.getConnection();
			stmt = conn.prepareStatement(FIND_BY_PROFESOR);
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Asignatura asignatura = new Asignatura();
				asignatura.setId(rs.getInt("id"));
				asignatura.setNombre(rs.getString("nombre"));
				
				asignaturas.add(asignatura);
			} 

			return asignaturas;
			
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionDB.closeStatement(stmt);
			ConnectionDB.closeConnection(conn);
		}
	}

}
