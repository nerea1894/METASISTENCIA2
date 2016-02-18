package model;

public class Alumno {
	
	private int id;
	private String nombre;
	
	/* CONSTRUCTOR */
	public Alumno(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	public Alumno(){
		
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
	
	

}
