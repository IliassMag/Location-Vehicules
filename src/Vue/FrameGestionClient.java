package Vue;

import java.awt.BorderLayout;
import java.awt.Font;

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



public class  FrameGestionClient  extends JDialog{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public JPanel pS;
		public static JScrollPane jst;
	   public static JTable jt;
	   public static DefaultTableModel model ;
	   public static Object[] cols = { 
			  "CIN","Nom","Prenom","Age"
			   };
	  
	    public FrameGestionClient() throws Exception {
	    	
	    //   pS=new JPanel();
	       	      	
	        		 model = new DefaultTableModel();
	        		 model.setColumnIdentifiers(cols);
	        		  jt = new JTable( model)
	        	        {     
	        	      
	        	            /**
							 * 
							 */
							private static final long serialVersionUID = 1L;

							public Class getColumnClass(int colonne)
	        	            {
	        	                return getValueAt(0, colonne).getClass();
	        	            }         
	        	        };
	        	        
	        	        DefaultTableCellRenderer custom = new DefaultTableCellRenderer(); 
	        	        custom.setHorizontalAlignment(JLabel.CENTER);
	        	        for (int i=0 ; i < jt.getColumnCount() ; i++) // centre chaque cellule de ton tableau
	        	        	jt.getColumnModel().getColumn(i).setCellRenderer(custom); 
	        	        
	        	        jst = new JScrollPane(jt);
	        	        jst.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	        	    jt.setRowHeight(50);
	        		 jt.setFont(new Font("Comic Sans Ms",2,15));
	        		// add(jt.getTableHeader(), BorderLayout.PAGE_START);
	        	//	add(jt,BorderLayout.CENTER);
	        		 add(jst);
	        		
	        		// add(pS,BorderLayout.SOUTH);
           Location.recupererClients();
		    setBounds(390, 90, 830, 470);

		    setVisible(true);
		    
		     
	}
	    

	}
	

