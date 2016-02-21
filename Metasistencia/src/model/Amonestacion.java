package model;

/* CLASE AMONESTACION */
public class Amonestacion {
	/*DECLARACION DE COMPONENTES*/
	private int id;
	private String motivo;
	private int id_asignatura;
	private int id_alumno;
	
	/* CONSTRUCTOR */
	public Amonestacion(int id, String motivo, int id_clase, int id_alumno) {
		super();
		this.id = id;
		this.motivo = motivo;
		this.id_asignatura = id_clase;
		this.id_alumno = id_alumno;
	}
	
	public Amonestacion(String motivo, int id_clase, int id_alumno) {
		super();
		this.motivo = motivo;
		this.id_asignatura = id_clase;
		this.id_alumno = id_alumno;
	}

	/* GETTERS & SETTERS */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public int getId_clase() {
		return id_asignatura;
	}

	public void setId_clase(int id_clase) {
		this.id_asignatura = id_clase;
	}

	public int getId_alumno() {
		return id_alumno;
	}

	public void setId_alumno(int id_alumno) {
		this.id_alumno = id_alumno;
	}
	
	
	
}
