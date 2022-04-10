package model;

public class WetlandController {

    public static final int NUM_WETLANDS = 80;
    private Wetland[] wetlands;

    public WetlandController(String relation) {
        wetlands = new Wetland[NUM_WETLANDS];
    }

    /*
     * Metodo que recibe los parametros de un humedal, crea el objeto y lo añade en
     * el arreglo.
     */
    public String addWetland(String name, int numUbication, int numType, double quantityOfKm2, String urlPhoto,
            int numProtectedArea) {
        String out = "";
        boolean flag = false;
        ubicationZone ubication = null;
        Type type = null;
        ProtectedArea protectedArea = null;
        switch (numUbication) {
            case 1:
                ubication = ubicationZone.RURAL;
                break;
            case 2:
                ubication = ubicationZone.URBAN;
                break;
        }
        switch (numType) {
            case 1:
                type = Type.PUBLIC;
                break;
            case 2:
                type = Type.PRIVATE;
                break;
        }
        switch (numProtectedArea) {
            case 1:
                protectedArea = ProtectedArea.YES;
                break;
            case 2:
                protectedArea = ProtectedArea.NO;
                break;
        }
        for (int i = 0; i < NUM_WETLANDS && !flag; i++) {
            if (wetlands[i] != null && wetlands[i].getName().equalsIgnoreCase(name)) {
                out = "Wetland already exist.";
                flag = true;
            }
        }
        if (flag == false) {
            wetlands[numSpace()] = new Wetland(name, ubication, type, quantityOfKm2, urlPhoto, protectedArea);
            out = "Wetland created succesfuly.";
        }
        return out;
    }

    public String addSpecie(String nameWetland, String name, String scientificName, int numMigratorySpecie,
            int numType) {
        String out = "";
        boolean flag = false;
        MigratorySpecie migratorySpecies = null;
        TypeSpecie type = null;
        switch (numMigratorySpecie) {
            case 1:
                migratorySpecies = MigratorySpecie.YES;
                break;
            case 2:
                migratorySpecies = MigratorySpecie.NO;
                break;
        }
        switch (numType) {
            case 1:
                type = TypeSpecie.FLORA_TERRESTRE;
                break;
            case 2:
                type = TypeSpecie.FLORA_ACUATICA;
                break;
            case 3:
                type = TypeSpecie.AVE;
                break;
            case 4:
                type = TypeSpecie.MAMIFERO;
                break;
            case 5:
                type = TypeSpecie.ACUATICO;
                break;
        }
        for (int i = 0; i < NUM_WETLANDS && !flag; i++) {
            if (wetlands[i] != null && wetlands[i].getName().equalsIgnoreCase(nameWetland)) {
                flag = true;
                Species s = new Species(name, scientificName, migratorySpecies, type);
                out = wetlands[i].addSpecie(s, type);
            } else {
                out = "Wetland already not exist.";
            }
        }
        return out;
    }

    public String wetlandLessFlora() {
        int position = 0;
        for (int i = 0; i < NUM_WETLANDS; i++) {
            if (wetlands[i] != null && wetlands[position].getFloraSpecies() > wetlands[i].getFloraSpecies()) {
                position = i;
            }
        }
        return wetlands[position].getName();
    }

    public String wetlandMoreAnimals() {
        int position = 0;
        for (int i = 0; i < NUM_WETLANDS; i++) {
            if (wetlands[i] != null && wetlands[position].getAnimalSpecies() < wetlands[i].getAnimalSpecies()) {
                position = i;
            }
        }
        return wetlands[position].getName();
    }

    public String addEvent(String nameWetland, int numEventType, String organizer, double cost, String description,
            int day, int month,
            int year) {
        String out = "";
        boolean flag = false;
        EventType type = null;
        switch (numEventType) {
            case 1:
                type = EventType.MANTENIMIENTO;
                break;
            case 2:
                type = EventType.VISITA_DE_COLEGIO;
                break;
            case 3:
                type = EventType.ACTIVIDADES_DE_MEJORAMIENTO;
                break;
            case 4:
                type = EventType.CELEBRACIONES;
                break;
        }
        for (int i = 0; i < NUM_WETLANDS && !flag; i++) {
            if (wetlands[i] != null && wetlands[i].getName().equalsIgnoreCase(nameWetland)) {
                flag = true;
                Date eventDate = new Date(day, month, year);
                Event e = new Event(type, organizer, cost, description, eventDate);
                out = wetlands[i].addEvent(e);
            } else {
                out = "Wetland already not exist.";
            }
        }
        return out;
    }

    /**
     * Method that looks at the first available space in the array
     */
    public int numSpace() {
        boolean n = false;
        int s = -1;
        for (int i = 0; i < NUM_WETLANDS && !n; i++) {
            if (wetlands[i] == null) {
                n = true;
                s = i;
            }
        }
        return s;
    }

    /**
     * Method that calls the list of registered comics
     */
    public void listWetlands() {
        for (int i = 0; i < NUM_WETLANDS; i++) {
            if (wetlands[i] != null) {
                System.out.println(wetlands[i].toString());
                wetlands[i].listSpecies();
            }
        }
    }

    public void listMaintenance(int year) {
        for (int i = 0; i < NUM_WETLANDS; i++) {
            if (wetlands[i] != null) {
                System.out.println(wetlands[i].getName() + ": " + wetlands[i].numMaintenance(year)
                        + " maintenance in the year " + year);
            }
        }
    }

    public void listSpecie(String name) {
        for (int i = 0; i < NUM_WETLANDS; i++) {
            if (wetlands[i] != null && wetlands[i].speciesInWetland(name) != null) {
                System.out.println("This specie is found in Wetland: " + wetlands[i].speciesInWetland(name));
            } else {
                System.out.println("Specie not found.");
            }
        }
    }
}
