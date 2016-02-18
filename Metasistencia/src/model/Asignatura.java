package model;

public class Asignatura {
	
	private int id;
	private String nombre;
	private int id_profesor;
	
	/* CONSTRUCTOR */
	public Asignatura(int id, String nombre, int id_profesor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.id_profesor = id_profesor;
	}
	
	public Asignatura(){
		
	}
	
	/* GETTERS & SETTERS */
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getId_profesor() {
		return id_profesor;
	}
	
	public void setId_profesor(int id_profesor) {
		this.id_profesor = id_profesor;
	}

}
