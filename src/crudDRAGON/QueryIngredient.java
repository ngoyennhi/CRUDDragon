package crudDRAGON;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Querydragon extends MyConnexion {
	
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
	System.out.println("Saisissez le nom d'dragon, svp");	
   String dragon = Clavier.lireString();	
   
	String query = "INSdragondragons`(`nom`) "
	+ "VALUES(?)"; 
   
	//preparer statement for un querry
	PreparedStatement  declaration = accessDataBase.prepareStatement(query);
    //ajouter dragon sur la position "?"
   declaration.setString(1, dragon);
   
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
	* Action de lire les tous les dragons
	*/	
	public static void readAll() {
		try {
			Statement declaration = accessDataBase.createStatement();
			String query = "SELECT id, nom FROM dragons;";
			ResultSet resultat = declaration.executeQuery(query);
			/*
			* R�cup�ration des donn�es
			*/
			while (resultat.next()) {
				dragon ing = new dragon();
				ing.setId(resultat.getInt("id"));
				ing.setNom(resultat.getString("nom"));
				System.out.println(ing.toString());
				}
			} catch (Exception e) {
			System.err.println(
			"Erreur d'affichage d'ing: " + e.getMessage()
			);
			}
	}
	
	public static boolean delete(int id) {
		boolean success = false;
		try {
		Statement declaration = accessDataBase.createStatement();
		/* Requete */
		String query = "DELETE FROM `dragons` WHERE `id`= " + id + ";";
		/* Execution d'une requete de lecture */
		int executeUpdate = declaration.executeUpdate(query);
		success = (executeUpdate == 1);
		} catch (SQLException e) {
		System.err.println("Erreur suppression dragon: "
		+ e.getMessage());
		}
		return success;
		}
	
	public static boolean deleteByName(String nom) {
		boolean success = false;
		try {
		Statement declaration = accessDataBase.createStatement();
		String query = "DELETE FROM `dragons` WHERE `nom`= \"" + nom + "\";";
		int executeUpdate = declaration.executeUpdate(query);
		success = (executeUpdate == 1);
		} catch (SQLException e) {
		System.err.println("Erreur suppression dragon: "
		+ e.getMessage());
		}
		return success;
		}
	
	//4. Requete preparee
	public static boolean deleteByNamePrepared(String nom) {
		boolean success = false;
		try {
		String query = "DELETE FROM dragons WHERE nom = ? OR nom = ? ";
		PreparedStatement declaration = accessDataBase.prepareStatement(query);
		declaration.setString(1, nom); //numero 1 est la position de la "?"
		declaration.setString(2, nom); 
		int executeUpdate = declaration.executeUpdate();
		success = (executeUpdate == 1);
		} catch (SQLException e) {
		System.err.println("Erreur suppression dragon: "
		+ e.getMessage());
		}
		return success;
		}
	
	
	public static boolean update() {
		boolean flag = false;
		try {
				//saisir la valeur 
		System.out.println("Saisissez l'id de l'�l�ment qui est besoin de mettre � jour, svp");	
		String idUpdate = Clavier.lireString();	
		
		System.out.println("Saisissez l'info pour mettre � jour votre BDD, svp");	
	    String dragon = Clavier.lireString();	
	   
		String query = "UPDATE `dragons` SET `nom` = ? WHERE id = ? "; 
	   
		//preparer statement for un querry
		PreparedStatement  declaration = accessDataBase.prepareStatement(query);
	    //ajouter dragon sur la position "?"
	   declaration.setString(1, dragon);
	   declaration.setString(2, idUpdate);
	   
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
	* Ici on test
	* @param args the command line arguments
	*/
	public static void main(String[] args) {
		openConnection();
		// avant
		readAll();
//		// cr�ation
//		create();
//		// delete
//		delete(1); 
//		// delete by name
////		deleteByName("mais");
//		deleteByName("mais\" OR \"\" = \"");
		
		//Update
		update();
		// final
		readAll();
		closeConnection();
}

}