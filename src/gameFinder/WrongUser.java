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
public class WrongUser extends JPanel implements ActionListener{
	
	int anchoVentana = Main.frame.getWidth(),
			altoVentana = Main.frame.getHeight();
	
	public static JFrame wrong;
	
	JButton X;
	
public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D gd = (Graphics2D) g;
		
		// MARCO DE PANTALLA
		
		gd.setStroke(new BasicStroke(5));
		gd.setPaint(Color.WHITE);
		gd.drawLine(1, 1, 1, altoVentana);
		gd.drawLine(1, 1, anchoVentana, 1);
		gd.drawLine(1, 398, 598, 398);
		gd.drawLine(598, 1, 598, 398);
		
	}
	
	@SuppressWarnings("static-access")
	WrongUser(JFrame wrong) {
		
		this.wrong = wrong;
		this.setBackground(new Color(57, 23, 58));
		this.setLayout(null);
		
// BOTON X
        
        X = new JButton("X");
        X.setBounds(540, 20, 30, 50);
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
		X1.setBounds(545, 25, 30, 50);
		X1.setFont(loadPixelFont("Hardpixel.OTF", 50));
		X1.setForeground(new Color(227, 212, 75));
		this.add(X1);
		
		JLabel X2 = new JLabel("X");
		X2.setBounds(550, 30, 30, 50);
		X2.setFont(loadPixelFont("Hardpixel.OTF", 50));
		X2.setForeground(new Color(232, 39, 39));
		this.add(X2);
		
		// LABEL ERROR
		
		JLabel error = new JLabel("ERROR!");
		error.setBounds(135, 80, 400, 100);
		error.setFont(loadPixelFont("Hardpixel.OTF", 100));
		error.setForeground(new Color(255, 255, 240));
		this.add(error);
		
		// LABEL USUARIO VALIDO
		
		JLabel valido = new JLabel("INGRESE USUARIO VALIDO");
		valido.setBounds(30, 250, 545, 45);
		valido.setFont(loadPixelFont("Hardpixel.OTF", 45));
		valido.setForeground(new Color(255, 255, 240));
		this.add(valido);
		
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
			
			wrong.dispose();
			User.user.setEnabled(true);
			Main.frame.toFront();
			Main.frame.requestFocus();
			User.user.toFront();
			User.user.requestFocus();
			
		}
		
	}

}
