package model;

import javax.swing.ImageIcon;

public class Camion  extends Vehicule {

	public String marque ;
	public static ImageIcon img ;

	public Camion(){ super();}
			
	public Camion(String marque,String type, String matricule , String px) {
		super(type, matricule,px);
		this.marque=marque;
	}
		
	public String toString() { return super.toString()+", et la marque : " + marque; }
	
	public String getMatricule() {
		return super.matricule;
	}
}
