package gameFinder;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import java.awt.Color;
import java.awt.Font;
import java.io.File;

@SuppressWarnings("serial")
public class CustomScrollPane extends JScrollPane {

    public CustomScrollPane(JTable table) {
    	
        super(table);
        customizeTable(table);
        customizeScrollPane();
        
    }

    private void customizeTable(JTable table) {
    	
        // Cambiar la fuente, el tamaño de la fuente y el color de la fuente del contenido de la tabla
        
    	table.setFont(loadPixelFont("Hardpixel.OTF", 50));
        table.setForeground(new Color(255, 255, 240));
        table.setBackground(new Color(35, 23, 59));

        // Cambiar la fuente, el tamaño de la fuente y el color de la fuente del encabezado de la tabla
        
        JTableHeader header = table.getTableHeader();
        header.setFont(loadPixelFont("Hardpixel.OTF", 40));
        header.setForeground(new Color(255, 255, 240));
        header.setBackground(new Color(35, 23, 59));
        
    }

    private void customizeScrollPane() {
    	
        // Cambiar el fondo del JScrollPane
        
    	this.getViewport().setBackground(new Color(35, 23, 59));

        // Personalizar las barras de desplazamiento (opcional)
        
    	this.getHorizontalScrollBar().setBackground(new Color(227, 212, 75));
        this.getVerticalScrollBar().setBackground(new Color(227, 212, 75));
        
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
    
}