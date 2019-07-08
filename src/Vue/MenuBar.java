package Vue;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MenuBar extends JMenuBar {
	
	public JMenu LV,LC;
	public MenuBar() {
	
		LV=new JMenu("Ajouter Véhicule");    
		LC=new JMenu("Ajouter client");    
		add(LV); add(LC);
		
	}
	
	
}

