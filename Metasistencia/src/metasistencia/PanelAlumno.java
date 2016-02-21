package metasistencia;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import model.Alumno;

public class PanelAlumno extends JPanel implements ActionListener{

	FramePrincipal framePrincipal;

	private JButton bAmonestacion, bVolver, bFalta, bNota;
	private JLabel nombreAlumno,alumno,imagen;

	
	static Alumno alumnoSeleccionado;
	Font fuente = new Font("Century Gothic", Font.BOLD, 20);
	
	public PanelAlumno(JFrame framePrincipal){
	
		//Inicializar
		
		this.setLayout(null);
		
		this.framePrincipal = (FramePrincipal) framePrincipal;
		
		//Recoger alumnos
		
		
		
		//Creacion de componentes
		
		alumno = new JLabel("alumnoseleccionado");
		alumno.setFont(fuente);
		nombreAlumno = new JLabel("Alumno:");
		nombreAlumno.setFont(fuente);
		bAmonestacion = new JButton("Poner Amonestacion");
		bAmonestacion.setFont(fuente);
		bVolver= new JButton("Volver");
		bVolver.setFont(fuente);
		bFalta= new JButton("Poner Falta");
		bFalta.setFont(fuente);
		bNota= new JButton("Poner notas");
		bNota.setFont(fuente);
		imagen = new JLabel(new ImageIcon("G:\\Clase\\Desarrollo de interfaces\\Proyecto_MetAsistencia\\METASISTENCIA2\\Metasistencia\\src\\img\\union europea.jpg"));
		//new ImageIcon(".\\img\\iesnum1.png"));
		
		
		//Posicionamiento de los componentes
		alumno.setBounds(55, 94, 246, 18);
		nombreAlumno.setBounds(55, 59, 160, 18);
		bAmonestacion.setBounds(353, 97, 299, 52);
		bVolver.setBounds(55, 285, 171, 52);
		bFalta.setBounds(353, 187, 299, 52);
		bNota.setBounds(353, 285, 299, 52);
		imagen.setBounds(new Rectangle(525, 0, 160, 86));
		
		
		//A�adir al panel los componentes
		this.add(alumno);
		this.add(nombreAlumno);
		this.add(bAmonestacion);
		this.add(bVolver);
		this.add(bFalta);
		this.add(bNota);
		this.add(imagen);
		
		//metodos listener
		bAmonestacion.addActionListener(this);
		bVolver.addActionListener(this);
		bFalta.addActionListener(this);
		bNota.addActionListener(this);

		
}
	/*metdo para a�adir amonestacion a un alumno*/
	public void ponerAmonestacion(){
	
		 String amonestacion;

	        Box box = Box.createVerticalBox();
	        JRadioButton r1 = new JRadioButton("Faltar el respeto");
	        JRadioButton r2 = new JRadioButton("Acci�n impropia, improcedente o indebida");
	        JRadioButton r3 = new JRadioButton("Uso indebido de instalaciones o material intencionadamente");
	        box.add(r1);
	        box.add(r2);
	        box.add(r3);
	        ButtonGroup group = new ButtonGroup();
	        group.add(r1);
	        group.add(r2);
	        group.add(r3);

	        Object[] options = { "Aceptar", "Cancerlar" };
	        int opc = JOptionPane.showOptionDialog(null, box, "Poner amonestacion",
	        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
	        null, options, options[0]);
	        
	        if(JOptionPane.OK_OPTION ==opc){
	        	if(r1.isSelected()){
	        		JOptionPane.showMessageDialog(null, "A�adida amonestacion: "+r1.getText());
	        		amonestacion = r1.getText();
		        }
	        	else if(r2.isSelected()){
	        		JOptionPane.showMessageDialog(null, "A�adida amonestacion: "+r2.getText());
	     	   		amonestacion = r2.getText();
	        	}
	        	else if(r3.isSelected()){
	        		JOptionPane.showMessageDialog(null, "A�adida amonestacion: "+r3.getText());
	     	   		amonestacion = r3.getText();
	        	}
	        	
	        		   		//ponerrrrrr amonestacion al aalumno !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1

	        }		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(bNota)){	
			
				//this.framePrincipal.alumnoSeleccionado;
				this.framePrincipal.cambiarPanel(new PanelNota(framePrincipal));

		}
		if(e.getSource().equals(bFalta)){	
			
			//PONER FALTA AL ALUMNO SELECCIONADO"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			}
	if(e.getSource().equals(bAmonestacion)){	
			
		
			ponerAmonestacion();

			//PONER amonestacion AL ALUMNO SELECCIONADO"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

			}
		
		if(e.getSource().equals(bVolver)){	
			
			framePrincipal.cambiarPanel(new PanelListaAlumnos(framePrincipal));

			}
		
	}
}