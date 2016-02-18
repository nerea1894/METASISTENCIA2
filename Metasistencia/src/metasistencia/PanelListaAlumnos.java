package metasistencia;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import DAO.AlumnoDAO;
import model.Alumno;

import javax.swing.DefaultListCellRenderer.UIResource;


public class PanelListaAlumnos extends JPanel implements ActionListener{

	FramePrincipal framePrincipal;
	
	private JLabel lListaAlumnos;
	private JButton bAcceder, bFinalizar, bFalta;
	private JList listaAlumnos;
	private JLabel etiResultado;
	private JScrollPane scrollPane;
	private ArrayList<Alumno> alumnos;
	//private JPanel panel;
	//private ArrayList<Alumno> listaAlumnos;
	
	Font fuente = new Font("Century Gothic", Font.BOLD, 20);
	
	public PanelListaAlumnos(JFrame framePrincipal){
	
		//Inicializar
		
		this.setLayout(null);
		
		this.framePrincipal = (FramePrincipal) framePrincipal;
		
		//Recoger alumnos
		AlumnoDAO alumnoDAO = new AlumnoDAO();
		alumnos = new ArrayList<Alumno>();
		alumnos = alumnoDAO.findByAsignatura(this.framePrincipal.asignaturaImpartida.getId());
		
		
		//Creacion de componentes
		lListaAlumnos = new JLabel("Lista Alumnos");
		lListaAlumnos.setFont(fuente);
		bAcceder = new JButton("Ver Alumno");
		bAcceder.setFont(fuente);
		bFinalizar= new JButton("Finalizar Clase");
		bFinalizar.setFont(fuente);
		bFalta= new JButton("Falta");
		bFalta.setFont(fuente);
		
		//Posicionamiento de los componentes
		lListaAlumnos.setBounds(267, 22, 160, 18);
		bAcceder.setBounds(212, 334, 171, 52);
		bFinalizar.setBounds(393, 334, 217, 52);
		bFalta.setBounds(73, 334, 129, 52);
		
		//A�adir al panel los componentes
		this.add(lListaAlumnos);
		this.add(bAcceder);
		this.add(bFinalizar);
		this.add(bFalta);
		
		//metodos listener
		bFalta.addActionListener(this);
		bAcceder.addActionListener(this);
		bFinalizar.addActionListener(this);
		
				//modificar de aqui ha abajo!!!!!!!!!!
				
		etiResultado = new JLabel("etiresultado");
		etiResultado.setFont(fuente);
		etiResultado.setBounds(78, 305, 532, 18);
		this.add(etiResultado);

		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(73, 51, 542, 254);
		this.add(scrollPane);
		
		
		listaAlumnos = new JList();
		listaAlumnos.setFont(fuente);
		
		//se alinean las celdas aL CENTRO
				UIResource posicion = new UIResource();
					posicion.setHorizontalAlignment(SwingConstants.CENTER);	 
					listaAlumnos.setCellRenderer(posicion);

		
		listaAlumnos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String mensaje = "";
								
				for (int i = 0; i < listaAlumnos.getModel().getSize();  i++) {
				if(listaAlumnos.getSelectedIndex()==i){
					mensaje= listaAlumnos.getSelectedValue().toString()+" seleccionado";
				}
				}
				etiResultado.setText(mensaje);

			}
		});

		//Crear un objeto DefaultListModel
		DefaultListModel listModel = new DefaultListModel();
		//Recorrer el contenido del ArrayList
		for(int i=0; i<alumnos.size(); i++) {
		    //A�adir cada elemento del ArrayList en el modelo de la lista
		    listModel.add(i, alumnos.get(i).getNombre());
		}
		//Asociar el modelo de lista al JList
		listaAlumnos.setModel(listModel);
		scrollPane.setViewportView(listaAlumnos);
		

	}
		
		

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(bAcceder)){	//esto es una prueba
			String mensaje = "";
			if(listaAlumnos.getSelectedIndex()==-1){
				mensaje="No hay ningun alumno seleccionado";
			}
			else{
			//mensaje="El alumno seleccionado es: "+ listaAlumnos.getSelectedValue().toString();
				this.framePrincipal.alumnoSeleccionado = alumnos.get(listaAlumnos.getSelectedIndex());
			// ir al alumno info
			this.framePrincipal.cambiarPanel(new PanelAlumno(framePrincipal));

				
			}
			etiResultado.setText(mensaje);
		}
		if(e.getSource().equals(bFalta)){	
			
			//PONER FALTA AL ALUMNO SELECCIONADO"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

			}
		if(e.getSource().equals(bFinalizar)){	
			framePrincipal.cambiarPanel(new PanelAsignatura(framePrincipal));

			}
		
		
		
			
	
	}

}
