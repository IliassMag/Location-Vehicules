package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.border.SoftBevelBorder;
import javax.swing.text.html.HTMLDocument;

public class PanneauCentrale extends JPanel {
	// public JPanel panel1;
	public static JPanel panel2;
 //   public static JLabel g , s , d , c , gAide , sAide , dAide , cAide;
 //   public static int CptVehGlobal , CptClient , CptVehLibre , CptVehLouer ;

	public PanneauCentrale() throws IOException{
   	JLabel img = new JLabel(new ImageIcon("D:\\\\jee project\\\\Gestion de location des véhicules\\\\src\\\\nvs.jpg"));
	//	JLabel img = new JLabel(new ImageIcon("D:\\\\jee project\\\\Gestion de location des véhicules\\\\src\\\\frein.gif"));
	setBackground(Color.WHITE);
		
	/*	JEditorPane pane = new JEditorPane();
        pane.setContentType("text/html");
      
        StringBuilder sh = new StringBuilder();
        sh.append(" <h1 Style='color:red;'> Page d'acceuil </h1>");
        pane.setText(sh.toString()); 
        HTMLDocument doc = (HTMLDocument) pane.getDocument();
        add(pane); 
		
		// backgroundImage = ImageIO.read(new File("D:\\\\jee project\\\\Gestion de location des véhicules\\\\src\\\\nvs.jpg"));*/
		setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
		setLayout(new BorderLayout());
	//	 panel1 = new JPanel();
		// panel1.setBackground(Color.getHSBColor(255,255,171)); //couleur
	//	 panel1.setLayout(new GridLayout(0,2));
	//	panel1.setBackground(Color.WHITE);
	
		/*		
		g = new JLabel("  Nombre des véhicules globales  : ");
		g.setFont(new Font( "MV Boli", Font.PLAIN,18));
		g.setForeground(Color.red);
		s = new JLabel("  Nombre des véhicules en sortie  : ");
		s.setFont(new Font( "MV Boli", Font.PLAIN,18));
		s.setForeground(Color.red);
		d = new JLabel("  Nombre des véhicules disponibles  : ");
		d.setFont(new Font( "MV Boli", Font.PLAIN,18));
		d.setForeground(Color.red);
		c = new JLabel("  Nombre des clients associés  : ");
		c.setFont(new Font( "MV Boli", Font.PLAIN,18));
		c.setForeground(Color.red);
		gAide=new JLabel();
		sAide=new JLabel();
		dAide=new JLabel();
		cAide=new JLabel();
		 panel1.add(g);
   panel1.add(gAide);
	      panel1.add(s);
	  panel1.add(sAide);	     
	      panel1.add(d);
	 panel1.add(dAide);
	      panel1.add(c);
	   panel1.add(cAide);	    
	      panel1.setBorder(BorderFactory.createTitledBorder(" Statistiques "));
	      
    add(panel1,BorderLayout.WEST); */
  panel2 = new JPanel();
  panel2.setBackground(Color.WHITE);
  //  panel2.setBackground(Color.getHSBColor(255,255,171)); //couleur
	img.setBounds(0,0,panel2.getWidth() , panel2.getWidth());
  panel2.add(img,BorderLayout.CENTER);
    add(panel2);
   
	}

/*	public static class Mytimer{
		public static Timer t = new Timer();
		public static void Appliquer() {
		t.schedule(new TimerTask() {
		int i = 0;
		 
		public void run() {
		                               
		
		                  }
		            }, 0, 3000);
		 
		callMyService();
		t.cancel();
		                     }
		 
		private static void callMyService() {
		System.out.println("DEBUT appel bloquant");
		try {
		                        //le programme va attendre 7 secondes
		Thread.currentThread().sleep(7000);
		System.out.println("FIN appel bloquant");
		} catch (InterruptedException e) {
		System.out.println("appel bloquant interrompu");
		}
		}
	} */
	


		
}


