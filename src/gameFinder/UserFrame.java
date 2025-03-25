package gameFinder;

import java.awt.Color;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class UserFrame extends JFrame{
	
	UserFrame() {
		
		this.setSize(700, 500);
		this.setTitle("USUARIO");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(rootPane);
		this.getContentPane().setBackground(Color.BLACK);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setLayout(null);
		
		User user = new User(this);
		user.setBounds(0, 0, 700, 500);
		this.add(user);
		
		this.setVisible(true);
		
	}

}
