package gameFinder;

import java.awt.Color;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class DefeatFrame extends JFrame{
	
	DefeatFrame() {
		
		this.setSize(600, 400);
		this.setTitle("GAME OVER");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(rootPane);
		this.getContentPane().setBackground(Color.BLACK);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setLayout(null);
		
		Defeat def = new Defeat(this);
		def.setBounds(0, 0, 600, 400);
		this.add(def);
		
		this.setVisible(true);
		
	}

}
