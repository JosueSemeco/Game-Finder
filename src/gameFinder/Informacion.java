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
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Informacion extends JPanel implements ActionListener {
	
	
    
    int anchoVentana = Main.frame.getWidth(),
        altoVentana = Main.frame.getHeight();
    
    JLabel josue, finol, ale, profe, seccion, materia, fecha;
    
    JButton X;
    
    int josueY = 800, finolY = 850, aleY = 900, 
        profeY = 1050, seccionY = 1100, materiaY = 1150, 
        fechaY = 1300, marcaY = 1345;
    
    int deltaY = 5, fuente = 50;
    
    @SuppressWarnings("unused")
    public JFrame info;
    
    public void paintComponent(Graphics g) {
    	
        super.paintComponent(g);
        Graphics2D gd = (Graphics2D) g;
        
        // MARCO DE PANTALLA
        
        gd.setStroke(new BasicStroke(5));
        gd.setPaint(Color.WHITE);
        gd.drawLine(1, 1, 1, altoVentana);
        gd.drawLine(1, 1, anchoVentana, 1);
        gd.drawLine(1, 798, 698, 798);
        gd.drawLine(698, 1, 698, 798);
        
        // MARCA DE REPETICION
        
        gd.setStroke(new BasicStroke(1));
        gd.drawRect(350, marcaY, 1, 1);
        
    }
    
    public Informacion(JFrame info) {
        
        this.info = info;
        this.setBackground(new Color(35, 23, 59));
        this.setLayout(null);
        
        // LABEL JOSUE SEMECO
        
        josue = new JLabel("JOSUE SEMECO");
        josue.setBounds(175, josueY, 355, fuente);
        josue.setFont(loadPixelFont("Hardpixel.OTF", 50));
        josue.setForeground(new Color(255, 255, 240));
        this.add(josue);
        
        // LABEL JOSE FINOL
        
        finol = new JLabel("JOSE FINOL");
        finol.setBounds(215, finolY, 275, 50);
        finol.setFont(loadPixelFont("Hardpixel.OTF", fuente));
        finol.setForeground(new Color(255, 255, 240));
        this.add(finol);
        
        // LABEL ALEJANDRA MARTINEZ
        
        ale = new JLabel("ALEJANDRA MARTINEZ");
        ale.setBounds(95, aleY, 525, 50);
        ale.setFont(loadPixelFont("Hardpixel.OTF", fuente));
        ale.setForeground(new Color(255, 255, 240));
        this.add(ale);
        
        // LABEL PROFESOR JORGE ROMERO
        
        profe = new JLabel("PROFESOR JORGE ROMERO");
        profe.setBounds(45, profeY, 620, 50);
        profe.setFont(loadPixelFont("Hardpixel.OTF", fuente));
        profe.setForeground(new Color(255, 255, 240));
        this.add(profe);
        
        // LABEL SECCION N813
        
        seccion = new JLabel("SECCION N813");
        seccion.setBounds(190, seccionY, 320, 50);
        seccion.setFont(loadPixelFont("Hardpixel.OTF", fuente));
        seccion.setForeground(new Color(255, 255, 240));
        this.add(seccion);
        
        // LABEL COMPUTACION GRAFICA
        
        materia = new JLabel("COMPUTACION GRAFICA");
        materia.setBounds(85, materiaY, 535, 50);
        materia.setFont(loadPixelFont("Hardpixel.OTF", fuente));
        materia.setForeground(new Color(255, 255, 240));
        this.add(materia);
        
        // LABEL FECHA
        
        fecha = new JLabel("XX/XX/XXXX");
        fecha.setBounds(205, fechaY, 290, 50);
        fecha.setFont(loadPixelFont("Hardpixel.OTF", fuente));
        fecha.setForeground(new Color(255, 255, 240));
        this.add(fecha);
        
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
        

        Timer timer = new Timer(25, new ActionListener() {
        	
            @Override
            public void actionPerformed(ActionEvent e) {
                

                josueY -= deltaY;
                finolY -= deltaY;
                aleY -= deltaY;
                profeY -= deltaY;
                seccionY -= deltaY;
                materiaY -= deltaY;
                fechaY -= deltaY;
                

                if (marcaY < 0) {

                    josueY = 800;
                    finolY = 850;
                    aleY = 900;
                    profeY = 1050;
                    seccionY = 1100;
                    materiaY = 1150;
                    fechaY = 1300;
                    marcaY = 1350;
                }

                josue.setBounds(175, josueY, 355, fuente);
                finol.setBounds(215, finolY, 275, fuente);
                ale.setBounds(95, aleY, 525, fuente);
                profe.setBounds(45, profeY, 620, fuente);
                seccion.setBounds(190, seccionY, 320, fuente);
                materia.setBounds(85, materiaY, 535, fuente);
                fecha.setBounds(205, fechaY, 290, fuente);
                
                marcaY -= deltaY;
                
                repaint();  
                
            }
        
        });
        timer.start();
        
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
			
			info.dispose();
			Main.frame.setEnabled(true);
			Main.frame.toFront();
			Main.frame.requestFocus();
			
		}
		
	}
    
}