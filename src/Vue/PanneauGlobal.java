package Vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import javafx.scene.control.Separator;

public class PanneauGlobal extends JPanel {
	
	public PanneauGlobal() throws IOException{
		JSeparator sp,spp,sppp;
		JPanel p = new JPanel();
		GridLayout sauv = new GridLayout(1,0);
		p.setLayout(sauv);
		p.add(new PanneauHaut());
	
		setLayout(new BorderLayout());
		add(p,BorderLayout.NORTH);
		
		add(new JSeparator(SwingConstants.HORIZONTAL));
	
		add(new PanelGauche(),BorderLayout.WEST);
		
	add(new PanneauCentrale(),BorderLayout.CENTER);

	add(new Console(),BorderLayout.SOUTH);
	}

}
