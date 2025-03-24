package gameFinder;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main {
	
	public static JFrame frame;
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		frame = new JFrame();
		frame.setSize(1280, 820);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setTitle("GAME FINDER");
		frame.setUndecorated(true);
		frame.getContentPane().setBackground(Color.black);
		
		ImageIcon icon = new ImageIcon("img/ICONOS/icon.png");
		frame.setIconImage(icon.getImage());
		
		Menu menu = new Menu();
		frame.add(menu);
		
		frame.setVisible(true);

	}

}
