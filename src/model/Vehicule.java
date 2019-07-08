package model;

import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Vue.Console;
import Vue.FrameAjoutVehicule;

public abstract class Vehicule  {
	public String type;
	public String matricule;
	public String prixLocation;
	public static LinkedList<Vehicule> Vehicules ;
	public Etat et ;
	static {
		Vehicules = new LinkedList<>();
	}
	
	public Vehicule() {}
	public Vehicule(String type, String matricule , String pr) {
		if(!chercher(matricule)) {
		this.type = type;
		this.matricule = matricule;
		this.prixLocation=pr;
		et = new EtatLibre();
		ajouterVehicule(this);
		}
		else Console.modif("Vehicule existe déjà !! ");
	}
	
	
/* public static void setEtat(Etat ech) {
	et = ech; 	
}
public static String getEtat() {
	
	if(et==Etat.Libre) return "Libre";
	if(et==Etat.louer) return "Louer";
	if(et==Etat.en_panne) return "en panne";
	
	return null;
	
}
*/
	public String toString() { return "Je suis la véhicule de matricule : " + matricule + " qui a le prix de location : "+prixLocation; }
	
	public boolean chercher(String Mat) {
		for(Vehicule vc : Vehicules) {
			if(vc.matricule.equalsIgnoreCase(Mat)) 
				return true;
		}
		return false;
	}
	
	public void ajouterVehicule(Vehicule va) {
		Vehicules.add(va);
	}
	
	public void suppVehicule(Vehicule va) {
		Vehicules.remove(va);
	}
	
}
