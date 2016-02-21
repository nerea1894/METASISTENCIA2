package metasistencia;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DAO.AsignaturaDAO;
import model.Asignatura;
import model.Falta;


public class PanelAsignatura extends JPanel implements ActionListener {

	//Declaracion de componentes
			FramePrincipal framePrincipal;
			
			private JLabel lAsignatura;
			private JButton bAcceder, bDesconectar;
			private JComboBox cAsignatura;
			private ArrayList<Asignatura> asignaturas;
			
			private Font fuente = new Font("Century Gothic", Font.BOLD, 20);
						
			/*Constructor*/
	
	public PanelAsignatura(JFrame framePrincipal){
		
		//Inicializar
		this.setLayout(null);
		this.framePrincipal = (FramePrincipal) framePrincipal;
		
		
		//Recoger las asignaturas
		this.asignaturas = new ArrayList<Asignatura>();
		AsignaturaDAO asignaturaDAO = new AsignaturaDAO();
		this.asignaturas = asignaturaDAO.findByProfesor(this.framePrincipal.profesorConectado.getId());
		String[] nombreAsignatura = new String[asignaturas.size()];
		for(int i=0; i<asignaturas.size(); i++){
			nombreAsignatura[i] = asignaturas.get(i).getNombre();
		}
		
		//Creacion de componentes
		lAsignatura = new JLabel("ASIGNATURA");
		lAsignatura.setFont(fuente);
		cAsignatura = new JComboBox(nombreAsignatura);
		cAsignatura.setFont(fuente);
		bAcceder = new JButton("Empezar clase");
		bAcceder.setFont(fuente);
		bDesconectar = new JButton("Desconectar");
		bDesconectar.setFont(fuente);
		
		
		//Posicionamiento de los componentes
		cAsignatura.setBounds(116, 133, 478, 43);		
		bAcceder.setBounds(116, 240, 247, 52);
		lAsignatura.setBounds(284, 52, 146, 28);
		bDesconectar.setBounds(387,240,207,52);
		
		
		//Añadir al panel los componentes
		this.add(cAsignatura);
		this.add(bAcceder);
		this.add(lAsignatura);
		this.add(bDesconectar);
		
		cAsignatura.setSelectedItem(2);
		
		//metodos listener
		cAsignatura.addActionListener(this);
		bAcceder.addActionListener(this);
		bDesconectar.addActionListener(this);
		
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(bAcceder)){
			
			framePrincipal.asignaturaImpartida = this.asignaturas.get(cAsignatura.getSelectedIndex());
			framePrincipal.cambiarPanel(new PanelListaAlumnos(framePrincipal));
		}
		
		if(e.getSource().equals(bDesconectar)){
			
			framePrincipal.cambiarPanel(new PanelLogin(framePrincipal));
		}
		}


}
