package model;

public class Species {
	private String name;
	private String scientificName;
	private MigratorySpecie migratorySpecies;
	private TypeSpecie type;

	public Species(String name, String scientificName, MigratorySpecie migratorySpecies, TypeSpecie type) {
		this.name = name;
		this.scientificName = scientificName;
		this.migratorySpecies = migratorySpecies;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public String getScientificName() {
		return scientificName;
	}

	public MigratorySpecie getMigratorySpecies() {
		return migratorySpecies;
	}

	public TypeSpecie getType() {
		return type;
	}

	public void setName(String newName) {
		name = newName;
	}

	public void setScientificName(String newScientificName) {
		scientificName = newScientificName;
	}

	public void setMigratorySpecies(MigratorySpecie newMigratorySpecies) {
		migratorySpecies = newMigratorySpecies;
	}

	public void setType(TypeSpecie newType) {
		type = newType;
	}

	public String toString() {
		return "** Specie of Wetland **\n" +
				"name:" + getName() + "\n" +
				"ScientificName:" + getScientificName() + "\n" +
				"migratorySpecies:" + getMigratorySpecies() + "\n" +
				"type:" + getType() + ".";
	}

}