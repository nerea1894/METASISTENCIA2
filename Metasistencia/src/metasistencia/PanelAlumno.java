package metasistencia;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Alumno;

public class PanelAlumno extends JPanel implements ActionListener{

	FramePrincipal framePrincipal;

	static Alumno alumnoSeleccionado;
	Font fuente = new Font("Century Gothic", Font.BOLD, 20);
	
	public PanelAlumno(JFrame framePrincipal){
	
		//Inicializar
		
		this.setLayout(null);
		
		this.framePrincipal = (FramePrincipal) framePrincipal;
}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}