package gameFinder;

import java.awt.Color;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class RecordFrame extends JFrame{
	
	RecordFrame() {
		
		this.setSize(900, 900);
		this.setTitle("RECORDS");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(rootPane);
		this.getContentPane().setBackground(Color.BLACK);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setLayout(null);
		
		Record record = new Record(this);
		record.setBounds(0, 0, 900, 900);
		this.add(record);
		
		this.setVisible(true);
		
	}

}
