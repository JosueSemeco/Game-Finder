package gameFinder;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

@SuppressWarnings("serial")
public class Jugar extends JPanel implements ActionListener, KeyListener {

    int anchoVentana = Main.frame.getWidth(),
            altoVentana = Main.frame.getHeight();

    public static JFrame jugar;

    private int vidas = 3, x, y;
    private int puntaje = 0;
    private JLabel puntajeLabel, nombreOculto, portadaLabel;
    private JLabel[] corazones;
    private JTextField input;
    private JButton enviar, X, siguiente;
    private JLabel sugerenciaLabel;
    private Map<String, String> juegos;
    private Set<String> juegosUsados;
    private String juegoActual;
    private Dimension size;
    private List<JLabel> tileLabels = new ArrayList<>();

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

    @SuppressWarnings("static-access")
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

        puntajeLabel = new JLabel("PUNTAJE: " + puntaje);
        puntajeLabel.setBounds(25, 60, 250, 30);
        puntajeLabel.setFont(loadPixelFont("Hardpixel.OTF", 30));
        puntajeLabel.setForeground(new Color(255, 255, 240));
        this.add(puntajeLabel);

        // LABEL CORAZONES

        corazones = new JLabel[3];
        
        for (int i = 0; i < 3; i++) {
        	
            try {
            	
                corazones[i] = new JLabel(new ImageIcon("img/ICONOS/fillHeart.png"));
                corazones[i].setBounds(535 + (i * 70), 20, 66, 61);
                this.add(corazones[i]);
                
            } catch (Exception e) {
            	
                e.printStackTrace();
                corazones[i] = new JLabel("?");
                corazones[i].setBounds(320 + (i * 70), 10, 66, 61);
                corazones[i].setForeground(Color.RED);
                this.add(corazones[i]);
                
            }
            
        }

        // Inicializar juegos
        
        inicializarJuegos();

        // juegos usados
        
        juegosUsados = new HashSet<>();

        // textfield
        
        input = new JTextField();
        input.setBounds(490, 700, 300, 60);
        input.setFont(loadPixelFont("Hardpixel.OTF", 40));
        input.setForeground(new Color(255, 255, 240));
        input.setBackground(new Color(35, 23, 59));
        input.addKeyListener(this);

        ((AbstractDocument) input.getDocument()).setDocumentFilter(new DocumentFilter() {
        	
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            	
                if (text != null) {
                	
                    super.replace(fb, offset, length, text.toUpperCase(), attrs);
                    
                }
                
            }

            @Override
            public void insertString(FilterBypass fb, int offset, String text, AttributeSet attrs) throws BadLocationException {
            	
                if (text != null) {
                	
                    super.insertString(fb, offset, text.toUpperCase(), attrs);
                    
                }
                
            }
            
        });

        this.add(input);

        // Etiqueta de sugerencia
        
        sugerenciaLabel = new JLabel("");
        sugerenciaLabel.setBounds(495, 765, 400, 30);
        sugerenciaLabel.setFont(loadPixelFont("Hardpixel.OTF", 20));
        sugerenciaLabel.setForeground(new Color(255, 255, 240));
        this.add(sugerenciaLabel);

        // Etiqueta de portada
        
        portadaLabel = new JLabel();
        portadaLabel.setBounds(440, 100, 400, 500);
        this.add(portadaLabel);

        // Botón de enviar
        
        ImageIcon guess = new ImageIcon("img/ICONOS/guess.png");
        enviar = new JButton(guess);
        enviar.setBounds(920, 350, 180, 100);
        enviar.setBorderPainted(false);
        enviar.setContentAreaFilled(false);
        enviar.setFocusPainted(false);
        enviar.setOpaque(false);
        enviar.addActionListener(this);
        this.add(enviar);

        // Botón de siguiente
        
        ImageIcon arrow = new ImageIcon("img/ICONOS/arrowNext.png");
        siguiente = new JButton(arrow);
        siguiente.setBounds(920, 500, 100, 100);
        siguiente.setBorderPainted(false);
        siguiente.setContentAreaFilled(false);
        siguiente.setFocusPainted(false);
        siguiente.setOpaque(false);
        siguiente.addActionListener(this);
        siguiente.setVisible(false);
        this.add(siguiente);

        // juego aleatorio
        
        juegoActual = seleccionarJuegoAleatorio();
        
        if (juegoActual == null) {
        	
            JOptionPane.showMessageDialog(this, "No hay juegos disponibles.");

        } else {
        	
            // Nombre oculto del juego
        	
            String textoOculto = ocultarNombre(juegoActual);
            nombreOculto = new JLabel(textoOculto);
            nombreOculto.setFont(loadPixelFont("Hardpixel.OTF", 30));
            nombreOculto.setForeground(new Color(255, 255, 240));
            actualizarTextoLabel(nombreOculto, textoOculto);
            this.add(nombreOculto);

            // portada del juego inicial
            
            mostrarPortada(juegoActual);
            
        }
        
    }

    // actualizar el texto del JLabel y centrarlo
    
    private void actualizarTextoLabel(JLabel label, String nuevoTexto) {
    	
        label.setText(nuevoTexto);
        label.setFont(loadPixelFont("Hardpixel.OTF", 30));
        
        size = label.getPreferredSize();
        label.setSize(size.width, size.height);

        x = (jugar.getWidth() - size.width) / 2;
        y = 635;
        
        label.setLocation(x, y);
        
        label.revalidate();
        label.repaint();
    }

    // lista de juegos
    
    private void inicializarJuegos() {
    	
        juegos = new TreeMap<>();
        File carpeta = new File("img/PORTADAS NORMALES/");
        
        if (carpeta.exists() && carpeta.isDirectory()) {
        	
            for (File archivo : carpeta.listFiles()) {
            	
                if (archivo.isFile() && archivo.getName().endsWith(".jpg")) {
                	
                    String nombreJuego = archivo.getName().replace(".jpg", "").toUpperCase();
                    juegos.put(nombreJuego, nombreJuego);
                    
                }
                
            }
            
        }
        
    }

    // juego aleatorio de la lista que no haya sido usado
    
    private String seleccionarJuegoAleatorio() {
    	
        List<String> keys = new ArrayList<>(juegos.keySet());
        keys.removeAll(juegosUsados);
        
        if (keys.isEmpty()) {
        	
            return null;
        }
        
        String juego = keys.get(new Random().nextInt(keys.size()));
        juegosUsados.add(juego);
        return juego;
        
    }

    // portada del juego
    
    private void mostrarPortada(String juego) {
    	
        String ruta = "img/PORTADAS NORMALES/";
        
        try {
        	
            File archivo = new File(ruta + juego + ".jpg");
            
            if (!archivo.exists()) {
            	
                throw new IOException("Archivo no encontrado: " + archivo.getAbsolutePath());
            }
            
            Image image = ImageIO.read(archivo);
            Image scaledImage = image.getScaledInstance(portadaLabel.getWidth(), portadaLabel.getHeight(), Image.SCALE_SMOOTH);
            portadaLabel.setIcon(new ImageIcon(scaledImage));
            
            portadaLabel.setVisible(true);
            this.setComponentZOrder(portadaLabel, 0);
            
            cargarImagenesPixeladas(juego);
            
        } catch (IOException e) {
        	
            e.printStackTrace();
            portadaLabel.setText("No se pudo cargar la portada.");
            
        }
        
    }

    // imágenes pixeladas sobre la portada
    
    private void cargarImagenesPixeladas(String juego) {
    	
        for (JLabel tileLabel : tileLabels) {
        	
            this.remove(tileLabel);
            
        }
        
        tileLabels.clear();

        String rutaPixeladas = "img/PORTADAS PIXELADAS/" + juego + "/";
        int tileWidth = portadaLabel.getWidth() / 4;
        int tileHeight = portadaLabel.getHeight() / 4;
        
        for (int i = 1; i <= 4; i++) {
        	
            for (int j = 1; j <= 4; j++) {
            	
                try {
                	
                    String tileName = String.format("fila-%d-columna-%d.jpg", i, j);
                    File archivoPixelado = new File(rutaPixeladas + tileName);
                    
                    if (!archivoPixelado.exists()) {
                    	
                        throw new IOException("Archivo pixelado no encontrado: " + archivoPixelado.getAbsolutePath());
                    
                    }
                    Image image = ImageIO.read(archivoPixelado);
                    Image scaledImage = image.getScaledInstance(tileWidth, tileHeight, Image.SCALE_SMOOTH);
                    JLabel tileLabel = new JLabel(new ImageIcon(scaledImage));
                    tileLabel.setBounds(portadaLabel.getX() + (j - 1) * tileWidth, portadaLabel.getY() + (i - 1) * tileHeight, tileWidth, tileHeight);
                    this.add(tileLabel);
                    tileLabels.add(tileLabel);
                    this.setComponentZOrder(tileLabel, 0);
                    
                } catch (IOException e) {
                	
                    e.printStackTrace();
                    
                }
                
            }
            
        }
        
        this.revalidate();
        this.repaint();
        
    }

    // nombre del juego con "?"
    
    private String ocultarNombre(String nombre) {
    	
        return nombre.replaceAll("[A-Za-z0-9]", "?");
        
    }

    // Verifica si la respuesta ingresada es correcta
    
    @SuppressWarnings({ "unused", "deprecation" })
	private void verificarRespuesta() {
    	
        String respuesta = input.getText().trim().toUpperCase();

        if (juegoActual != null && juegos.containsKey(juegoActual) && juegos.get(juegoActual).equals(respuesta)) {
        	
            puntaje += vidas;
            
            mostrarPortadaNormal(juegoActual);
            actualizarTextoLabel(nombreOculto, juegoActual);
            
            enviar.setVisible(false);
            siguiente.setVisible(true);
            
        } else {
        	
            vidas--;
            actualizarVidas();
            
            if (vidas == 0) {
            	
            	Jugar.jugar.disable();
                DefeatFrame def = new DefeatFrame();
                guardarResultado(User.usuario, puntaje);
                
                
            }
            
        }
        
        input.setText("");
        
    }

    // guardar el resultado en la base de datos
    
    private void guardarResultado(String usuario, int puntaje) {
    	
        DB_Connection.updateScoreIfHigher(usuario, puntaje);
        
    }

    // portada normal del juego
    
    private void mostrarPortadaNormal(String juego) {
    	
        String ruta = "img/PORTADAS NORMALES/";
        
        try {
        	
            File archivo = new File(ruta + juego + ".jpg");
            
            if (!archivo.exists()) {
            	
                throw new IOException("Archivo no encontrado: " + archivo.getAbsolutePath());
            
            }
            Image image = ImageIO.read(archivo);
            Image scaledImage = image.getScaledInstance(portadaLabel.getWidth(), portadaLabel.getHeight(), Image.SCALE_SMOOTH);
            portadaLabel.setIcon(new ImageIcon(scaledImage));
            portadaLabel.setVisible(true);
            this.setComponentZOrder(portadaLabel, 0);
        
        } catch (IOException e) {
        	
            e.printStackTrace();
            portadaLabel.setText("No se pudo cargar la portada.");
            
        }
        
    }

    // Actualiza las imágenes de las vidas y elimina una imagen aleatoria
    
    private void actualizarVidas() {
    	
        for (int i = 0; i < 3; i++) {
        	
            corazones[i].setIcon(new ImageIcon(i < vidas ? "img/ICONOS/fillHeart.png" : "img/ICONOS/emptyHeart.png"));
       
        }

        if (tileLabels.size() > 0) {
        	
            Random random = new Random();
            int index = random.nextInt(tileLabels.size());
            JLabel tileLabel = tileLabels.remove(index);
            this.remove(tileLabel);
            this.revalidate();
            this.repaint();
            
        }
        
    }

    // nuevo juego
    
    @SuppressWarnings("unused")
	private void siguienteJuego() {
    	
        juegoActual = seleccionarJuegoAleatorio();
        
        if (juegoActual != null) {
        	
            actualizarTextoLabel(nombreOculto, ocultarNombre(juegoActual));
            puntajeLabel.setText("PUNTAJE: " + puntaje);
            actualizarVidas();
            mostrarPortada(juegoActual);
            siguiente.setVisible(false);
            enviar.setVisible(true);
        
        } else {
        	
            CongratsFrame win = new CongratsFrame();
            guardarResultado(User.usuario, puntaje);
            
        }
        
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
            Main.frame.toFront();
            Main.frame.requestFocus();
            
        }

        if (e.getSource() == enviar) {
        	
            verificarRespuesta();
            
        }

        if (e.getSource() == siguiente) {
        	
            siguienteJuego();
            
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
    	
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
    	
        // TODO Auto-generated method stub

    }

    @Override
    public void keyReleased(KeyEvent e) {

        String texto = input.getText().toUpperCase();
        sugerenciaLabel.setText("");
        
        if (texto.length() > 0) {
        	
            for (String juego : juegos.keySet()) {
            	
                if (juego.startsWith(texto)) {
                	
                    sugerenciaLabel.setText(juego);
                    break;
                    
                }
                
            }
            
        }

    }

}