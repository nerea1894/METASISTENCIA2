package metasistencia;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Alumno;

public class PanelNota extends JPanel implements ActionListener{

	FramePrincipal framePrincipal;

	private JButton bGuardar, bCancelar;
	private JLabel lnombreAlumno,ltri1,ltri2,ltri3, lnotaExtraordinaria, lnotas;
	private JTextField tftri1,tftri2,tftri3, tfnotaExtraordinaria;

	
	static Alumno alumnoSeleccionado;
	Font fuente = new Font("Century Gothic", Font.BOLD, 20);
	
	public PanelNota(JFrame framePrincipal){
	
		//Inicializar
		
		this.setLayout(null);
		
		this.framePrincipal = (FramePrincipal) framePrincipal;
		
		//Recoger alumnos
		
		
		
		//Creacion de componentes		
				lnotas = new JLabel("Notas");
				lnotas.setFont(fuente);
				lnombreAlumno = new JLabel("alumnoseleccionado");
				lnombreAlumno.setFont(fuente);
				ltri1 = new JLabel("1� Trimestre");
				ltri1.setFont(fuente);
				ltri2 = new JLabel("2\u00BA Trimestre");
				ltri2.setFont(fuente);
				ltri3 = new JLabel("3� Trimestre");
				ltri3.setFont(fuente);
				lnotaExtraordinaria = new JLabel("Nota extraordinaria");
				lnotaExtraordinaria.setFont(fuente);
				
				tftri1 = new JTextField();
				tftri1.setFont(fuente);
				tftri2 = new JTextField();
				tftri2.setFont(fuente);
				tftri3 = new JTextField();
				tftri3.setFont(fuente);
				tfnotaExtraordinaria = new JTextField();
				tfnotaExtraordinaria.setFont(fuente);
				
				bGuardar = new JButton("Guardar");
				bGuardar.setFont(fuente);
				bCancelar = new JButton("Cancelar");
				bCancelar.setFont(fuente);
				
				//Posicionamiento de los componentes
				lnotas.setBounds(309, 11, 72, 18);
				lnombreAlumno.setBounds(24, 40, 246, 18);
				ltri1.setBounds(35, 89, 172, 18);
				ltri2.setBounds(242, 89, 139, 18);
				ltri3.setBounds(466, 89, 219, 18);
				lnotaExtraordinaria.setBounds(242, 205, 200, 18);
				
				tftri1.setBounds(35, 118, 172, 33);
				tftri2.setBounds(242, 118, 188, 33);
				tftri3.setBounds(466, 118, 187, 33);
				tfnotaExtraordinaria.setBounds(242, 234, 200, 33);

				bGuardar.setBounds(444, 316, 188, 52);
				bCancelar.setBounds(54, 316, 171, 52);
				
				//A�adir al panel los componentes
				this.add(lnotas);
				this.add(lnombreAlumno);
				this.add(ltri1);
				this.add(ltri2);
				this.add(ltri3);
				this.add(lnotaExtraordinaria);

				this.add(tftri1);
				this.add(tftri2);
				this.add(tftri3);
				this.add(tfnotaExtraordinaria);

				this.add(bGuardar);
				this.add(bCancelar);

				
				//metodos listener
				bGuardar.addActionListener(this);
				bCancelar.addActionListener(this);

				

				
}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(bGuardar)){	
			
				//this.framePrincipal.alumnoSeleccionado;
				this.framePrincipal.cambiarPanel(new PanelAlumno(framePrincipal));

		}
		if(e.getSource().equals(bCancelar)){	
			
			this.framePrincipal.cambiarPanel(new PanelAlumno(framePrincipal));

		}
		
	}
}
