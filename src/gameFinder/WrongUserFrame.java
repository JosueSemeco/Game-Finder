package gameFinder;

import java.awt.Color;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class WrongUserFrame extends JFrame{
	
	WrongUserFrame() {
		
		this.setSize(600, 400);
		this.setTitle("SALIENDO");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(rootPane);
		this.getContentPane().setBackground(Color.BLACK);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setLayout(null);
		
		WrongUser wrong = new WrongUser(this);
		wrong.setBounds(0, 0, 600, 400);
		this.add(wrong);
		
		this.setVisible(true);
		
	}

}
