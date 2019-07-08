package model;

import javax.swing.ImageIcon;

import Vue.FrameAjoutVehicule;

public class Voiture extends Vehicule {
	
	public String marque ;
	public static ImageIcon img ;

	public Voiture(){ super();}
			
	public Voiture(String marque,String type, String matricule , String px) {
		super(type, matricule,px);
		this.marque=marque;
	}
		
	public String toString() { return super.toString()+", et la marque : " + marque; }

	

	
	
}
