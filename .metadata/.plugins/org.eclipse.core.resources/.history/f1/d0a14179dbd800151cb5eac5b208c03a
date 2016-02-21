package metasistencia;

import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Alumno;
import model.Asignatura;
import model.Profesor;

public class FramePrincipal extends JFrame{
	
	static PanelLogin panelInicio;
	
	public Profesor profesorConectado = new Profesor();
	public Asignatura asignaturaImpartida = new Asignatura();
	public Alumno alumnoSeleccionado = new Alumno();
	
	public FramePrincipal(){

	
	setTitle("MetAsistencia");
	this.setLayout(null);
	panelInicio = new PanelLogin(this);
	panelInicio.setLayout(null);
	this.setContentPane(panelInicio);
	panelInicio.setVisible(true);
	

	
	
	}
	
	//Cambios de panel
	public void cambiarPanel(JPanel panel){
		this.getContentPane().setVisible(false);
		panel.setBounds(this.getBounds());
		this.setContentPane(panel);
		panel.setVisible(true);
	}

}