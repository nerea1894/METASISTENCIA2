package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectionDB.ConnectionDB;
import model.Nota;

/* CLASE DAO DE NOTA */
public class NotaDAO {
	
	/*CONSULTAS*/
	private static final String FIND_BY_ALUMNO = "SELECT * FROM nota WHERE id_alumno=? AND id_asignatura=?;";
	private static final String UPDATE = "UPDATE nota SET nota1=?, nota2=?, nota3=?, nota_ex=? WHERE id_alumno=? AND id_asignatura=?;";
	
	/* BUSCAR POR ALUMNO */
	public Nota findByAlumno(int id_alumno, int id_asignatura) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = ConnectionDB.getConnection();
			stmt = conn.prepareStatement(FIND_BY_ALUMNO);
			stmt.setInt(1, id_alumno);
			stmt.setInt(2, id_asignatura);
			
			ResultSet rs = stmt.executeQuery();
			
			Nota nota = new Nota();
			
			if (rs.next()) {
				
				nota.setId_alumno(rs.getInt(id_alumno));
				nota.setId_asignatura(rs.getInt(id_asignatura));
				nota.setNota1(rs.getInt("nota1"));
				nota.setNota2(rs.getInt("nota2"));
				nota.setNota3(rs.getInt("nota3"));
				nota.setNota_ex(rs.getInt("nota_ex"));
				
				return nota;
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
	
	/* ACTUALIZAR NOTAS */
	public int update(Nota nota) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = ConnectionDB.getConnection();
			stmt = conn.prepareStatement(UPDATE);
			stmt.setInt(1, nota.getNota1());
			stmt.setInt(2, nota.getNota2());
			stmt.setInt(3, nota.getNota3());
			stmt.setInt(4, nota.getNota_ex());
			stmt.setInt(5, nota.getId_alumno());
			stmt.setInt(6, nota.getId_asignatura());
			
			
			return stmt.executeUpdate();
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionDB.closeStatement(stmt);
			ConnectionDB.closeConnection(conn);
		}
	}

}
