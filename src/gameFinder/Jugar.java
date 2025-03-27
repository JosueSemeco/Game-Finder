package gameFinder;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Jugar extends JPanel implements ActionListener{
	
	int anchoVentana = Main.frame.getWidth(),
			altoVentana = Main.frame.getHeight();
	
	public JFrame jugar;
	
	public static JTextField juego;
	public static String nombreJuego = "";
	public static JButton X;
	public static int puntos = 0;
	
public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D gd = (Graphics2D) g;
		
		// MARCO DE PANTALLA
		
		gd.setStroke(new BasicStroke(5));
		gd.setPaint(Color.WHITE);
		gd.drawLine(1, 1, 1, altoVentana);
		gd.drawLine(1, 1, anchoVentana, 1);
		gd.drawLine(1, 818, 1278, 818);
		gd.drawLine(1278, 1, 1278, 818);
		
	}
	
	Jugar(JFrame jugar) {
		
		this.jugar = jugar;
		this.setBackground(new Color(35, 23, 59));
		this.setLayout(null);
		
		// BOTON X
		
		X = new JButton("X");
        X.setBounds(1220, 20, 30, 50);
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
		X1.setBounds(1225, 25, 30, 50);
		X1.setFont(loadPixelFont("Hardpixel.OTF", 50));
		X1.setForeground(new Color(227, 212, 75));
		this.add(X1);
		
		JLabel X2 = new JLabel("X");
		X2.setBounds(1230, 30, 30, 50);
		X2.setFont(loadPixelFont("Hardpixel.OTF", 50));
		X2.setForeground(new Color(232, 39, 39));
		this.add(X2);
		
		// LABEL USUARIO 
		
		JLabel usuario = new JLabel("USER: " + User.usuario);
		usuario.setBounds(25, 25, 175, 30);
		usuario.setFont(loadPixelFont("Hardpixel.OTF", 30));
		usuario.setForeground(new Color(255, 255, 240));
		this.add(usuario);
		
		// LABEL PUNTUACION
		
		JLabel puntuacion = new JLabel("PUNTUACION: " + puntos);
		puntuacion.setBounds(25, 60, 215, 30);
		puntuacion.setFont(loadPixelFont("Hardpixel.OTF", 30));
		puntuacion.setForeground(new Color(255, 255, 240));
		this.add(puntuacion);
		
		// TEXT FIELD NOMBRE DEL JUEGO
		
		// LABEL ?????
		
		JLabel nombreOculto = new JLabel("?????????");
		nombreOculto.setBounds(400, 400, 200, 40);
		nombreOculto.setFont(loadPixelFont("Hardpixel.OTF", 40));
		nombreOculto.setForeground(new Color(255, 255, 240));
		this.add(nombreOculto);
		
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
			
			jugar.dispose();
			Main.frame.setEnabled(true);
			
		}
		
	}

}
