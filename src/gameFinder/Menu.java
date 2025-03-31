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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Menu extends JPanel implements ActionListener{
	
	int anchoVentana = Main.frame.getWidth(),
			altoVentana = Main.frame.getHeight();
	int vl1 = 5, vl2 = 15, vl3 = 1, vl4 = 10;
	int ancho = 10, alto = 10;
	int r1 = 0, r2 = 143, r3 = 500, r4 = 20, r5 = 20,
			r6 = 20, r7 = 20, r8 = 20, r9 = 20, r10 = 20;
	JButton jugar, tutorial, record, salir, info;
	
public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D gd = (Graphics2D) g;
		
		// PARTICULAS ANIMADAS
		
		gd.setPaint(Color.RED);
		gd.fillRect(r1, 20, ancho, alto);
		
		gd.setPaint(Color.YELLOW);
		gd.fillRect(r2, 175, ancho, alto);
		
		gd.setPaint(Color.CYAN);
		gd.fillRect(r3, 700, ancho, alto);
		
		gd.setPaint(Color.MAGENTA);
		gd.fillRect(r4, 525, ancho, alto);
		
		// MARCO DE PANTALLA
		
		gd.setStroke(new BasicStroke(5));
		gd.setPaint(Color.WHITE);
		gd.drawLine(1, 1, 1, altoVentana);
		gd.drawLine(1, 1, anchoVentana, 1);
		gd.drawLine(1, 818, 1278, 818);
		gd.drawLine(1278, 1, 1278, 818);
		
		// MARCO DEL TITULO
		
		gd.setStroke(new BasicStroke(18));
		
			// MARCO SUPERIOR
		
		gd.setPaint(new Color(232, 39, 39));
		gd.drawLine(530, 40, 530, 110);
		gd.drawLine(530, 40, 600, 40);
		gd.setPaint(new Color(227, 212, 75));
		gd.drawLine(525, 35, 525, 105);
		gd.drawLine(525, 35, 595, 35);
		gd.setPaint(new Color(255, 255, 240));
		gd.drawLine(520, 30, 520, 100);
		gd.drawLine(520, 30, 590, 30);
		
			// MARCO INFERIOR
		
		gd.setPaint(new Color(232, 39, 39));
		gd.drawLine(1220, 310, 1220, 380);
		gd.drawLine(1150, 380, 1220, 380);
		gd.setPaint(new Color(227, 212, 75));
		gd.drawLine(1215, 305, 1215, 375);
		gd.drawLine(1145, 375, 1215, 375);
		gd.setPaint(new Color(255, 255, 240));
		gd.drawLine(1210, 300, 1210, 370);
		gd.drawLine(1140, 370, 1210, 370);
		
	}
	
	Menu() {
		
		Timer timer = new Timer(1, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				r1 += vl1;
				r2 += vl2;
				r3 += vl3;
				r4 += vl4;
				
				if (r1 > anchoVentana) {
					
					r1 = -ancho;
					
				}
				
				if (r2 > anchoVentana) {
					
					r2 = -ancho;
					
				}
				
				if (r3 > anchoVentana) {
					
					r3 = -ancho;
					
				}
				
				if (r4 > anchoVentana) {
					
					r4 = -ancho;
					
				}
				
				repaint();
				
			}
			
		});
		timer.start();
		
		this.setBackground(new Color(26, 38, 59));
		this.setLayout(null);
		
		//LABEL TITULO
		
			// GAME
		
		JLabel game = new JLabel("GAME");
		game.setBounds(550, 50, 450, 135);
		game.setFont(loadPixelFont("Hardpixel.OTF", 175));
		game.setForeground(new Color(255, 255, 240));
		this.add(game);
		
		JLabel game1 = new JLabel("GAME");
		game1.setBounds(555, 55, 450, 135);
		game1.setFont(loadPixelFont("Hardpixel.OTF", 175));
		game1.setForeground(new Color(227, 212, 75));
		this.add(game1);
		
		JLabel game2 = new JLabel("GAME");
		game2.setBounds(560, 60, 450, 135);
		game2.setFont(loadPixelFont("Hardpixel.OTF", 175));
		game2.setForeground(new Color(232, 39, 39));
		this.add(game2);
		
			// FINDER
		
		JLabel finder = new JLabel("FINDER");
		finder.setBounds(625, 200, 560, 135);
		finder.setFont(loadPixelFont("Hardpixel.OTF", 175));
		finder.setForeground(new Color(255, 255, 240));
		this.add(finder);
		
		JLabel finder1 = new JLabel("FINDER");
		finder1.setBounds(630, 205, 560, 135);
		finder1.setFont(loadPixelFont("Hardpixel.OTF", 175));
		finder1.setForeground(new Color(227, 212, 75));
		this.add(finder1);
		
		JLabel finder2 = new JLabel("FINDER");
		finder2.setBounds(635, 210, 560, 135);
		finder2.setFont(loadPixelFont("Hardpixel.OTF", 175));
		finder2.setForeground(new Color(232, 39, 39));
		this.add(finder2);
		
		// BUTTON JUGAR
		
		jugar = new JButton("JUGAR");
		jugar.setBounds(25, 370, 385, 95);
		jugar.setBackground(null);
		jugar.setBorder(null);
		jugar.setFont(loadPixelFont("Hardpixel.OTF", 130));
		jugar.setForeground(new Color(255, 255, 240));
		jugar.setBorderPainted(false);
		jugar.setContentAreaFilled(false);
		jugar.setFocusPainted(false);
		jugar.setOpaque(false);
		jugar.addActionListener(this);
		this.add(jugar);
		
		JLabel jugar1 = new JLabel("JUGAR");
		jugar1.setBounds(30, 375, 385, 95);
		jugar1.setFont(loadPixelFont("Hardpixel.OTF", 130));
		jugar1.setForeground(new Color(227, 212, 75));
		this.add(jugar1);
		
		JLabel jugar2 = new JLabel("JUGAR");
		jugar2.setBounds(35, 380, 385, 95);
		jugar2.setFont(loadPixelFont("Hardpixel.OTF", 130));
		jugar2.setForeground(new Color(232, 39, 39));
		this.add(jugar2);
		
		// BUTTON TUTORIAL
		
		tutorial = new JButton("TUTORIAL");
		tutorial.setBounds(22, 505, 340, 65);
		tutorial.setBackground(null);
		tutorial.setBorder(null);
		tutorial.setFont(loadPixelFont("Hardpixel.OTF", 75));
		tutorial.setForeground(new Color(255, 255, 240));
		tutorial.setBorderPainted(false);
		tutorial.setContentAreaFilled(false);
		tutorial.setFocusPainted(false);
		tutorial.setOpaque(false);
		tutorial.addActionListener(this);
		this.add(tutorial);
		
		JLabel tutorial1 = new JLabel("TUTORIAL");
		tutorial1.setBounds(27, 510, 340, 65);
		tutorial1.setFont(loadPixelFont("Hardpixel.OTF", 75));
		tutorial1.setForeground(new Color(227, 212, 75));
		this.add(tutorial1);
		
		JLabel tutorial2 = new JLabel("TUTORIAL");
		tutorial2.setBounds(32, 515, 340, 65);
		tutorial2.setFont(loadPixelFont("Hardpixel.OTF", 75));
		tutorial2.setForeground(new Color(232, 39, 39));
		this.add(tutorial2);
		
		// BUTTON RECORD 
		
		record = new JButton("RECORD");
		record.setBounds(35, 605, 230, 55);
		record.setBackground(null);
		record.setBorder(null);
		record.setFont(loadPixelFont("Hardpixel.OTF", 65));
		record.setForeground(new Color(255, 255, 240));
		record.setBorderPainted(false);
		record.setContentAreaFilled(false);
		record.setFocusPainted(false);
		record.setOpaque(false);
		record.addActionListener(this);
		this.add(record);
				
		JLabel record1 = new JLabel("RECORD");
		record1.setBounds(40, 610, 230, 55);
		record1.setFont(loadPixelFont("Hardpixel.OTF", 65));
		record1.setForeground(new Color(227, 212, 75));
		this.add(record1);
				
		JLabel record2 = new JLabel("RECORD");
		record2.setBounds(45, 615, 230, 55);
		record2.setFont(loadPixelFont("Hardpixel.OTF", 65));
		record2.setForeground(new Color(232, 39, 39));
		this.add(record2);
				
		// BUTTON SALIR
		
		salir = new JButton("SALIR");
		salir.setBounds(35, 690, 150, 55);
		salir.setBackground(null);
		salir.setBorder(null);
		salir.setFont(loadPixelFont("Hardpixel.OTF", 55));
		salir.setForeground(new Color(255, 255, 240));
		salir.setBorderPainted(false);
		salir.setContentAreaFilled(false);
		salir.setFocusPainted(false);
		salir.setOpaque(false);
		salir.addActionListener(this);
		this.add(salir);
		
		JLabel salir1 = new JLabel("SALIR");
		salir1.setBounds(40, 695, 150, 55);
		salir1.setFont(loadPixelFont("Hardpixel.OTF", 55));
		salir1.setForeground(new Color(227, 212, 75));
		this.add(salir1);
		
		JLabel salir2 = new JLabel("SALIR");
		salir2.setBounds(45, 700, 150, 55);
		salir2.setFont(loadPixelFont("Hardpixel.OTF", 55));
		salir2.setForeground(new Color(232, 39, 39));
		this.add(salir2);
		
		// BUTTON INFO
		
		ImageIcon inf = new ImageIcon("img/ICONOS/info.png");
		info = new JButton(inf);
		info.setBounds(1150, 690, 100, 101);
		info.setBorderPainted(false);
		info.setContentAreaFilled(false);
		info.setFocusPainted(false);
		info.setOpaque(false);
		info.addActionListener(this);
		this.add(info);
		
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

	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == info) {
			
			InformacionFrame info = new InformacionFrame();
			Main.frame.setEnabled(false);
			
		}
		
		if (e.getSource() == salir) {
			
			SalirFrame salir = new SalirFrame();
			Main.frame.setEnabled(false);
			
		}
		
		if (e.getSource() == tutorial) {
			
			TutorialFrame tutorial = new TutorialFrame();
			Main.frame.setEnabled(false);
			
		}
		
		if (e.getSource() == jugar) {
			
			UserFrame user = new UserFrame();
			Main.frame.setEnabled(false);
			
		}
		
		if (e.getSource() == record) {
			
			RecordFrame record = new RecordFrame();
			Main.frame.setEnabled(false);
			
		}
		
	}

}
