package Vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Connexion.Location;
import model.Client;
import model.ClientCache;
import model.EtatLibre;
import model.EtatLouer;
import model.Vehicule;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class FrameGestionLocation extends JFrame {

	private JPanel contentPane;
	private JPanel  pWest , pClient , pVehicule , pSouth;
	public static String[] typesChoix = {"----------","Voiture","Camion","Moto"};
	public static JComboBox tpsVehsChoix = new JComboBox(typesChoix);
	public static JPanel pON, pCenter;
	public static JScrollPane jsc;
	   public static JTable jtSel;
	   public static DefaultTableModel model ;
	  public static JTextField cinselect=null;
	  public static JTextField dateDEp=null;
	  public static JTextField dateARv=null;
	   public static Object[] cols = { 
			  "Matricule","Marque","Prix","Image"
			   };
	   public static JLabel lbs;
	   public static String typeSelect=null;
	   public static String prxSelect=null;
	   public static String matSelect=null;
	 //  public static JLabel etq = new JLabel("Séléctionner la véhicule pour éffectuer la location");
	/**
	 * Launch the application.
	 */
	/* public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameGestionLocation frame = new FrameGestionLocation();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public FrameGestionLocation() {
	
		setBounds(390, 90, 1000, 600);
	
		pWest = new JPanel(new GridLayout(2,1));
		pClient= new JPanel();
	    
			
		pClient.setLayout(new BoxLayout(pClient, BoxLayout.Y_AXIS));
		
		pWest.add(pClient);
		 JPanel p1,p2;
		 p1 = new JPanel(new GridLayout(4,0));
		 p2 = new JPanel();
		
		JLabel lcin = new JLabel("CIN de client :");
		p1.add(lcin);
		
		 JTextField tcin = new JTextField(10);
		p1.add(tcin);
		
		JLabel lnom = new JLabel("Nom de client :");
		p1.add(lnom);
		
		 JTextField tnom = new JTextField(10);
		p1.add(tnom);
		
		JLabel lpre = new JLabel("Prenom de client :");
	    p1.add(lpre);
		
		 JTextField tpre = new JTextField(10);
		p1.add(tpre);
		
		JLabel lage = new JLabel("Age de client :");
		p1.add(lage);
		
		 JTextField tage = new JTextField(4);
		p1.add(tage);
		pClient.add(p1); 
		pClient.add(p2); 
		pClient.setBorder(BorderFactory.createTitledBorder(" Création d'un nouveau Client "));		
		pSouth = new JPanel();
		
		JButton cl = new JButton("Sélctionner le Client");
		cl.addActionListener(e -> {
				cinselect.setText(tcin.getText());			
		});
		
		cinselect = new JTextField(10);
		cinselect.enable(false);	
		JButton Louer= new JButton("Louer");
		p2.add(cl);
		pSouth.add(Louer);
		Louer.setPreferredSize(new Dimension(120,30));
		Louer.addActionListener(e -> {
			Client c = null ;	
		
			int age = Integer.parseInt(tage.getText());
		   try {
			c = ClientCache.getClient(tcin.getText(),tnom.getText(),tpre.getText(),age) ;
		} catch (Exception e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}  
			try {
			//	Connect.changerEtatVehiculeLibreAuLouer(matSelect);
				EtatLouer el = new EtatLouer();
				el.actionEtat(matSelect);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				Location.InsertLocation();
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				if(ClientCache.clientMap.containsKey(c.getCIN())==false)
				     Location.InsertClient(c);
			} catch (Exception e1) {			
				e1.printStackTrace();
			}
			
			this.dispose();
		});
	
		add(pSouth,BorderLayout.SOUTH);
	
		pVehicule = new JPanel();
		
		 pVehicule.setLayout(new BoxLayout(pVehicule, BoxLayout.Y_AXIS));
		 pWest.add(pVehicule,BorderLayout.SOUTH); 
		 
		 pCenter= new JPanel();
		 pCenter.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
		// pCenter.setSize(Toolkit.getDefaultToolkit().getScreenSize());
	    // pCenter.setVisible(true);
		 
		add(pCenter,BorderLayout.CENTER);
		lbs = new JLabel("");
		pCenter.add(lbs,BorderLayout.NORTH);
		
		add(pWest,BorderLayout.WEST);
		 
		JLabel ch = new JLabel("Choisir la véhicule : ");
		
		JPanel N=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel S=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel t1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel t2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		N.add(ch);
		N.add(tpsVehsChoix);
		pVehicule.add(N);
		
		S.add(new JLabel("CIN séléctionner :"));
		S.add(cinselect);
		dateDEp = new JTextField(10);
		dateARv = new JTextField(10);
		t1.add(new JLabel("date de sortie : "));
		t1.add(dateDEp);
		t2.add(new JLabel("date de retour : "));
		t2.add(dateARv);
		pVehicule.add(S);
		pVehicule.add(t1); pVehicule.add(t2);
	
		pWest.add(pVehicule,BorderLayout.SOUTH);
		
		
		 model = new DefaultTableModel();
		 model.setColumnIdentifiers(cols);
		 
		 jtSel = new JTable( model){ 
	            public Class getColumnClass(int colonne)
	            {
	                return getValueAt(0, colonne).getClass();
	            }         
	        };
	        
	        jsc= new JScrollPane(jtSel);
	        jsc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    jtSel.setRowHeight(45);
		 jtSel.setFont(new Font("Comic Sans Ms",2,15));
		 
			        
		 pCenter.add(jsc);
		 pCenter.add(jtSel.getTableHeader(), BorderLayout.PAGE_START);
		 // add(jtSel.getTableHeader(), BorderLayout.PAGE_START);
	//	add(jt,BorderLayout.CENTER);
	//	jsc.setBounds(0, 0, 500, 400);
		tpsVehsChoix.addItemListener(e -> {
        	if(e.getStateChange()==ItemEvent.SELECTED) {
        		if(tpsVehsChoix.getSelectedItem().toString().equals("Voiture")) {
        			Console.modif("Item séléctionné :" + tpsVehsChoix.getSelectedItem());
        		
        		}
        		if(tpsVehsChoix.getSelectedItem().toString().equals("Camion")) {
        			Console.modif("Item séléctionné :" + tpsVehsChoix.getSelectedItem());
        		
        		}
        		if(tpsVehsChoix.getSelectedItem().toString().equals("Moto")) {
        			Console.modif("Item séléctionné :" + tpsVehsChoix.getSelectedItem());
        		
        		}
        		
        		typeSelect = tpsVehsChoix.getSelectedItem().toString();
        		int n = FrameGestionLocation.model.getRowCount();
        		for (int i=n-1 ; i>=0 ; --i)
        		FrameGestionLocation.model.removeRow(i);
        		try {
        			
					Location.recupererVehiculesLibre(typeSelect);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        			
        	                                                                    
                                                     	}
        	});
        	
		 jtSel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				int ligne = jtSel.getSelectedRow();
				 matSelect = FrameGestionLocation.model.getValueAt(ligne, 0).toString();
				prxSelect = FrameGestionLocation.model.getValueAt(ligne, 2).toString();
				 String str = "La véhicule selectionné à un matricule : "+matSelect + " et un prix de location : "+prxSelect ;
								Console.modif(str);
							FrameGestionLocation.lbs.setText(str);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
        		
		setVisible(true);
	    pack();
		 
	}
		

}
