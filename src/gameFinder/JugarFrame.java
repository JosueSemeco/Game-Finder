package gameFinder;

import java.awt.Color;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class JugarFrame extends JFrame{
	
	JugarFrame() {
		
		this.setSize(1280, 820);
		this.setTitle("GAME FINDER");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(rootPane);
		this.getContentPane().setBackground(Color.BLACK);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setLayout(null);
		
		Jugar jugar = new Jugar(this);
		jugar.setBounds(0, 0, 1280, 820);
		this.add(jugar);
		
		this.setVisible(true);
		
	}

}
