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
public class Salir extends JPanel implements ActionListener{
	
	int anchoVentana = Main.frame.getWidth(),
			altoVentana = Main.frame.getHeight();
	
	JButton si, no;
	
	public JFrame salir;
	
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
	
	Salir(JFrame salir) {
		
		this.salir = salir;
		this.setBackground(new Color(35, 23, 59));
		this.setLayout(null);
		
		// LABEL TEXTO
		
		JLabel texto = new JLabel("DESEAS SALIR?");
		texto.setBounds(45, 100, 610, 100);
		texto.setFont(loadPixelFont("Hardpixel.OTF", 85));
		texto.setForeground(new Color(255, 255, 240));
		this.add(texto);
		
		JLabel texto1 = new JLabel("DESEAS SALIR?");
		texto1.setBounds(50, 105, 610, 100);
		texto1.setFont(loadPixelFont("Hardpixel.OTF", 85));
		texto1.setForeground(new Color(227, 212, 75));
		this.add(texto1);
		
		JLabel texto2 = new JLabel("DESEAS SALIR?");
		texto2.setBounds(55, 110, 610, 100);
		texto2.setFont(loadPixelFont("Hardpixel.OTF", 85));
		texto2.setForeground(new Color(232, 39, 39));
		this.add(texto2);
		
		// BUTTON SI
		
		si = new JButton("SI");
		si.setBounds(175, 320, 60, 65);
		si.setBackground(null);
		si.setBorder(null);
		si.setFont(loadPixelFont("Hardpixel.OTF", 65));
		si.setForeground(new Color(255, 255, 240));
		si.setBorderPainted(false);
		si.setContentAreaFilled(false);
		si.setFocusPainted(false);
		si.setOpaque(false);
		si.addActionListener(this);
		this.add(si);
		
		JLabel si1 = new JLabel("SI");
		si1.setBounds(180, 325, 60, 65);
		si1.setFont(loadPixelFont("Hardpixel.OTF", 65));
		si1.setForeground(new Color(227, 212, 75));
		this.add(si1);
		
		JLabel si2 = new JLabel("SI");
		si2.setBounds(185, 330, 60, 65);
		si2.setFont(loadPixelFont("Hardpixel.OTF", 65));
		si2.setForeground(new Color(232, 39, 39));
		this.add(si2);
		
		// BUTTON NO
		
		no = new JButton("NO");
		no.setBounds(425, 320, 80, 65);
		no.setBackground(null);
		no.setBorder(null);
		no.setFont(loadPixelFont("Hardpixel.OTF", 65));
		no.setForeground(new Color(255, 255, 240));
		no.setBorderPainted(false);
		no.setContentAreaFilled(false);
		no.setFocusPainted(false);
		no.setOpaque(false);
		no.addActionListener(this);
		this.add(no);
		
		JLabel no1 = new JLabel("NO");
		no1.setBounds(430, 325, 80, 65);
		no1.setFont(loadPixelFont("Hardpixel.OTF", 65));
		no1.setForeground(new Color(227, 212, 75));
		this.add(no1);
			
		JLabel no2 = new JLabel("NO");
		no2.setBounds(435, 330, 80, 65);
		no2.setFont(loadPixelFont("Hardpixel.OTF", 65));
		no2.setForeground(new Color(232, 39, 39));
		this.add(no2);
		
		
		
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
		
		if (e.getSource() == si) {
			
			System.exit(0);
			
		} else if (e.getSource() == no) {
			
			salir.dispose();
			Main.frame.setEnabled(true);
			
		}
		
	}

}
