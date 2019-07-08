package model;


// Factory Pattern 

  public class VehiculeFactory {
  
	  public Vehicule getVehicule(String marque,String type, String matricule,String px){
	     	      
	      if(type.equalsIgnoreCase("VOITURE"))
	    	  
	         return new Voiture(marque,type,matricule,px);
	         
	       if(type.equalsIgnoreCase("CAMION"))
	    	   
	    	 return new Camion(marque,type,matricule,px);
	         
	    if(type.equalsIgnoreCase("MOTO"))
	    	
	         return new Moto(marque,type,matricule,px);
	      
	      
	      return null;
	                                                                                     }
	
	
                               }
  
  
