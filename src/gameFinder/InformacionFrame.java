package gameFinder;

import java.awt.Color;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class InformacionFrame extends JFrame{
	
	InformacionFrame() {
		
		this.setSize(700, 800);
		this.setTitle("INFORMACION");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(rootPane);
		this.getContentPane().setBackground(Color.BLACK);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setLayout(null);
		
		Informacion inf = new Informacion(this);
		inf.setBounds(0, 0, 700, 800);
		this.add(inf);
		
		this.setVisible(true);
		
	}

}
