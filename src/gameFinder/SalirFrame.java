package gameFinder;

import java.awt.Color;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class SalirFrame extends JFrame{
	
	SalirFrame() {
		
		this.setSize(700, 500);
		this.setTitle("SALIENDO");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(rootPane);
		this.getContentPane().setBackground(Color.BLACK);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setLayout(null);
		
		Salir exit = new Salir(this);
		exit.setBounds(0, 0, 700, 500);
		this.add(exit);
		
		this.setVisible(true);
		
	}

}
