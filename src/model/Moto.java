package model;

import javax.swing.ImageIcon;

public class Moto extends Vehicule{
	public String marque ;
	public static ImageIcon img ;

	public  Moto(){ super();}
			
	public  Moto (String marque,String type, String matricule , String px) {
		super(type, matricule,px);
		this.marque=marque;
	}
		
	public String toString() { return super.toString()+", et la marque : " + marque; }
}
