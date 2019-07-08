package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;


import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Console extends JPanel {

	private static final long serialVersionUID = 1L;
public static	JTextArea  tex;
	public static JScrollPane sc;
	public Console(){
		    setLayout(new BorderLayout());
		    tex = new JTextArea(9,122); 
		    tex.setForeground(Color.YELLOW); 
		    tex.enable(false);
		    tex.setBackground(Color.DARK_GRAY);
		  
		    tex.setLineWrap(true); 
		    tex.setFont(new Font( "Comic sans Ms", Font.PLAIN,14));
		 //   tex.setCaretColor(Color.GREEN);
	         sc = new JScrollPane(tex);  
	        sc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	        add(sc);
	}
	public static void modif(String sh) {
		String s = tex.getText();
		s +="\n";
		s+=" > "+sh ;
		tex.setText(s);
		// tex.setForeground(Color.YELLOW);
	}
}
