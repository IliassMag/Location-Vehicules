package Connexion;
import java.sql.Blob;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


import Vue.Console;
import Vue.FrameAjoutVehicule;
import Vue.FrameGestionClient;
import Vue.FrameGestionLocation;
import Vue.FrameGestionVehicule;
import Vue.FrameListLocation;
import Vue.FrameRechVehiculesNom;
import Vue.PageGeneral;
import Vue.PanneauCentrale;
import Vue.PanneauHaut;
import model.Client;
import model.ClientCache;
import model.Etat;
import model.EtatLouer;
import model.Voiture;

public class Location {


      public static Connection conn = null ;
      public static PreparedStatement state=null;
      public static ResultSet res=null;
            
   /*   public static void Connection() throws Exception {
    	  
    	  try {
    		  
    	      Class.forName("com.mysql.cj.jdbc.Driver");
    	      
    	       conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/GestionLocation?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
    	        
    	      //Création d'un objet Statement
    	   
    	      //L'objet ResultSet contient le résultat de la requête SQL

    	      if(!conn.isClosed()) 
    	    	  Console.modif("Connexion Successful");
    	
    	     // state.executeQuery("Select * from personne");
    	     
    	     // result.close();
    	    //  state.close(); 
    	    
    	      
    	    } catch (Exception e) {
    	        System.err.println("Exception : "+e.getMessage());
    	      } 
    	  
    	  // Close();
    	 
  	}     
 */     

//    	  public static void Close()throws Exception {
//    		
//    	    	      if(conn != null) {
//    	    	    	  conn.close(); 
//    	    	    Console.modif("Fermeture de connexion");
//    	       
//    	  }
    	    	  
    	//  }
    
    	  public static void InsertVehicule(Object[] d) throws Exception {
    		  String ch1 = (String)d[0];
    		  String ch2 = (String)d[1];
    		  String ch3 = (String)d[2];
    		  String ch4 = (String)d[3];
    		  String ch6 = (String)d[4];
    		  String sql;
    		    conn = SingletonConnection.getConnection();
    		  try { 
    			  Console.modif("Insertion des données Des véhicules"); 
    			  
    	     sql = "INSERT INTO `Vehicules`(`Matricule`, `Type`, `Marque`, `Prix`, `Image`, `Etat`) VALUES (?,?,?,?,?,?)";
    	     state = conn.prepareStatement(sql);
    	     
    	     state.setString(1, ch1);
    	     state.setString(2, ch2);
    	     state.setString(3, ch3);
    	     state.setString(4, ch4);
    	     state.setBlob(5, FrameAjoutVehicule.imgS);
    	     state.setString(6, ch6);
    	     
    	     state.executeUpdate();
    	    
    	     Console.modif("Insertion de véhicule bien fait"); 
    	     
    	     
    	    	    }catch(final Exception e)
    	    	    {Console.modif("Au niveau de 'Connect' il y a un probleme d'insertion");
    	    	    	e.printStackTrace();}
    		  state.close();
    	  }
      
    	  public static void recupererVehicules()throws Exception {
    		   conn = SingletonConnection.getConnection();
    		  try { 
    			 String sql = "select * from `Vehicules`";
   			
    	    	   state = conn.prepareStatement(sql);
    	    	   res = state.executeQuery();    			
    	    	   Console.modif("Récuperation des données Des véhicules"); 
    	    	     Object[] donnees =  new Object[6];
    	     	
    	    	     while(res.next()) {
    	    	    		byte[] imgr = res.getBytes("Image");
    	    	    		ImageIcon image = new ImageIcon(imgr);
    	    	    	    donnees[0]= res.getString(1);
    	    	     		donnees[1]=res.getString(2); 
    	    	     		donnees[2]=res.getString(3); 
    	    	     		donnees[3]=res.getString(4);
    	    	     		donnees[4]=image;
    	    	     		donnees[5]=res.getString(6);
    	    	     		
    	    	     		/* int n = FrameGestionLocation.model.getRowCount();
    	            		for (int i=n-1 ; i>=0 ; --i)
    	            		FrameGestionVehicule.model.removeRow(i); */
    	            		
    	    	     		FrameGestionVehicule.model.addRow(donnees);
    	    	     }
    	    	    
    	    	        Console.modif("Récuperation bien fait");
    	    	        
    	    	    } catch(Exception e)  {   
    	    	    	Console.modif("Récupération échouée");
    	    	    	e.printStackTrace();}
    		  state.close();
    	            }
    	  
    	  
    	  
    	  public static void recupererClients()throws Exception {
    		  conn = SingletonConnection.getConnection();
    		  try { 
    			 String sql = "select * from `Clients`";
   			
    	    	   state = conn.prepareStatement(sql);
    	    	   res = state.executeQuery();    			
    	    	   Console.modif("Récuperation des données Des Clients"); 
    	    	     Object[] donnees =  new Object[4];
    	     	
    	    	     while(res.next()) {
    	    	    		
    	    	    	    donnees[0]= res.getString(1);
    	    	     		donnees[1]=res.getString(2); 
    	    	     		donnees[2]=res.getString(3); 
    	    	     		donnees[3]=res.getInt(4);
    	    	     		
    	    	     		
    	    	     		/*int n = FrameGestionClient.model.getRowCount();
    	            		for (int i=n-1 ; i>=0 ; --i)
    	            		FrameGestionClient.model.removeRow(i);*/
    	    	     		FrameGestionClient.model.addRow(donnees);
    	    	     }
    	    	     Console.modif("Récuperation des clients bien fait");
    	    	    
    	    	    }catch(Exception e)
    	    	    { Console.modif("Récupération des clients échouée");
    	    	    	e.printStackTrace();}
    		  state.close();
    	  }
    	  
    	  public static void chargerClientsDansHashMap()throws Exception {
    		  conn = SingletonConnection.getConnection();
    		  try { 
    			 String sql = "select * from `Clients`";
   			
    	    	   state = conn.prepareStatement(sql);
    	    	   res = state.executeQuery();    			
    	    	   Console.modif("Récuperation des données Des Enregistrements des Clients "); 
    	    	     Object[] donnees =  new Object[4];
    	     	
    	    	     while(res.next()) {
    	    	    		
    	    	    	    donnees[0]= res.getString(1);
    	    	     		donnees[1]=res.getString(2); 
    	    	     		donnees[2]=res.getString(3); 
    	    	     		donnees[3]=res.getInt(4);
    	    	     	ClientCache.clientMap.put((String)donnees[0],new Client((String)donnees[0],(String)donnees[1],(String)donnees[2],(int)donnees[3]));
    	    	     }
    	    	     Console.modif("Récuperation des Enregistrements clients bien fait");
    	    	    }catch(Exception e)
    	    	    { Console.modif("Récupération des clients échouée");
    	    	    	e.printStackTrace();}
    		  state.close();
    	  }
    	  
    	  public static void InsertClient(Client c) throws Exception {
    		  conn = SingletonConnection.getConnection();
    	    		  
    		  String  sql = "INSERT INTO `Clients`(`CIN`, `Nom`, `Prenom`, `Age`) VALUES (?,?,?,?)";
    		try {
    			Console.modif("Insertion d'un client");
    		state = conn.prepareStatement(sql);
    		 state.setString(1, c.getCIN());
    	     state.setString(2, c.getNom());
    	     state.setString(3, c.getPrenom());
    	     state.setInt(4, c.getAge());
    	     state.executeUpdate();
    	     Console.modif("Insertion du client est bien bien fait");
    		}catch(Exception e) {
    			Console.modif("l'Insertion du client n'a pas éfectuer correctement");
    			e.printStackTrace();
    		}
    	     state.close();
    	  }
    	  
    	  public static void InsertLocation() throws Exception {
    		  conn = SingletonConnection.getConnection();
    	    		  
    		  String  sql = "INSERT INTO `location`(`MatriculeVoiture`, `CINclient`, `prixLoc`, `DateDepart`, `DateArrivee`) VALUES  (?,?,?,?,?)";
    		try {
    			Console.modif("Insertion d'une location ");
    		state = conn.prepareStatement(sql);
    		 state.setString(1, FrameGestionLocation.matSelect);
    	     state.setString(2, FrameGestionLocation.cinselect.getText());
    	     state.setString(3,  FrameGestionLocation.prxSelect);
    	     state.setString(4,  FrameGestionLocation.dateDEp.getText());
    	     state.setString(5,  FrameGestionLocation.dateARv.getText());
    	     state.executeUpdate();
    	     Console.modif("Insertion du location est bien fait");
    		}catch(Exception e) {
    			Console.modif("Insertion du location n'a pas effectuer correctement");
    			e.printStackTrace();
    		}
    		state.close();
    	  }
    	  
    	  public static void changerEtatVehiculeLibreAuLouer(String MatriculeLouer) throws Exception {
    		  conn = SingletonConnection.getConnection();
    	    		  
    		  String  sql = "UPDATE `vehicules` SET Etat = ? WHERE Matricule = ? ";
    		  
    		try {
    			Console.modif("Mise à jour table 'Vehicules' ");
    		state = conn.prepareStatement(sql);
    		state.setString(1, "Louer");
    		state.setString(2, MatriculeLouer);
    		 state.executeUpdate();
    	     Console.modif("Mise à jour est bien fait");
    		}catch(Exception e) {
    			Console.modif("Mise à jour n'a pas effectuer correctement");
    			e.printStackTrace();
    		}
    		 state.close();
    	  }
    	  
    	  public static void changerEtatVehiculeLouerAuLibre(String MatriculeLouer) throws Exception {
    		  conn = SingletonConnection.getConnection();
    	    		  
    		  String  sql = "UPDATE `vehicules` SET Etat = ? WHERE Matricule = ? ";
    		  
    		try {
    			Console.modif("Mise à jour table 'Vehicules' ");
    		state = conn.prepareStatement(sql);
    		state.setString(1, "Libre");
    		state.setString(2, MatriculeLouer);
    		 state.executeUpdate();
    	     Console.modif("Mise à jour est bien fait");
    		}catch(Exception e) {
    			Console.modif("Mise à jour n'a pas effectuer correctement");
    			e.printStackTrace();
    		}
    		 state.close();
    	  }
    	  
    	  public static void recupererVehiculesLibre(String typ)throws Exception {
    		  conn = SingletonConnection.getConnection();
    		  String sql="";
    		  if(typ.equalsIgnoreCase("Voiture"))
    		  sql = "Select * from `vehicules` where `Etat`='Libre' AND `Type`='Voiture'  ";  /*WHERE `Etat`= 'Libre' and `Type`=?*/
    		  if(typ.equalsIgnoreCase("Moto"))
    			  sql = "Select * from `vehicules` where `Etat`='Libre' AND `Type`='Moto'  ";
    		  if(typ.equalsIgnoreCase("Camion"))
    		      sql = "Select * from `vehicules` where `Etat`='Libre' AND `Type`='Camion'  ";
    		      // String etat = 'Libre';
    			try {
    				//stateDep = conn.createStatement();
    				 state = (PreparedStatement)conn.prepareStatement(sql);
    		  //     state.setString(2,typ);
    		//	  state.setString(6,etat);
    	    		  res = state.executeQuery();    			
       	    	   Console.modif("Récuperation des données Des véhicules qui ont l'état <<Libre>> "); 
       	    	     Object[] donnees =  new Object[4];
       	    	     while(res.next()) {
       	    	    		byte[] imgr = res.getBytes("Image");
       	    	    		ImageIcon image = new ImageIcon(imgr);
       	    	    	    donnees[0]= res.getString(1);
       	    	     		donnees[1]=res.getString(3); 
       	    	     		donnees[2]=res.getString(4); 
       	    	     		donnees[3]=image;
       	    	     		FrameGestionLocation.model.addRow(donnees);
       	    	     	 Console.modif("Récuperation bien fait <<libre>>"); 
       	    	         }
    	    		}catch(Exception e) {
    	    			 Console.modif("il y'a un problème de Récuperation <<libre>> !! "); 
    	    			e.printStackTrace();
    	    		}
    			 state.close();
    	  }
   

    	  public static void recupererLocations()throws Exception {
    		  conn = SingletonConnection.getConnection();
    		  try { 
    			 String sql = "select * from `Location`";
   			
    	    	   state = conn.prepareStatement(sql);
    	    	   res = state.executeQuery();    			
    	    	   Console.modif("Récuperation des données de Location"); 
    	    	     Object[] donnees =  new Object[6];
    	     	
    	    	     while(res.next()) {
    	    	    	
    	    	    	    donnees[0]= res.getInt(1);
    	    	     		donnees[1]=res.getString(2); 
    	    	     		donnees[2]=res.getString(3); 
    	    	     		donnees[3]=res.getString(4);
    	    	     		donnees[4]=res.getString(5);
    	    	     		donnees[5]=res.getString(6);
    	    	     		
    	    	     		/* int n = FrameGestionLocation.model.getRowCount();
    	            		for (int i=n-1 ; i>=0 ; --i)
    	            		FrameGestionVehicule.model.removeRow(i); */
    	            		
    	    	     		FrameListLocation.model.addRow(donnees);
    	    	     }
    	    	     Console.modif("Récuperation bien fait");
    	    	    }catch(Exception e)
    	    	    { Console.modif("Récupération échouée");
    	    	    	e.printStackTrace();}
    		  state.close();
    	  }

    	

		public static void suppVehicule(String ms) throws Exception {
			conn = SingletonConnection.getConnection();
  		  String  sql = "delete from `vehicules` where `Matricule`=?";
  		try {
  			Console.modif("Suppression d'une Véhicule");
  		state = conn.prepareStatement(sql);
  		 state.setString(1, ms);
  	     state.executeUpdate();
  	     Console.modif("Suppression du Véhicule bien fait");
  		}catch(Exception e) {
  			Console.modif("Suppression du Véhicule n'a pas effectuer correctement");
  			e.printStackTrace();
  		}
  		 state.close();
			
		}
    	  
 /*   	  public void CompteurVehicules() throws Exception {
    		  Connection();
    		  try { 
    			 String sql = "select count(*) from `Vehicules`";
   			
    	    	   state = conn.prepareStatement(sql);
    	    	   res = state.executeQuery();    			
    	    	   Console.modif("en cours de compter les véhicules"); 
    	    	   while(res.next()) {
    	    	    	
	    	    	 PanneauCentrale.CptVehGlobal  = res.getInt(1);
	    	     		
	    	     }
    	    	     Console.modif("Compteur des véhicules bien fait");
    	    	    }catch(Exception e)
    	    	    { Console.modif("Récupération échouée");
    	    	    	e.printStackTrace();}
    		  Close();
    	  }
  */
		 public static void chercherVehiculesNom(String marque)throws Exception {
			 conn = SingletonConnection.getConnection();
   		  String sql="";
   		boolean exist=false;
   		int instance = 0;
   		marque+="%";
   		String[] splitArray = null; 
   		  sql = "Select * from `vehicules` where `Marque` like ?  ";  /*WHERE `Etat`= 'Libre' and `Type`=?*/
   		  
   			try {
   				//stateDep = conn.createStatement();
   				 state = (PreparedStatement)conn.prepareStatement(sql);
   		      state.setString(1,marque);
   		   splitArray = marque.split("%");
   	    		  res = state.executeQuery();    			
      	    	   Console.modif("Récuperation des véhicules qui ont la marque : "+marque); 
      	    	     Object[] donnees =  new Object[6];
      	    	     while(res.next()) {
      	    	    		byte[] imgr = res.getBytes("Image");
      	    	    		ImageIcon image = new ImageIcon(imgr);
      	    	    	    donnees[0]= res.getString(1);
      	    	     		donnees[1]=res.getString(2); 
      	    	     		donnees[2]=res.getString(3); 
      	    	     		donnees[3]=res.getString(4);
      	    	     		donnees[4]=image;
      	    	     		donnees[5]=res.getString(6);
      	    	     		exist = true;
      	    	     	  if(exist)		{
      	    	     		Console.modif("Début de récupération des véhicules qui ont la marque : "+splitArray[0]); 
      	    	     		    if(instance == 0) {
      	    	     		new FrameRechVehiculesNom(); instance++;
      	    	     		    }
        	    	     		FrameRechVehiculesNom.model.addRow(donnees);
        	    	         }
      	    	     	
      	    	     		}
      	    	   if(!exist) {
 	    	     		Console.modif("Il y'a pas de véhicule de marque : "+splitArray[0]); 
JOptionPane.showMessageDialog(null,"Il y'a pas de véhicule de marque : "+splitArray[0],"Alert",JOptionPane.WARNING_MESSAGE);  
 	    	     		  
 	    	     	  }
   	    		}catch(Exception e) {
   	    			 Console.modif("il y'a un problème de Récuperation de la marque "+marque+" !! "); 
   	    			e.printStackTrace();
   	    		}
   		 state.close();
   	  }
		/* public static void chercherClient(String key)throws Exception {
   		  Connection();
   		boolean exist = false;
  		 int instance=0;
   		  try { 
   			  key+="%";
   			 String sql = "select * from `Clients` where 'CIN' like ? OR 'Nom' like ? OR 'Prenom' like ? ";
   			
   	    	   state = conn.prepareStatement(sql);
   	     	state.setString(1,key);
   	    	state.setString(2,key);
   	    	state.setString(3,key);
   	    	   res = state.executeQuery();    			
   	    	   Console.modif("Récuperation des données Des Clients recherches par : "+ key); 
   	    	     Object[] donnees =  new Object[4];
   	     	
   	    	     while(res.next()) {
   	    	    	Console.modif("Debut boucle ");
   	    	    	    donnees[0]= res.getString(1);
   	    	     		donnees[1]=res.getString(2); 
   	    	     		donnees[2]=res.getString(3); 
   	    	     		donnees[3]=res.getInt(4);
   	    	     exist = true ;
	    	     	  if(exist)		{
	    	     		Console.modif("Début de récupération des clients qui ont le nom de recherche  : "+key); 
	    	     		   
							if(instance == 0) {
	    	     		  FrameRechVClient frvc=new FrameRechVClient(); 
	    	     		 Console.modif("Création d'instance");
	    	     		  instance++;
	    	     		    }
  	    	     		FrameRechVClient.model.addRow(donnees);
  	    	     		Console.modif("Ajour dans FrameRechClient");
  	    	         }
	    	     	  else {
	    	     		Console.modif("Il y'a pas de  clients qui ont le nom de recherche  : "+key); 
JOptionPane.showMessageDialog(null,"Il y'a pas de  clients qui ont le nom de recherche  : "+key,"Alert",JOptionPane.WARNING_MESSAGE);  
	    	     		  
	    	     	  }
   	    	     }
   	    	    // Console.modif("Récuperation des clients bien fait");
   	    	    }catch(Exception e)
   	    	    { Console.modif("Récupération des clients échouée");
   	    	    	e.printStackTrace();}
   		  Close();
   	  }
*/
		 
  }

