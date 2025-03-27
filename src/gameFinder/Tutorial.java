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

@SuppressWarnings("serial")
public class Tutorial extends JPanel implements ActionListener{
	
	int anchoVentana = Main.frame.getWidth(),
	        altoVentana = Main.frame.getHeight();
	
	@SuppressWarnings("unused")
	public JFrame tutorial;
	
	JButton X;
	
	public void paintComponent(Graphics g) {
    	
        super.paintComponent(g);
        Graphics2D gd = (Graphics2D) g;
        
        // MARCO DE PANTALLA
        
        gd.setStroke(new BasicStroke(5));
        gd.setPaint(Color.WHITE);
        gd.drawLine(1, 1, 1, altoVentana);
        gd.drawLine(1, 1, anchoVentana, 1);
        gd.drawLine(1, 698, 898, 698);
        gd.drawLine(898, 1, 898, 698);
        
    }
	
	Tutorial(JFrame tutorial) {
		
		this.tutorial = tutorial;
		this.setBackground(new Color(35, 23, 59));
		this.setLayout(null);
		
		X = new JButton("X");
        X.setBounds(840, 20, 30, 50);
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
		X1.setBounds(845, 25, 30, 50);
		X1.setFont(loadPixelFont("Hardpixel.OTF", 50));
		X1.setForeground(new Color(227, 212, 75));
		this.add(X1);
		
		JLabel X2 = new JLabel("X");
		X2.setBounds(850, 30, 30, 50);
		X2.setFont(loadPixelFont("Hardpixel.OTF", 50));
		X2.setForeground(new Color(232, 39, 39));
		this.add(X2);
		
		JLabel paso1 = new JLabel("1. SE TE PRESENTARA UNA PORTADA");
		paso1.setBounds(110, 100, 690, 40);
		paso1.setFont(loadPixelFont("Hardpixel.OTF", 40));
		paso1.setForeground(new Color(255, 255, 240));
		this.add(paso1);
		
		JLabel paso11 = new JLabel("DE UN VIDEOJUEGO PIXELADA");
		paso11.setBounds(185, 150, 550, 40);
		paso11.setFont(loadPixelFont("Hardpixel.OTF", 40));
		paso11.setForeground(new Color(255, 255, 240));
		this.add(paso11);
		
		JLabel paso2 = new JLabel("2. TENDRAS 3 INTENTOS PARA ADIVINARLA");
		paso2.setBounds(50, 260, 810, 40);
		paso2.setFont(loadPixelFont("Hardpixel.OTF", 40));
		paso2.setForeground(new Color(255, 255, 240));
		this.add(paso2);
		
		JLabel paso3 = new JLabel("3. SI ACIERTAS, APARECERA OTRA PORTADA");
		paso3.setBounds(42, 385, 830, 40);
		paso3.setFont(loadPixelFont("Hardpixel.OTF", 40));
		paso3.setForeground(new Color(255, 255, 240));
		this.add(paso3);
		
		JLabel paso4 = new JLabel("4. SI FALLAS LOS 3 INTENTOS,");
		paso4.setBounds(150, 500, 900, 40);
		paso4.setFont(loadPixelFont("Hardpixel.OTF", 40));
		paso4.setForeground(new Color(255, 255, 240));
		this.add(paso4);
		
		JLabel paso5 = new JLabel("PERDERAS EL JUEGO");
		paso5.setBounds(250, 550, 390, 40);
		paso5.setFont(loadPixelFont("Hardpixel.OTF", 40));
		paso5.setForeground(new Color(255, 255, 240));
		this.add(paso5);
		
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
			
			tutorial.dispose();
			Main.frame.setEnabled(true);
			
		}
		
	}

}
