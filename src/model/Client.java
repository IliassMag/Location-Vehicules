package model;

import Vue.Console;

   public class Client implements Cloneable{

    private String CIN ; 
    private String nom ; 
    private String prenom ;
    private int age;

      public Client clone() throws CloneNotSupportedException{
	
        Object c = super.clone();
       
        return (Client)c;
                                                             }

public Client(String CIN ) {this.CIN=CIN;}
public Client(String cIN, String nom, String prenom , int age) {
	 if(age >= 18){  
	CIN = cIN;
	this.nom = nom;
	this.prenom = prenom;
	this.age=age;
	 }	
	 else 
		 Console.modif("Ce persone n'est pas encore adulte , Désolé ce client n'est pas acceptable !");
}



@Override
public String toString() {
	return "Client [nom=" + nom + ", prenom=" + prenom + ", age=" + age + "]";
}

public String getCIN() {
	return CIN;
}
public void setCIN(String cIN) {
	CIN = cIN;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public int getAge() {
	return age;
}


public void setAge(int age) {
	this.age = age;
}





}
