package gameFinder;

import java.awt.Color;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class TutorialFrame extends JFrame{
	
	TutorialFrame() {
		
		this.setSize(900, 700);
		this.setTitle("TUTORIAL");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(rootPane);
		this.getContentPane().setBackground(Color.BLACK);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setLayout(null);
		
		Tutorial tutorial = new Tutorial(this);
		tutorial.setBounds(0, 0, 900, 700);
		this.add(tutorial);
		
		this.setVisible(true);
		
	}

}
