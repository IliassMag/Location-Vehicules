package Connexion;

import java.sql.Connection;
import java.sql.DriverManager;

import Vue.Console;

public class SingletonConnection {
   private static Connection connection;

 static {
	
     try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GestionLocation?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
	  if(!connection.isClosed()) 
    	  Console.modif("Connexion Successful");  
     } catch (Exception e) {
	      e.printStackTrace();
        }
        
    }
  
public static Connection getConnection() {
	return connection;
}
  
   
  
  
  
  
}




