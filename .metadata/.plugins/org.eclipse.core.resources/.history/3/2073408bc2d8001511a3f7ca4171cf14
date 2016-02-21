package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectionDB.ConnectionDB;

public class NotaDAO {
	
	private static final String FIND_BY_ALUMNO = "SELECT * FROM nota WHERE id_alumno=? AND id_asignatura=?;";
	
	public int[] findByAlumno(int id_alumno, int id_asignatura) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = ConnectionDB.getConnection();
			stmt = conn.prepareStatement(FIND_BY_ALUMNO);
			stmt.setInt(1, id_alumno);
			stmt.setInt(2, id_asignatura);
			
			ResultSet rs = stmt.executeQuery();
			
			int[] notas = new int[4];
			
			if (rs.next()) {
				
				notas[0]=rs.getInt("nota1");
				notas[1]=rs.getInt("nota2");
				notas[2]=rs.getInt("nota3");
				notas[3]=rs.getInt("nota_ex");
				
				return notas;
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
