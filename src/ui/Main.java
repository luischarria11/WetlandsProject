package ui;

import java.util.Scanner;
import model.WetlandController;

public class Main {
	/**
	 * sc es el objeto que permite leer informaciOn digitada por el usuario
	 */
	private Scanner sc;
	/*
	 * wetland es la relación con la clase controladora WetlandController en el
	 * paquete model.
	 */
	private WetlandController wetlandc;

	public Main() {
		sc = new Scanner(System.in);
		wetlandc = new WetlandController("example");
	}

	public static void main(String[] args) {
		// Se crea un objeto de tipo Main que es la clase principal.
		Main objMain = new Main();

		// Llamando el método que inicializa la tienda pidiendo datos al usuario

		// variable para leer la entrada
		int option = 0;

		// ciclo para ejecutar el menu mientras que el usuario no elija la opcion (0)
		// para salir
		do {
			option = objMain.showMenu();
			objMain.answer(option);
		} while (option != 0);
	}

	/**
	 * Metodo que muestra el menu de la aplicacion
	 * 
	 * @return option, int es la opcion elegida por el usuario
	 */
	public int showMenu() {
		int option;
		System.out.println("\n\nMenu del programa, digite una opciOn\n" +
				"(1) Create a Wetland\n" +
				"(2) Register new Specie in a Wetland\n" +
				"(3) Register an event in a Wetland\n" +
				"(4) Inform for each wetland, the amount of maintenance in a year given by the user.\n" +
				"(5) Name of the wetland with less species of flora\n" +
				"(6) Wetlands in which a species is found\n" +
				"(7) Wetlands information\n" +
				"(8) Name of the wetland with the more number of animals\n" +
				"(0) To end the program.");
		option = sc.nextInt();
		sc.nextLine();
		return option;
	}

	/**
	 * Metodo que se encarga de llamar a los metodos que resuelven cada uno de los
	 * requerimientos de la aplicacion.
	 */
	public void answer(int userOption) {
		switch (userOption) {
			case 0:
				System.out.println("Bye.");
				break;
			case 1:
				createWetland();
				break;
			case 2:
				registerSpecie();
				break;
			case 3:
				registerEvent();
				break;
			case 4:
				consultMaintenance();
				break;
			case 5:
				consultWetlandLessFlora();
				break;
			case 6:
				consultSpecie();
				break;
			case 7:
				System.out.println("The information of Wetlands is:");
				wetlandc.listWetlands();
				break;
			case 8:
				consultWetlandMoreAnimals();
				break;
		}

	}

	/**
	 * Metodo para crear un humedal pidiendo sus datos y llamando al metodo de la
	 * clase controladora para crearlo.
	 */
	public void createWetland() {
		System.out.println("Please, enter the name of the Wetland");
		String name = sc.next();
		System.out.println("Please, enter if the Wetland is rural or no (1. Yes - 2. No)");
		int ubicationZone = sc.nextInt();
		System.out.println("Please, enter if the Wetland is public or no (1. Yes - 2. No)");
		int type = sc.nextInt();
		System.out.println("Please, enter the quantity of Km2 of the Wetland");
		double quantityOfKm2 = sc.nextDouble();
		System.out.println("Please, enter the url of the photo of the Wetland");
		String urlPhoto = sc.next();
		System.out.println("Please, enter if the Wetland is in a protected area or no (1. Yes - 2. No)");
		int protectedArea = sc.nextInt();
		System.out.println(wetlandc.addWetland(name, ubicationZone, type, quantityOfKm2, urlPhoto, protectedArea));
	}

	public void registerSpecie() {
		System.out.println("Please, enter the name of the Wetland when you want register the Specie");
		String nameWetland = sc.next();
		System.out.println("Please, enter the name of the Specie");
		String name = sc.next();
		System.out.println("Please, enter the scientific name of the Specie");
		String scientificName = sc.next();
		System.out.println("Please, enter if the Specie is migratory (1. Yes - 2. No)");
		int numMigratorySpecie = sc.nextInt();
		System.out.println(
				"Please, enter the type of Specie(1. Flora terrestre - 2. flora acuática - 3. ave - 4. mamífero - 5. acuático)");
		int numType = sc.nextInt();
		System.out.println(wetlandc.addSpecie(nameWetland, name, scientificName, numMigratorySpecie, numType));
	}

	public void registerEvent() {
		System.out.println("Please, enter the name of the Wetland when you want register the event");
		String nameWetland = sc.next();
		System.out.println(
				"Please, enter the type of the event that you want register(1. Mantenimiento - 2. VISITA_DE_COLEGIO - 3. ACTIVIDADES_DE_MEJORAMIENTO - 4. CELEBRACIONES)");
		int numEventType = sc.nextInt();
		System.out.println("Please, enter the organizer of the event that you want register");
		String organizer = sc.next();
		System.out.println("Please, enter the cost of the event that you want register");
		double cost = sc.nextDouble();
		System.out.println("Please, enter a description of the event that you want register");
		String description = sc.next();
		System.out.println("Please, enter a Date of the event that you want register");
		int day = sc.nextInt();
		int month = sc.nextInt();
		int year = sc.nextInt();
		System.out
				.println(wetlandc.addEvent(nameWetland, numEventType, organizer, cost, description, day, month, year));
	}

	public void consultMaintenance() {
		System.out.println("Please, enter a year in the you want consult the maintenance");
		int year = sc.nextInt();
		wetlandc.listMaintenance(year);
	}

	public void consultSpecie() {
		System.out.println("Please, enter a name of Specie for search for it");
		String name = sc.next();
		wetlandc.listSpecie(name);
	}

	public void consultWetlandLessFlora() {
		System.out.println("The Wetland with less flora is: " + wetlandc.wetlandLessFlora());
	}

	public void consultWetlandMoreAnimals() {
		System.out.println("The Wetland with more number of animals is: " + wetlandc.wetlandMoreAnimals());
	}
}