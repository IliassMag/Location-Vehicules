package Vue;

import java.awt.BorderLayout;

import java.awt.GridLayout;

import java.awt.event.ItemEvent;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Connexion.Location;
import model.Camion;
import model.Moto;

import model.Vehicule;

import model.VehiculeFactory;
import model.Voiture;

public class FrameAjoutVehicule extends JFrame{
	public static String[] types = {"-----","Voiture" ,"Camion" , "Moto"};
	public static JComboBox<String> tpsVeh = new JComboBox<String>(types);
	public JFileChooser fc;
	  public JPanel  pNorth , pSouth , pcentre , pEast;
	public static String TypeSelectionne;
	public static boolean select=false;
	
	public JLabel Mylabpic ;
	public static ImageIcon Mypic;
	public static String chemin;
	public static InputStream imgS ;
	public FrameAjoutVehicule(){
		JLabel text = new JLabel("Préciser le type de véhicule : ");
	    JButton b , Ajouter , annuler ;
	    b = new JButton("Séléctionner la véhicule ");
	    pNorth=new JPanel();
        pNorth.add(text);
        pEast = new JPanel();
        add(pEast,BorderLayout.EAST);
        Mylabpic = new JLabel();
	    b.addActionListener(e -> {
			//Set up the file chooser.
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
	        int returnVal = fc.showDialog(FrameAjoutVehicule.this,"Attach");

	        //Process the results.
	        if (returnVal == JFileChooser.APPROVE_OPTION) {
	            File file = fc.getSelectedFile();
	            Console.modif("Pièce jointe acceptée par l'utilisateur : " + file.getName()
	                       + ".");
	            
	       chemin = file.getAbsolutePath();
	      // //////////   pcenter.add(new JLabel(new ImageIcon(chemin))); /////////////
	            BufferedImage BuffPic = null;
	           try {
				BuffPic=ImageIO.read(file);
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
	          Mypic = new ImageIcon(BuffPic);
	          Voiture.img=Mypic;
	          Mylabpic.setIcon(Mypic);
	          
	      //    Mylabpic.setPreferredSize(new Dimension(120,80));
	    		
	        } else {
	        	 Console.modif("Pièce jointe annulée par l'utilisateur." );
	        }
	       
	    //   Console.setCaretPosition(Console.getDocument().getLength());

	        //Reset the file chooser for the next time it's shown.
	        fc.setSelectedFile(null);
		});
	    
          pEast.add(Mylabpic);
	
        pNorth.add(tpsVeh);
        pNorth.add(b);
        add(pNorth,BorderLayout.NORTH);
    //    add(new JSeparator(SwingConstants.HORIZONTAL));
        JLabel mat = new JLabel("Matricule : ");
        JTextField Tmat = new JTextField(4);   
        JLabel prl = new JLabel("Prix de location : ");
        JTextField Tprl = new JTextField(4); 
        JLabel mrq = new JLabel("Marque : ");
        JTextField Tmrq = new JTextField(4);  
        pcentre = new JPanel(new GridLayout(4,2));
        pcentre.add(mat);
        pcentre.add(Tmat);
        pcentre.add(prl);
        pcentre.add(Tprl);
        pcentre.add(mrq);
        pcentre.add(Tmrq);
    add(pcentre,BorderLayout.CENTER);
    
     Ajouter=new JButton("Ajouter");
     annuler=new JButton("Annuler");
     pSouth = new JPanel();
    pSouth.add(Ajouter);
    pSouth.add(annuler);
    add(pSouth, BorderLayout.SOUTH);
    //dispose();
        annuler.addActionListener(e -> {
        	this.dispose();
        });
        
        tpsVeh.addItemListener(e -> {
        	if(e.getStateChange()==ItemEvent.SELECTED) {
        		if(tpsVeh.getSelectedItem().toString().equals("Voiture")) {
        			TypeSelectionne="Voiture";
        			select=true;
        	                                                              }
        		if(tpsVeh.getSelectedItem().toString().equals("Moto")) {
        			TypeSelectionne="Moto";
        			select=true;
        			                                                        }
        		if(tpsVeh.getSelectedItem().toString().equals("Camion")) {
        			TypeSelectionne="Camion";
        			select=true;                                        }
        		
        	}
        });
        
        Ajouter.addActionListener(e -> {
        	Voiture vv = null;
        	Vehicule v = null;
        	Camion c = null;
        	Moto m = null;
        	if(select) {
        	VehiculeFactory vf = new VehiculeFactory();
        	 Object[] donnees =  new Object[6];
        	
        	if(TypeSelectionne.equals("Voiture")) {
    		v=vf.getVehicule(Tmrq.getText(),TypeSelectionne ,Tmat.getText(),Tprl.getText());
    		vv=(Voiture)v;
       		donnees[0]=vv.matricule;
    		donnees[1]=vv.type;
    		donnees[2]=vv.marque; 
    		donnees[3]=vv.prixLocation;
    		donnees[4]=vv.et.getEtat();
        	}
        	
        	if(TypeSelectionne.equals("Camion")) {
        		v=vf.getVehicule(Tmrq.getText(),TypeSelectionne ,Tmat.getText(),Tprl.getText());
        		c=(Camion)v;
        		donnees[0]=c.matricule;
        		donnees[1]=c.type;
        		donnees[2]=c.marque; 
        		donnees[3]=c.prixLocation;
        		donnees[4]=c.et.getEtat();
        		// ObjectComposite.ajouterVehicule(c);
            	}
        	if(TypeSelectionne.equals("Moto")) {
        		v=vf.getVehicule(Tmrq.getText(),TypeSelectionne ,Tmat.getText(),Tprl.getText());
        		m=(Moto)v;
        	//	ObjectComposite.ajouterVehicule(m);
        		donnees[0]=m.matricule;
        		donnees[1]=m.type;
        		donnees[2]=m.marque; 
        		donnees[3]=m.prixLocation;
        		donnees[4]=m.et.getEtat();
            	}
               	
			try {
				imgS = new FileInputStream(new File(chemin));
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
    		
    		 
    	
    		Console.modif("en cours de l'ajout ");
    		try {
	        Location.InsertVehicule(donnees);
			} catch (Exception e1) {
				Console.modif("Au niveau de 'FrameAjoutVehicule' il y a un probleme d'insertion");
				e1.printStackTrace();
			}
    	
    		if(TypeSelectionne.equals("Voiture")) 
    		
    	      	Console.modif(vv.toString());
    		
    		if(TypeSelectionne.equals("Camion")) 
    			
    			Console.modif(c.toString());
    		
    		if(TypeSelectionne.equals("Moto")) 
    			
    			Console.modif(m.toString());
    		//
    		        		try {
      			Location.recupererVehicules();
      		} catch (Exception e1) {
      			// TODO Auto-generated catch block
      			e1.printStackTrace();
      		}
        	//	
    		this.dispose();
    		
    		}
        	
        	else {
        		Console.modif("Erreur Vous n'avez pas saisies les données correctement , essayer à nouveau");
        		this.dispose();
        	}
    		
        });
        
       
	    setBounds(450, 150, 780, 470);
	 
	    pack();
	    setVisible(true);
	    
	  
	    
}
	
}
