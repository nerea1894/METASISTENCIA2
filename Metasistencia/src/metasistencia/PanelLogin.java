package metasistencia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DAO.AsignaturaDAO;
import DAO.ProfesorDAO;
import metodos.Contrasenya;
import model.Asignatura;
import model.Profesor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class PanelLogin extends JPanel implements ActionListener{

	//Declaracion de componentes
		FramePrincipal framePrincipal;
		
		private JLabel lProfesor, lContrasenya;
		private JButton bAcceder;
		private JPasswordField tfPass;
		private JLabel imagen, imagen1, imagen2;
		private JComboBox cProfesor;

		Font fuente = new Font("Century Gothic", Font.BOLD, 20);
		
		/*Constructor*/
		@SuppressWarnings("unchecked")
		public PanelLogin(JFrame framePrincipal){
			addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tfPass.setBackground(Color.white);
				}
			});
								
						
			//Recoger todos los profesores
			ProfesorDAO profesorDAO = new ProfesorDAO();
			ArrayList<Profesor> profesores = new ArrayList<Profesor>(); 
			profesores = profesorDAO.findAll();
			String[] arrayProfesores = new String[profesores.size()];
				for(int i=0;i<profesores.size();i++){
					arrayProfesores[i] = profesores.get(i).getNombre();
				}
			
			//Inicializar
			this.setLayout(null);
			this.framePrincipal = (FramePrincipal) framePrincipal;
			
			
			//Creacion de componentes
			cProfesor = new JComboBox(arrayProfesores);
			cProfesor.setFont(fuente);
			tfPass = new JPasswordField();
			tfPass.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					tfPass.setBackground(Color.green);
				}
			});

			bAcceder = new JButton("Acceder");
			bAcceder.setFont(fuente);
			lProfesor = new JLabel("Profesor");
			lProfesor.setFont(fuente);
			lContrasenya = new JLabel("Contrase�a");
			lContrasenya.setFont(fuente);
			imagen = new JLabel(new ImageIcon(".\\img\\iesnum1.png"));
			imagen1 = new JLabel(new ImageIcon(".\\img\\union europea.jpg"));
			imagen2 = new JLabel(new ImageIcon(".\\img\\Generalitat-Valenciana.png"));
			
			//Posicionamiento de los componentes
			cProfesor.setBounds(306, 137, 237, 43);		
			tfPass.setBounds(306, 200, 237, 28);
			bAcceder.setBounds(266, 275, 143, 52);
			lProfesor.setBounds(116, 144, 130, 28); 
			lContrasenya.setBounds(116, 200, 130, 28);
			imagen.setBounds(new Rectangle(276, 3, 157, 88));
			imagen1.setBounds(new Rectangle(554, 3, 113, 88));
			imagen2.setBounds(new Rectangle(10, 3, 167, 78));

			
			//A�adir al panel los componentes
			this.add(cProfesor);
			this.add(tfPass);
			this.add(bAcceder);
			this.add(lProfesor);
			this.add(lContrasenya);
			this.add(imagen);	
			this.add(imagen1);
			this.add(imagen2);
			
			//metodos listener
			bAcceder.addActionListener(this);
	}
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(bAcceder)){
				
				ProfesorDAO profesorDAO = new ProfesorDAO();
				AsignaturaDAO asignaturaDAO = new AsignaturaDAO();
				Profesor profesor = new Profesor();


				String user, pass = null;
				user = cProfesor.getSelectedItem().toString();
				try {
					pass = Contrasenya.encriptarContrasenya(String.valueOf(tfPass.getPassword()));
				} catch (NoSuchAlgorithmException e1) {
					e1.printStackTrace();
				}
				profesor = profesorDAO.check_login(user, pass);

				if (profesor == null) {
					Object[] textoError = { "Ok" };

					JOptionPane.showMessageDialog(null,
							"Usuario y Contrase�a no corresponden.", "Inane error",
							JOptionPane.ERROR_MESSAGE);
					
					tfPass.setText("");
				} else {
					this.framePrincipal.profesorConectado = profesor;
					framePrincipal.cambiarPanel(new PanelAsignatura(framePrincipal));
				}			
			}
		}
			

}
