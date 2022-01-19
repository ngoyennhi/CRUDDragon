package crudDRAGON;

import java.sql.Statement;

import test.Ingredient;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuerryDragon extends MyConnexion {
	/**
	* Creation d'un nouveau dragon
	* @param dragon
	* @return // true si insertion reussite
	*/
	
	//Il est toujours interessant de savoir si l'insersion a reussie ou non. Nous rajoutons un "flag", en sortie pour
		//recuperer cette information
		public static boolean create() {
		boolean flag = false;
		try {
				//saisir la valeur 
		System.out.println("Saisissez le nom de dragon, svp");	
	    String nomDragon = Clavier.lireString();	
	   
		String query = "INSERT INTO `dragons` (`dragon`) " 
		+ "VALUES(?)"; 
	   
		//preparer statement for un querry
		PreparedStatement  declaration = accessDataBase.prepareStatement(query);
	    //ajouter dragon sur la position "?"
	   declaration.setString(1, nomDragon);
	   
		int executeUpdate = declaration.executeUpdate();
		flag = (executeUpdate == 1);
		} catch (Exception e) {
		System.err.println(
		"Erreur d'insertion dragon: " + e.getMessage()
		);
		}
		return flag;
		}
		
		
		/**
		* Action de lire les tous les ingr�dients
		*/	
		public static boolean readAll() {
			boolean flag = false;
			try {
				Statement declaration = accessDataBase.createStatement();
				String query = "SELECT id, nom FROM ingredients;";
				ResultSet resultat = declaration.executeQuery(query);
				/*
				* Recuperation des donnees
				*/
				while (resultat.next()) {
					dragons ing = new dragons();
					ing.setDragon(resultat.getString("dragon"));
					ing.setSexe(resultat.getString("sexe"));
					ing.setNombreEcailles(resultat.getInt("nombreEcailles"));
					ing.setLongueur(resultat.getInt("longueur"));
					ing.setComportementAmoureux(resultat.getString("comportementAmoureux"));
					ing.setCracheDuFeu(resultat.getString("cracheDuFeu"));
					System.out.println(ing.toString());
					}
				} catch (Exception e) {
				System.err.println(
				"Erreur d'affichage d'ing: " + e.getMessage()
				);
				}
			return flag;
		}
		/**
		* Ici on test
		* @param args the command line arguments
		*/
		public static void main(String[] args) {
			openConnection();
			// avant
			readAll();
//			// cr�ation
//			create();
//			// delete
//			delete(1); 
//			// delete by name
////			deleteByName("mais");
//			deleteByName("mais\" OR \"\" = \"");
			
			//Update
			update();
			// final
			readAll();
			closeConnection();
	}
}
