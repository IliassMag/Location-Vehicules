package Vue;




import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Connexion.Location;



public class PanneauHaut extends JToolBar{
	
	private static final long serialVersionUID = 1L;
	// public JPanel p1,p2;
	public JButton b1,b2,b3,b4;
	public static JTextField rechVehicule;
	
    public static String chaineRecherche;
	public PanneauHaut() {
		
		rechVehicule = new JTextField(17);
		rechVehicule.setFont(new Font("Times New Roman",Font.PLAIN,12));
		rechVehicule.setText(" Saisir la marque du Véhicule que vous cherchez + ENTREE ou bien cliquez sur >> 'RECHERCHER'");
		rechVehicule.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				rechVehicule.setText(" Saisir la marque du Véhicule que vous cherchez + ENTREE ou bien cliquez sur >> 'RECHERCHER'");
				
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				rechVehicule.setText("");
				
			}
		});
			rechVehicule.addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent t) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void keyReleased(KeyEvent a) {
					chaineRecherche = rechVehicule.getText();
					
				}
				
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode()==KeyEvent.VK_ENTER) {
						try {
					
							 Location.chercherVehiculesNom(rechVehicule.getText());
							
						} catch (Exception e1) {
							
							e1.printStackTrace();
						}
					
			                                             	}
		                        	}
				});
		
        
	
	//	p1 = new JPanel();
		// p1.setBackground(Color.WHITE);
		b1 = new JButton("Ajouter une véhicule ",new ImageIcon("D:\\\\jee project\\\\Gestion de location des véhicules\\\\images\\\\lvs.jpg"));
		b1.setFont( new Font( "Bradley Hand ITC", Font.ROMAN_BASELINE,20));
		b1.setBackground(Color.WHITE);
		//b2 = new JButton("Liste des Clients",new ImageIcon("D:\\\\jee project\\\\Gestion de location des véhicules\\\\src\\\\cls.png"));
		//b2.setBackground(Color.WHITE);
		b2=new JButton("Rechercher",new ImageIcon("D:\\\\jee project\\\\Gestion de location des véhicules\\\\images\\\\lente.png"));
		b2.setFont( new Font( "Bradley Hand ITC", Font.ROMAN_BASELINE,20));
		b2.setBackground(Color.WHITE);
		b3=new JButton("Liste des Locations",new ImageIcon("D:\\\\jee project\\\\Gestion de location des véhicules\\\\images\\\\listeLoc.png"));
		b3.setFont( new Font( "Bradley Hand ITC", Font.ROMAN_BASELINE,20));
		b3.addActionListener(e -> {
			try {
				Console.modif("--- Liste des Locations ---");
				     new FrameListLocation();
			} catch (Exception e1) {
			
				e1.printStackTrace();
			}
		});
		this.b4 = new JButton("Liste des clients",new ImageIcon("D:\\\\jee project\\\\Gestion de location des véhicules\\\\images\\\\cl.jpg"));
		b4.setFont( new Font( "Bradley Hand ITC", Font.PLAIN,20));
		setBackground(new Color(245, 247, 247 ));
	
		add(b1);
		addSeparator();
		add(new JSeparator(SwingConstants.VERTICAL));
		addSeparator();
		add(b3);
		addSeparator();
	//	add(new JSeparator(SwingConstants.VERTICAL));
	
		add(new JSeparator(SwingConstants.VERTICAL));
		addSeparator();
		
		add(b4);
		addSeparator();
		add(new JSeparator(SwingConstants.VERTICAL));
		addSeparator();
	   add(rechVehicule);
		addSeparator();
		add(new JSeparator(SwingConstants.VERTICAL));
		
		addSeparator();
		b4.addActionListener(e -> {
			Console.modif("--- Liste des clients ---");
			try {
				 new FrameGestionClient();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}});
		add(b2);
		b2.addActionListener(e -> {
			try {
				Location.chercherVehiculesNom(chaineRecherche);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
	
		b1.addActionListener(e -> {
			Console.modif("--- Ajouter une véhicule --- ");
			new FrameAjoutVehicule();
			} 
		);
	/*		//Set up the file chooser.
	        if (fc == null) {
	            fc = new JFileChooser();

		    //Add a custom file filter and disable the default
		    //(Accept All) file filter.
	            fc.addChoosableFileFilter(new ImageFilter());
	            fc.setAcceptAllFileFilterUsed(false);

		    //Add custom icons for file types.
	            fc.setFileView(new ImageFileView());

		    //Add the preview pane.
	            fc.setAccessory(new ImagePreview(fc));
	        }

	        //Show it.
	        int returnVal = fc.showDialog(PanneauHaut.this,"Attach");

	        //Process the results.
	        if (returnVal == JFileChooser.APPROVE_OPTION) {
	            File file = fc.getSelectedFile();
	            Console.modif("Attaching file: " + file.getName()
	                       + ".");
	            
	        } else {
	        	 Console.modif("Attachment cancelled by user." );
	        }
	        
	    //   Console.setCaretPosition(Console.getDocument().getLength());

	        //Reset the file chooser for the next time it's shown.
	        fc.setSelectedFile(null); */
		
		
		//p1.add(b2,BorderLayout.CENTER);
//	add(p1,BorderLayout.WEST);
//	add(p2,BorderLayout.EAST);
	}
	
	
}

