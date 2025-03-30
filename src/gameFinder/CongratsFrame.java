package gameFinder;

import java.awt.Color;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class CongratsFrame extends JFrame{
	
	CongratsFrame() {
		
		this.setSize(600, 400);
		this.setTitle("FELICIDADES");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(rootPane);
		this.getContentPane().setBackground(Color.BLACK);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setLayout(null);
		
		Congrats win = new Congrats(this);
		win.setBounds(0, 0, 600, 400);
		this.add(win);
		
		this.setVisible(true);
		
	}

}
