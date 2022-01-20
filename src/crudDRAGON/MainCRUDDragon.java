package crudDRAGON;

public class MainCRUDDragon {

	public static void main(String[] args) {
		System.out.println("Hello! your database dragons is already ");
		System.out.println("what do you want to do with it? 1-yes  0-no");
		int doSomething = Clavier.lireInt();
	    while (doSomething == 1) {
		System.out.println("1-Add a new dragon");
		System.out.println("2-Read your database");
		System.out.println("3-Update your dragon");
		System.out.println("4-Delete your dragon");
		}
	}

}
