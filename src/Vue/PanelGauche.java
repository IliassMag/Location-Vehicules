package Vue;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.BorderFactory;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import com.mysql.cj.jdbc.ha.LoadBalancedMySQLConnection;




public class PanelGauche extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton b1 ,b2,b5,b3,b4;
	
  
	public PanelGauche() {
	
		JPanel p1 = new JPanel();
	
		//JSeparator sp = new JSeparator();
		// B = new BoxLayout (this, BoxLayout.Y_AXIS);
        setLayout(new BorderLayout());
     setBackground(new Color(245, 247, 247  )); //Color.getHSBColor(255,255,222)
    //  p1.setBackground(Color.lightGray);
		 GridLayout g1;
	
		g1 = new GridLayout(0,1);
		g1.setHgap(15);
		g1.setVgap(10);
		
		p1.setLayout (g1);
	
		
		JLabel img1 = new JLabel(new ImageIcon("D:\\jee project\\Gestion de location des véhicules\\images\\prog.gif"));
		
		this.b1 = new JButton("Gestion des véhicules",new ImageIcon("D:\\\\jee project\\\\Gestion de location des véhicules\\\\images\\\\voii.jpg"));
		b1.setFont(new Font( "Bradley Hand ITC", Font.PLAIN,20));
//		this.b2 = new JButton("Gestion des clients",new ImageIcon("D:\\\\jee project\\\\Gestion de location des véhicules\\\\src\\\\cl.jpg"));
//		b2.setFont( new Font( "Bradley Hand ITC", Font.PLAIN,20));
		this.b3 = new JButton("Gestion des contracts",new ImageIcon("D:\\\\jee project\\\\Gestion de location des véhicules\\\\images\\\\cont.png"));
		b3.setFont( new Font( "Bradley Hand ITC", Font.PLAIN,20));
		this.b4 = new JButton("Gestion de caisse",new ImageIcon("D:\\\\jee project\\\\Gestion de location des véhicules\\\\images\\\\cai.gif"));
		b4.setFont( new Font( "Bradley Hand ITC", Font.PLAIN,20));
	     b5=new JButton("Gestion de Location",new ImageIcon("D:\\\\jee project\\\\Gestion de location des véhicules\\\\images\\\\lockey.jpg"));
	     b5.setFont( new Font( "Bradley Hand ITC", Font.PLAIN,20));
		b1.setPreferredSize(new Dimension(270,35));
	   b1.setBackground(Color.LIGHT_GRAY);
	   
//		b2.setPreferredSize(new Dimension(260,50));
//		 b2.setBackground(Color.LIGHT_GRAY);
		 b5.setPreferredSize(new Dimension(200,35));
		 b5.setBackground(Color.LIGHT_GRAY);
		b3.setPreferredSize(new Dimension(200,35)); 
		 b3.setBackground(Color.LIGHT_GRAY);
		b4.setPreferredSize(new Dimension(200,35)); 
		b4.setBackground(Color.LIGHT_GRAY);
		p1.setBackground(new Color(245, 247, 247 ));
		p1.add(img1);
		p1.add(b1); 
		
//		p1.add(b2);
		p1.add(b5);
		p1.add(b3);
		p1.add(b4);
		b1.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
//		b2.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		b5.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		b3.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		b4.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		b1.addActionListener(  new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Console.modif("--- Gestion des véhicules --- ");
			try {
				FrameGestionVehicule f = new FrameGestionVehicule();
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
				
				
			}
		});
		 
//		b2.addActionListener(e -> {
//			Console.modif("--- Gestion des clients ---");
//			try {
//				 new FrameGestionClient();
//			} catch (Exception e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}});
		
		
		b5.addActionListener(e -> {
			Console.modif("--- Gestion de Location ---");
			FrameGestionLocation frame = new FrameGestionLocation();
		});
		
		 add(p1,BorderLayout.CENTER);
		
		}
}

	      
	
		

