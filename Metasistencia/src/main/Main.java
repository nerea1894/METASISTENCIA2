package main;

import javax.swing.JFrame;

import metasistencia.FramePrincipal;

/* CLASE MAIN */
public class Main {
	
	public static void main(String[]args){
		
		FramePrincipal frame =  new FramePrincipal();
		
		frame.setVisible(true);
		frame.setSize(700,455); //No redimensionable
		frame.setLocationRelativeTo(null);		
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
