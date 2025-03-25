package gameFinder;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class User extends JPanel implements ActionListener{
	
	int anchoVentana = Main.frame.getWidth(),
			altoVentana = Main.frame.getHeight();
	
	JButton X, submit;
	
	@SuppressWarnings("unused")
	private JFrame user;
	public JTextField username;
	//public String usuario = username.getText();
	
public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D gd = (Graphics2D) g;
		
		// MARCO DE PANTALLA
		
		gd.setStroke(new BasicStroke(5));
		gd.setPaint(Color.WHITE);
		gd.drawLine(1, 1, 1, altoVentana);
		gd.drawLine(1, 1, anchoVentana, 1);
		gd.drawLine(1, 498, 698, 498);
		gd.drawLine(698, 1, 698, 498);
		
	}
	
	User(JFrame user) {
		
		this.user = user;
		this.setBackground(new Color(35, 23, 59));
		this.setLayout(null);
		
		// LABEL TEXTO
		
		JLabel ingrese = new JLabel("INGRESE USUARIO:");
		ingrese.setBounds(130, 80, 430, 50);
		ingrese.setFont(loadPixelFont("Hardpixel.OTF", 50));
		ingrese.setForeground(new Color(255, 255, 240));
		this.add(ingrese);
		
		JLabel ingrese1 = new JLabel("INGRESE USUARIO:");
		ingrese1.setBounds(135, 85, 430, 50);
		ingrese1.setFont(loadPixelFont("Hardpixel.OTF", 50));
		ingrese1.setForeground(new Color(227, 212, 75));
		this.add(ingrese1);
		
		JLabel ingrese2 = new JLabel("INGRESE USUARIO:");
		ingrese2.setBounds(140, 90, 430, 50);
		ingrese2.setFont(loadPixelFont("Hardpixel.OTF", 50));
		ingrese2.setForeground(new Color(232, 39, 39));
		this.add(ingrese2);
		
		// JTEXTFIELD PARA EL USUARIO
		
		username = new JTextField();
		username.setBounds(150, 180, 400, 200);
		username.setFont(loadPixelFont("Hardpixel.OTF", 200));
		username.setForeground(new Color(255, 255, 240));
		username.setBackground(new Color(35, 23, 59));
		this.add(username);
		
		// CONDICIONALES DEL USERNAME
		
		/*
		if (usuario.length() > 3) {
			
			
			
		} else if (usuario.length() < 3) {
			
			
			
		} else if (usuario.isEmpty()) {
			
			
			
		}
		*/
		
		// BOTON SUBMIT
		
		ImageIcon sub = new ImageIcon("img/ICONOS/submit.png");
		submit = new JButton(sub);
		submit.setBounds(315, 405, 64, 64);
		submit.setBorderPainted(false);
		submit.setContentAreaFilled(false);
		submit.setFocusPainted(false);
		submit.setOpaque(false);
		submit.addActionListener(this);
		this.add(submit);
		
		// BOTON X
        
        X = new JButton("X");
        X.setBounds(640, 20, 30, 50);
		X.setBackground(null);
		X.setBorder(null);
		X.setFont(loadPixelFont("Hardpixel.OTF", 50));
		X.setForeground(new Color(255, 255, 240));
		X.setBorderPainted(false);
		X.setContentAreaFilled(false);
		X.setFocusPainted(false);
		X.setOpaque(false);
		X.addActionListener(this);
		this.add(X);
		
		JLabel X1 = new JLabel("X");
		X1.setBounds(645, 25, 30, 50);
		X1.setFont(loadPixelFont("Hardpixel.OTF", 50));
		X1.setForeground(new Color(227, 212, 75));
		this.add(X1);
		
		JLabel X2 = new JLabel("X");
		X2.setBounds(650, 30, 30, 50);
		X2.setFont(loadPixelFont("Hardpixel.OTF", 50));
		X2.setForeground(new Color(232, 39, 39));
		this.add(X2);
		
	}
	
	private Font loadPixelFont(String fontFileName, float size) {
		
        try {
            
            File fontFile = new File("fonts/" + fontFileName);
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
            return font.deriveFont(size);
            
        } catch (Exception e) {
        	
            e.printStackTrace();
            return new Font("Arial", Font.PLAIN, (int) size);
            
        }
        
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == X) {
			
			user.dispose();
			Main.frame.setEnabled(true);
			
		}
		
	}

}
