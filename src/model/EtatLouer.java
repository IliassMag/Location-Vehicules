package model;

import Connexion.Location;

    public class EtatLouer implements Etat{
	   
      public static String chaineEtat="Louer";
      
      public void actionEtat(String matricule) throws Exception {
     	 
 		 Location.changerEtatVehiculeLibreAuLouer(matricule);
 		 
 	                                                           }
       
	     @Override
	     public String getEtat() {
		
	     	return chaineEtat;
	                             }

         @Override
	     public void setEtat(String ch) {
        	 
		     chaineEtat=ch;		
	                                        }
         
         

                                         }
   
   
   
   
   

   
   