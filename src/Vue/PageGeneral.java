package Vue;




import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import model.ClientCache;



public class PageGeneral extends JFrame {
	private static Dimension taille ;

	private static final long serialVersionUID = 1L;

	public PageGeneral(String name) throws Exception { 
	    super(name);
		setSize(1350,700);
		setLocationRelativeTo(null);
		
		getContentPane().add(new PanneauGlobal());
		
	 	//	 Image im = Toolkit.getDefaultToolkit().getImage("D:\\jee project\\Gestion de location des véhicules\\src\\C.jpg");
	 		
		//		this.setIconImage(im);
			
	 	
		setDefaultCloseOperation(3);
	//	setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) throws Exception {
		
		SwingUtilities.invokeLater(new Runnable() {
        
            public void run()
            {
         
	try {
			// UIManager.setLookAndFeel(new com.jtattoo.plaf.graphite.GraphiteLookAndFeel());
		UIManager.setLookAndFeel(new com.jtattoo.plaf.aluminium.AluminiumLookAndFeel());
	
		
		} catch (UnsupportedLookAndFeelException e) {
		
			e.printStackTrace();
		}

		try {
			 new PageGeneral("Gestion de location des véhicules");
			Console.modif("Bienvenu au application de <<Gestion de location des véhicules>> ");
			ClientCache.chargerclientMap();
			ClientCache.afficherClients();			
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
              }
		});
 	

}
}
