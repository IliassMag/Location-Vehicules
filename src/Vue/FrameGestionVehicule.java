package Vue;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Connexion.Location;
import model.Etat;
import model.EtatLibre;


public class FrameGestionVehicule extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel pS;
	public static JScrollPane jst;
   public static JTable jt;
   public static DefaultTableModel model ;
   public static Object[] cols = { 
		  "Matricule","Type","Marque","Prix","Image","Etat"
		   };
  public static String matriculeSelect;
  public static int ligneSelect;
  
    public FrameGestionVehicule() throws Exception {
    	
       pS=new JPanel();
        JButton Supp = new JButton("Supprimer");
        Supp.addActionListener(e -> {
        	try {
				Location.suppVehicule(matriculeSelect);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
      		
        	FrameGestionVehicule.model.removeRow(ligneSelect); 
        	
        	 int n = FrameGestionVehicule.model.getRowCount();
       		for (int i=n-1 ; i>=0 ; --i)
       		FrameGestionVehicule.model.removeRow(i);
       		try {
     			Location.recupererVehicules();
     		} catch (Exception e1) {
     			// TODO Auto-generated catch block
     			e1.printStackTrace();
     		}
        });
        JButton 	Lib = new JButton("Libérer");
        Lib.addActionListener(e -> {
        	Etat el = new EtatLibre();
        	try {
				el.actionEtat(matriculeSelect);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	 int n = FrameGestionVehicule.model.getRowCount();
       		for (int i=n-1 ; i>=0 ; --i)
       		FrameGestionVehicule.model.removeRow(i);
       		try {
     			Location.recupererVehicules();
     		} catch (Exception e1) {
     			// TODO Auto-generated catch block
     			e1.printStackTrace();
     		}
        });
    /*    JButton 	MiseJour = new JButton("Mise à jour");
        MiseJour.addActionListener(e -> {
        int n = FrameGestionVehicule.model.getRowCount();
  		for (int i=n-1 ; i>=0 ; --i)
  		FrameGestionVehicule.model.removeRow(i);
  		try {
			Connect.recupererVehicules();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
       
        });
      */
        
        
      //  Object[] donnees =   {"Swing", "Astral", "standard"} ;
        JButton Aj = new JButton("Ajouter");
        	Aj.addActionListener(e -> {new FrameAjoutVehicule(); });	
        		 model = new DefaultTableModel();
        		 model.setColumnIdentifiers(cols);
        		  jt = new JTable( model)
        	        {     
        	      
        	            public Class getColumnClass(int colonne)
        	            {
        	                return getValueAt(0, colonne).getClass();
        	            }         
        	        };
        	   
        	        
        	        jst = new JScrollPane(jt);
        	        jst.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        	        jt.addMouseListener(new MouseListener() {
        				
        				@Override
        				public void mouseReleased(MouseEvent e) {
        					// TODO Auto-generated method stub
        					
        				}
        				
        				@Override
        				public void mousePressed(MouseEvent e) {
        					ligneSelect = jt.getSelectedRow();
        					  
        					 matriculeSelect = FrameGestionVehicule.model.getValueAt(ligneSelect, 0).toString();
        					
        					 String str = "La véhicule selectionné à un matricule : "+ matriculeSelect ;
        									Console.modif(str);
        								
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
        	    jt.setRowHeight(50);
        		 jt.setFont(new Font("Comic Sans Ms",2,15));
        		// add(jt.getTableHeader(), BorderLayout.PAGE_START);
        	//	add(jt,BorderLayout.CENTER);
        		 add(jst);
        		 pS.add(Aj);
        		 pS.add(new JSeparator(SwingConstants.VERTICAL));
        		 pS.add(Supp);
        		 pS.add(new JSeparator(SwingConstants.VERTICAL));
        		 pS.add(Lib);
        		 pS.add(new JSeparator(SwingConstants.VERTICAL));
        		// pS.add(MiseJour);
        		 add(pS,BorderLayout.SOUTH);
        		 Location.recupererVehicules();
	    setBounds(390, 90, 830, 470);

	    setVisible(true);
	    
	     
}
    

}
