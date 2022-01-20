package crudDRAGON;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuerryDragon extends MyConnexion {
	/**
	 * Add a new dragon
	 * 
	 * @param dragon
	 * @return // true if the insertion was successful
	 */
	// It is always interesting to know if the insertion was successful or not.
	// We add a "flag" at the output to retrieve this information.
	public static boolean create() {
		boolean flag = false;
		try {
			// enter the informations of the dragon
			System.out.println("Please give me the informations about your dragon!");
			System.out.println("What is your dragon's name?");
			String nomDragon = Clavier.lireString();
			System.out.println("What is your dragon's gender? M-male F-female");
			String sexeDragon = Clavier.lireString();
			System.out.println("How many centimeters long is your dragon?");
			int longDragon = Clavier.lireInt();
			System.out.println("How many scales does your dragon have? ");
			int scalesDragon = Clavier.lireInt();
			System.out.println("Does your dragon can spit fire? oui-Yes, he/she can  non-No, he/she can't");
			String spitFireDragon = Clavier.lireString();
			System.out.println("What's your dragon's behavior?(ex:funny,cute,etc");
			String behaviorDragon = Clavier.lireString();

			// query to insert your infos into table dragons
			String query = "INSERT INTO dragons (dragon,sexe,longueur,nombreEcailles,cracheDuFeu,comportementAmoureux) VALUES(?,?,?,?,?,?)";

			// prepare statement for a query
			PreparedStatement declaration = accessDataBase.prepareStatement(query);

			// declation the infos
			declaration.setString(1, nomDragon);
			declaration.setString(2, sexeDragon);
			declaration.setInt(3, longDragon);
			declaration.setInt(4, scalesDragon);
			declaration.setString(5, spitFireDragon);
			declaration.setString(6, behaviorDragon);

			// run
			int executeUpdate = declaration.executeUpdate();
			flag = (executeUpdate == 1);
		} catch (Exception e) {
			System.err.println("Error of create(): " + e.getMessage());
		}
		System.out.println("Well done!");
		return flag;
	}

	/**
	 * Action to show off your own database
	 */
	public static boolean readAll() {
		boolean flag = false;
		try {
			Statement declaration = accessDataBase.createStatement();
			// SQL query
			String query = "SELECT * FROM dragons;";
			ResultSet resultat = declaration.executeQuery(query);

			/*
			 * Data recovery
			 */
			while (resultat.next()) {
				dragons ing = new dragons();
				ing.setId(resultat.getInt("id"));
				ing.setNomDragon(resultat.getString("dragon"));
				ing.setSexeDragon(resultat.getString("sexe"));
				ing.setLongDragon(resultat.getInt("longueur"));
				ing.setScalesDragon(resultat.getInt("nombreEcailles"));
				ing.setSpitFireDragon(resultat.getString("cracheDuFeu"));
				ing.setBehaviorDragon(resultat.getString("comportementAmoureux"));
				System.out.println(ing.toString());
			}
		} catch (Exception e) {
			System.err.println("Error of readAll(): " + e.getMessage());
		}
		System.out.println("Well done!");
		return flag;
	}

	/**
	 * Action to show off the id and the name of all dragons in your database
	 */
	public static boolean readName() {
		boolean flag = false;
		try {
			Statement declaration = accessDataBase.createStatement();
			// SQL query
			String query = "SELECT id,dragon FROM dragons;";
			ResultSet resultat = declaration.executeQuery(query);
			/*
			 * Data recovery
			 */
			while (resultat.next()) {
				dragons ing = new dragons();
				ing.setId(resultat.getInt("id"));
				ing.setNomDragon(resultat.getString("dragon"));

				System.out.println(Integer.toString(ing.getId()) + " - " + ing.getNomDragon().toString());
			}
		} catch (Exception e) {
			System.err.println("Error of readName(): " + e.getMessage());
		}
		return flag;
	}

	/**
	 * Action to delete a dragon in your database
	 */
	public static boolean deleteDragon() {
		boolean success = false;
		try {
			System.out.println("You need to delete a dragon? ok! what's its name?");
			readName();
			System.out.println("Give me a number which you choose, please.");
			int idDragon = Clavier.lireInt();

			// SQL query to delete a dragon by id ( which was seleted by user)
			String query = "DELETE FROM dragons WHERE id = ?";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);

			// idDragon will be replaced into "?" in the query SQL
			declaration.setInt(1, idDragon);

			int executeUpdate = declaration.executeUpdate();
			success = (executeUpdate == 1);
		} catch (SQLException e) {
			System.err.println("Error of delete(): " + e.getMessage());
		}
		System.out.println("Well done!");
		return success;
	}

	/**
	 * Action to update the infos of dragon in your database
	 */
	public static boolean updateDragon() {
		boolean flag = false;
		// saisir la valeur
		System.out.println("Give me the dragon's id which you want to update, pls");
		int idUpdate = Clavier.lireInt();
		System.out.println("which detail do you want to modify? Choose one of list, pls");
		System.out.println("1-Name; 2-Gendre; 3-Long; 4-scales; 5-spitFire; 6-behavior");
		int detailUpdate = Clavier.lireInt();
		switch (detailUpdate) {
		// Modify name
		case 1:
			try {
				// query SQL
				String query = "UPDATE dragons SET dragon = ? WHERE id = ? ";
				PreparedStatement declaration = accessDataBase.prepareStatement(query);
				System.out.println("what's dragon's new name?");
				String nameUpdate = Clavier.lireString();
				// Prepare the infos to insert into the query SQL
				declaration.setString(1, nameUpdate);
				declaration.setInt(2, idUpdate);

				int executeUpdate = declaration.executeUpdate();
				flag = (executeUpdate == 1);
			} catch (Exception e) {
				System.err.println("Error of updateDragon(): " + e.getMessage());
			}
			break;

		// Modify gendre
		case 2:
			try {
				// query SQL
				String query = "UPDATE dragons SET sexe = ? WHERE id = ? ";
				PreparedStatement declaration = accessDataBase.prepareStatement(query);
				System.out.println("what's dragon's new gender?");
				String genderUpdate = Clavier.lireString();
				// Prepare the infos to insert into the query SQL
				declaration.setString(1, genderUpdate);
				declaration.setInt(2, idUpdate);

				int executeUpdate = declaration.executeUpdate();
				flag = (executeUpdate == 1);
			} catch (Exception e) {
				System.err.println("Error of updateDragon(): " + e.getMessage());
			}
			break;
		// Modify long
		case 3:
			try {
				// query SQL
				String query = "UPDATE dragons SET longueur = ? WHERE id = ? ";
				PreparedStatement declaration = accessDataBase.prepareStatement(query);
				System.out.println("How many centimeters?");
				int longUpdate = Clavier.lireInt();
				// Prepare the infos to insert into the query SQL
				declaration.setInt(1, longUpdate);
				declaration.setInt(2, idUpdate);

				int executeUpdate = declaration.executeUpdate();
				flag = (executeUpdate == 1);
			} catch (Exception e) {
				System.err.println("Error of updateDragon(): " + e.getMessage());
			}
			break;
		
		// Modify scales
		case 4:
			try {
				// query SQL
				String query = "UPDATE dragons SET nombreEcailles = ? WHERE id = ? ";
				PreparedStatement declaration = accessDataBase.prepareStatement(query);
				System.out.println("How many scales does your dragons have?");
				int scalesUpdate = Clavier.lireInt();
				// Prepare the infos to insert into the query SQL
				declaration.setInt(1, scalesUpdate);
				declaration.setInt(2, idUpdate);

				int executeUpdate = declaration.executeUpdate();
				flag = (executeUpdate == 1);
			} catch (Exception e) {
				System.err.println("Error of updateDragon(): " + e.getMessage());
			}
			break;
			
		// Modify spitFire
		case 5:

			try {
				// query SQL
				String query = "UPDATE dragons SET cracheDuFeu = ? WHERE id = ? ";
				PreparedStatement declaration = accessDataBase.prepareStatement(query);
				System.out.println("Can he/she spit fire? oui-Yes  non-NO");
				String spitFireUpdate = Clavier.lireString();
				// Prepare the infos to insert into the query SQL
				declaration.setString(1, spitFireUpdate);
				declaration.setInt(2, idUpdate);

				int executeUpdate = declaration.executeUpdate();
				flag = (executeUpdate == 1);
			} catch (Exception e) {
				System.err.println("Error of updateDragon(): " + e.getMessage());
			}
			break;
		// Modify behavior
		case 6:

			try {
				// query SQL
				String query = "UPDATE dragons SET comportementAmoureux = ? WHERE id = ? ";
				// preparer statement for un querry
				PreparedStatement declaration = accessDataBase.prepareStatement(query);
				// ajouter ingredient sur la position "?"
				System.out.println("What's the new behavior of your dragon?");
				String behavior = Clavier.lireString();
				// Prepare the infos to insert into the query SQL
				declaration.setString(1, behavior);
				declaration.setInt(2, idUpdate);

				int executeUpdate = declaration.executeUpdate();
				flag = (executeUpdate == 1);
			} catch (Exception e) {
				System.err.println("Error of updateDragon(): " + e.getMessage());
			}
			
			break;
		default:
			System.out.println("select an action, pls");
			break;
		}
		System.out.println("Well done!");
		return flag;
	}

	/**
	 * Ici on test
	 * 
	 * @param args the command line arguments
	 */
//	public static void main(String[] args) {
//  openConnection();
////			create();
////			update();
////			readAll();
////			readName();
////		deleteDragon();
//	closeConnection();
//	}
}
