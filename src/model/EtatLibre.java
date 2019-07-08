package model;

import Connexion.Location;

   public class EtatLibre implements Etat{
	
	  private static String chaineEtat="Libre";
	
	  
	  public void actionEtat(String matricule) throws Exception {
		  
			 Location.changerEtatVehiculeLouerAuLibre(matricule);
			 
		 }
	  
	public String getEtat() {
		
		return chaineEtat;
	}

	public void setEtat(String ch) {
		chaineEtat=ch;		
	}
	
	 
	
}
