package model;

/* CLASE ALUMNO */
public class Alumno {
	
	/* DECLARACION DE COMPONENTES */
	private int id;
	private String nombre;
	private String apellidos;
	
	/* CONSTRUCTOR */
	public Alumno(int id, String nombre, String apellidos) {
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
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	

}
