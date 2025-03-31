package gameFinder;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

@SuppressWarnings("serial")
public class Record extends JPanel implements ActionListener {

    int anchoVentana = Main.frame.getWidth(),
            altoVentana = Main.frame.getHeight();

    public static JFrame record;

    JButton X;
    JButton deleteButton;
    JTable table;
    UserScoreTableModel tableModel;

    public void paintComponent(Graphics g) {
    	
        super.paintComponent(g);
        Graphics2D gd = (Graphics2D) g;

        // MARCO DE PANTALLA
        
        gd.setStroke(new BasicStroke(5));
        gd.setPaint(Color.WHITE);
        gd.drawLine(1, 1, 1, 898);
        gd.drawLine(1, 1, anchoVentana, 1);
        gd.drawLine(1, 898, 898, 898);
        gd.drawLine(898, 1, 898, 898);
        
    }

    @SuppressWarnings("static-access")
    Record(JFrame record) {
    	
        this.record = record;
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

        tableModel = new UserScoreTableModel();
        table = new JTable(tableModel);
        table.setRowHeight(50);

        // Centrar el texto en las celdas
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        for (int columnIndex = 0; columnIndex < table.getColumnCount(); columnIndex++) {
        	
            table.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
            
        }

        JScrollPane scrollPane = new CustomScrollPane(table);
        scrollPane.setBounds(50, 50, 550, 800);
        this.add(scrollPane);
        
        ImageIcon del = new ImageIcon("img/ICONOS/trashcan.png");
        deleteButton = new JButton(del);
        deleteButton.setBounds(620, 720, 100, 133);
        deleteButton.setBorderPainted(false);
        deleteButton.setContentAreaFilled(false);
        deleteButton.setFocusPainted(false);
        deleteButton.setOpaque(false);
        deleteButton.addActionListener(this);
        this.add(deleteButton);
        
        String text = "*NOTA: PARA ELIMINAR\nUN RECORD, HAZ\nCLIC SOBRE EL\nY LUEGO SOBRE\nLA BASURA";
        JTextArea nota = new JTextArea(text);
        nota.setBounds(725, 750, 100, 133);  // Ajustar tamaño y posición según sea necesario
        nota.setFont(loadPixelFont("Hardpixel.OTF", 13));
        nota.setForeground(new Color(255, 255, 240));
        nota.setBackground(new Color(0, 0, 0, 0)); // Hacer que el fondo sea transparente
        nota.setOpaque(false);
        nota.setEditable(false);
        nota.setFocusable(false);
        nota.setLineWrap(true);
        nota.setWrapStyleWord(true);
        add(nota);

        refreshData();
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

    private void refreshData() {
    	
        List<UserScore> userScores = DB_Connection.getUserScores();
        tableModel.setUserScores(userScores);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	
        if (e.getSource() == X) {
        	
            record.dispose();
            Main.frame.setEnabled(true);
            Main.frame.toFront();
            Main.frame.requestFocus();
            
        } else if (e.getSource() == deleteButton) {
        	
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                int userId = tableModel.getUserIdAt(selectedRow);
                DB_Connection.deleteUserScore(userId);
                refreshData();
                
            }
            
        }
        
    }

    class UserScoreTableModel extends AbstractTableModel {
    	
        private List<UserScore> userScores;
        private String[] columnNames = {"USUARIO", "PUNTUACION"};

        public void setUserScores(List<UserScore> userScores) {
        	
            this.userScores = userScores;
            fireTableDataChanged();
            
        }

        @Override
        public int getRowCount() {
        	
            return userScores == null ? 0 : userScores.size();
            
        }

        @Override
        public int getColumnCount() {
        	
            return columnNames.length;
            
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
        	
            UserScore userScore = userScores.get(rowIndex);
            
            switch (columnIndex) {
            
                case 0:
                	
                    return userScore.getUsuario();
                    
                case 1:
                	
                    return userScore.getPuntuacion();
                    
            }
            
            return null;
            
        }

        public int getUserIdAt(int rowIndex) {
        	
            UserScore userScore = userScores.get(rowIndex);
            return userScore.getId();
            
        }

        @Override
        public String getColumnName(int column) {
        	
            return columnNames[column];
            
        }
        
    }
    
}