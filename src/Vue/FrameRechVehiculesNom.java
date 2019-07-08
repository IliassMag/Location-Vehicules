package Vue;

import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class FrameRechVehiculesNom extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static JScrollPane jst;
	   public static JTable jt;
	   public static DefaultTableModel model ;
	   public static Object[] cols = { 
			   "Matricule","Type","Marque","Prix","Image","Etat"
			   };
	   
	   public FrameRechVehiculesNom() {
		   model = new DefaultTableModel();
  		 model.setColumnIdentifiers(cols);
  		  jt = new JTable( model)
  	        {  
  	            
				private static final long serialVersionUID = 1L;

				public Class getColumnClass(int colonne)
  	            {
  	                return getValueAt(0, colonne).getClass();
  	            }         
  	        };
  	      jst = new JScrollPane(jt);
	        jst.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    jt.setRowHeight(50);
		 jt.setFont(new Font("Comic Sans Ms",2,15));
				 add(jst);
				 setBounds(390, 90, 830, 250);

				    setVisible(true);
	   }
	  
}
