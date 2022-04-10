package model;

public class Wetland {
	public static final int MAX_SPECIES = 10000000;
	public static final int MAX_EVENTS = 10000000;
	/** Atributo que guarda el nombre del humedal. */
	private String name;
	/** Atributo que guarda la zona de ubicaación del humedal. */
	private ubicationZone ubication;
	/** Atributo que guarda el tipo del humedal */
	private Type type;
	/** Atributo que guarda la cantidad de kilometros del humedal. */
	private double quantityOfKm2;
	private String urlPhoto;
	private ProtectedArea protectedArea;
	private int floraSpecies;
	private int animalSpecies;
	private int num;
	// relationships
	private ManagementPlan managementPlanOfWetland;
	private Species[] species;
	private Event[] events;

	public Wetland(String name, ubicationZone ubication, Type type, double quantityOfKm2, String urlPhoto,
			ProtectedArea protectedArea) {
		this.name = name;
		this.ubication = ubication;
		this.type = type;
		this.quantityOfKm2 = quantityOfKm2;
		this.urlPhoto = urlPhoto;
		this.protectedArea = protectedArea;
		floraSpecies = 0;
		animalSpecies = 0;
		num = 0;
		species = new Species[MAX_SPECIES];
		events = new Event[MAX_EVENTS];
	}

	public void calculateNumberSpecies(TypeSpecie type) {
		if (type == TypeSpecie.FLORA_ACUATICA || type == TypeSpecie.FLORA_TERRESTRE) {
			floraSpecies = floraSpecies + 1;
		}
		if (type == TypeSpecie.AVE || type == TypeSpecie.MAMIFERO || type == TypeSpecie.ACUATICO) {
			animalSpecies = animalSpecies + 1;
		}
	}

	public String addSpecie(Species s, TypeSpecie type) {
		String out = "";
		int empty = findEmpty();
		if (empty != -1) {
			species[empty] = s;
			out = "Specie registered succesfuly";
		} else {
			out = "The array is full.";
		}
		calculateNumberSpecies(type);
		return out;
	}

	public String addEvent(Event e) {
		String out = "";
		int empty = findEmpty();
		if (empty != -1) {
			events[empty] = e;
			out = "Event registered succesfuly";
		} else {
			out = "The array is full.";
		}
		return out;
	}

	public int findEmpty() {
		boolean p = false;
		int s = -1;
		for (int i = 0; i < MAX_SPECIES && !p; i++) {
			if (species[i] == null) {
				p = true;
				s = i;
			}
		}
		return s;
	}

	public int numMaintenance(int year) {
		for (int i = 0; i < MAX_EVENTS; i++) {
			if (events[i] != null && events[i].getType() == EventType.MANTENIMIENTO
					&& events[i].numMaintenance() == year) {
				num++;
			}
		}
		return num;
	}

	public void listSpecies() {
		for (int i = 0; i < MAX_SPECIES; i++) {
			if (species[i] != null) {
				System.out.println(species[i].toString());
			}
		}
	}

	public String speciesInWetland(String name) {
		String out = "";
		boolean p = false;
		for (int i = 0; i < MAX_SPECIES && !p; i++) {
			if (species[i] != null && species[i].getName().equalsIgnoreCase(name)) {
				out = getName();
				p = true;
			}
		}
		return out;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ubicationZone getUbication() {
		return this.ubication;
	}

	public void setUbication(ubicationZone ubication) {
		this.ubication = ubication;
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public double getQuantityOfKm2() {
		return this.quantityOfKm2;
	}

	public void setQuantityOfKm2(double quantityOfKm2) {
		this.quantityOfKm2 = quantityOfKm2;
	}

	public String getUrlPhoto() {
		return this.urlPhoto;
	}

	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}

	public ProtectedArea getProtectedArea() {
		return this.protectedArea;
	}

	public void setProtectedArea(ProtectedArea protectedArea) {
		this.protectedArea = protectedArea;
	}

	public int getFloraSpecies() {
		return this.floraSpecies;
	}

	public void setFloraSpecies(int floraSpecies) {
		this.floraSpecies = floraSpecies;
	}

	public int getAnimalSpecies() {
		return this.animalSpecies;
	}

	public void setAnimalSpecies(int animalSpecies) {
		this.animalSpecies = animalSpecies;
	}

	public String toString() {
		return "\n**** Wetland ****\n" +
				"name:" + getName() + "\n" +
				"ubication:" + getUbication() + "\n" +
				"type=" + getType() + "\n" +
				"quantityOfKm2:" + getQuantityOfKm2() + "\n" +
				"urlPhoto:" + getUrlPhoto() + "\n" +
				"protectedArea:" + getProtectedArea() + "\n";
	}

}