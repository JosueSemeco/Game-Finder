package gameFinder;

//Hola

import java.awt.Color;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class TutorialFrame extends JFrame{
	
	TutorialFrame() {
		
		this.setSize(700, 800);
		this.setTitle("TUTORIAL");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(rootPane);
		this.getContentPane().setBackground(Color.BLACK);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setLayout(null);
		
		this.setVisible(true);
		
	}

}
