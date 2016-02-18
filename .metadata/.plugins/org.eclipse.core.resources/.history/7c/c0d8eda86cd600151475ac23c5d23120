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
	private JList<String> listaAlumnos;
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
		bAcceder = new JButton("Acceder");
		bFinalizar= new JButton("Finalizar Clase");
		bFalta= new JButton("Falta");
		
		//Posicionamiento de los componentes
		lListaAlumnos.setBounds(23, 55, 331, 18);
		bAcceder.setBounds(168, 95, 105, 18);
		bFinalizar.setBounds(63, 124, 181, 18);
		bFalta.setBounds(53, 95, 85, 18);
		
		//Añadir al panel los componentes
		this.add(lListaAlumnos);
		this.add(bAcceder);
		this.add(bFinalizar);
		this.add(bFalta);
		
		//metodos listener
				bFalta.addActionListener(this);
				bAcceder.addActionListener(this);
				bFinalizar.addActionListener(this);
		
		etiResultado = new JLabel("etiresultado");
		etiResultado.setFont(new Font("Century Gothic", Font.BOLD, 13));
		etiResultado.setBounds(23, 235, 331, 18);
		this.add(etiResultado);

		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 113, 347, 201);
		
		
		listaAlumnos = new JList<String>();
		
		listaAlumnos.setFont(new Font("Century Gothic", Font.BOLD, 13));
		
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
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		//Recorrer el contenido del ArrayList
		for(int i=0; i<alumnos.size(); i++) {
		    //Añadir cada elemento del ArrayList en el modelo de la lista
		    listModel.add(i, alumnos.get(i).getNombre());
		}
		//Asociar el modelo de lista al JList
		listaAlumnos.setModel(listModel);
		scrollPane.setViewportView(listaAlumnos);
		

	}
		
		
		
		
		/*panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(20, 214, 347, 37);
		contentPane.add(panel);
		panel.setLayout(null);
		
		etiResultado = new JLabel("");
		etiResultado.setBounds(10, 11, 331, 14);
		panel.add(etiResultado);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 38, 178, 123);
		contentPane.add(scrollPane);

		listaAlumnos = new JList();
		listaAlumnos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String mensaje = "";
				if(listaAlumnos.getSelectedIndex()==0){
					mensaje="El color seleccionado es: "+ listaAlumnos.getSelectedValue().toString();
				}
				if(listaAlumnos.getSelectedIndex()==1){
					mensaje="El color seleccionado es: "+ listaAlumnos.getSelectedValue().toString();
				}
				if(listaAlumnos.getSelectedIndex()==2){
					mensaje="El color seleccionado es: "+ listaAlumnos.getSelectedValue().toString();
				}
				
				etiResultado.setText(mensaje);

			}
		});
		listaAlumnos.setModel(new AbstractListModel() {
			String[] values = new String[] {"Rojo", "Verde", "Azul"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(listaAlumnos);
	}
		
	}*/

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
