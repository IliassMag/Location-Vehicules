package model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import Connexion.Location;
import Vue.Console;

   public class ClientCache {
		
	   public static HashMap<String, Client> clientMap  = new HashMap<>();
	   private static boolean charger=false;
 
	   public static Client getClient(String CIN,String NOM , String PRE , int AGE) throws Exception {
		      Client c = (Client)clientMap.get(CIN);
		      if(c == null) {
		         c = new Client(CIN,NOM,PRE,AGE);
		         clientMap.put(CIN, c);
		     Console.modif("Création de client qui a le CIN : " + CIN);
		      }
		      return c;
		   }
	   
	   public static void chargerclientMap() throws Exception {
		   if(charger==false) {
			   Console.modif("Chargement des client ... ");
		   Location.chargerClientsDansHashMap();
		   Console.modif("Chargement bien fait ... ");
		   charger=true;
		   }
		   // do nothing
	   }
	
	   public static void afficherClients() {
		   Iterator iterator = clientMap.entrySet().iterator();
		    Console.modif("Mes Clients sont : ");
	        while (iterator.hasNext()) {
	        	Map.Entry mapentry = (Map.Entry) iterator.next();
	          Console.modif("CIN: "+mapentry.getKey().toString()
	                            + " | " + mapentry.getValue().toString());
	        } 
	   }
   }
   
   
   
	   
	 
//
//	 
//
//	   public static void loadCacheClient(Client c) {
//		   
//		 getClientMap().put(c.getCIN(),c);  
//		 
//	                                                }
//
//	public static HashMap<String, Client> getClientMap() {
//		return clientMap;
//	}
//
//	public static void setClientMap(HashMap<String, Client> clientMap) {
//		ClientCache.clientMap = clientMap;
//	}
//	

//                          
//   }
//
//    