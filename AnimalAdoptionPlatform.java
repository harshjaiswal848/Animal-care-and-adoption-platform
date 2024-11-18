import java.util.ArrayList;
import java.util.List;

// Animal class to manage animal details
class Animal {
    private String species;
    private String breed;
    private int age;
    private boolean isAvailable;

    public Animal(String species, String breed, int age) {
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.isAvailable = true;
    }

    public String getSpecies() { return species; }
    public String getBreed() { return breed; }
    public int getAge() { return age; }
    public boolean isAvailable() { return isAvailable; }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    @Override
    public String toString() {
        return species + " (" + breed + "), Age: " + age + ", Available: " + isAvailable;
    }
}

// Adopter class to manage adopter details
class Adopter {
    private String name;
    private String applicationStatus;

    public Adopter(String name) {
        this.name = name;
        this.applicationStatus = "Pending";
    }

    public String getName() { return name; }
    public String getApplicationStatus() { return applicationStatus; }

    public void setApplicationStatus(String status) {
        this.applicationStatus = status;
    }

    @Override
    public String toString() {
        return "Adopter: " + name + ", Status: " + applicationStatus;
    }
}

// AdoptionRecord class to manage adoption records
class AdoptionRecord {
    private Animal animal;
    private Adopter adopter;
    private String adoptionDate;

    public AdoptionRecord(Animal animal, Adopter adopter, String adoptionDate) {
        this.animal = animal;
        this.adopter = adopter;
        this.adoptionDate = adoptionDate;
    }

    @Override
    public String toString() {
        return "Animal: " + animal.getSpecies() + ", Adopter: " + adopter.getName() + ", Date: " + adoptionDate;
    }
}

// Admin class to manage animals, adopters, and adoptions
class Admin {
    private List<Animal> animalList;
    private List<Adopter> adopterList;
    private List<AdoptionRecord> adoptionRecords;

    public Admin() {
        animalList = new ArrayList<>();
        adopterList = new ArrayList<>();
        adoptionRecords = new ArrayList<>();
    }

    // 1. Animal Management
    public void addAnimal(String species, String breed, int age) {
        Animal animal = new Animal(species, breed, age);
        animalList.add(animal);
        System.out.println("Animal added: " + animal);
    }

    public void updateAnimalAvailability(String species, boolean availability) {
        for (Animal animal : animalList) {
            if (animal.getSpecies().equalsIgnoreCase(species)) {
                animal.setAvailable(availability);
                System.out.println("Updated availability for " + species + ": " + availability);
            }
        }
    }

    // 2. Adopter Management
    public void addAdopter(String name) {
        Adopter adopter = new Adopter(name);
        adopterList.add(adopter);
        System.out.println("Adopter added: " + adopter);
    }

    public void updateAdopterStatus(String name, String status) {
        for (Adopter adopter : adopterList) {
            if (adopter.getName().equalsIgnoreCase(name)) {
                adopter.setApplicationStatus(status);
                System.out.println("Updated status for " + name + ": " + status);
            }
        }
    }

    // 3. Adoption Record Management
    public void recordAdoption(String species, String adopterName, String date) {
        Animal adoptedAnimal = null;
        Adopter adopter = null;

        for (Animal animal : animalList) {
            if (animal.getSpecies().equalsIgnoreCase(species) && animal.isAvailable()) {
                adoptedAnimal = animal;
                animal.setAvailable(false);  // Mark as adopted
                break;
            }
        }

        for (Adopter a : adopterList) {
            if (a.getName().equalsIgnoreCase(adopterName)) {
                adopter = a;
                break;
            }
        }

        if (adoptedAnimal != null && adopter != null) {
            AdoptionRecord record = new AdoptionRecord(adoptedAnimal, adopter, date);
            adoptionRecords.add(record);
            System.out.println("Adoption recorded: " + record);
        } else {
            System.out.println("Adoption could not be completed. Please check details.");
        }
    }

    // 4. Notifications
    public void sendNotification(String adopterName, String message) {
        for (Adopter adopter : adopterList) {
            if (adopter.getName().equalsIgnoreCase(adopterName)) {
                System.out.println("Notification sent to " + adopterName + ": " + message);
            }
        }
    }
}

// Main program
public class AnimalAdoptionPlatform {
    public static void main(String[] args) {
        Admin admin = new Admin();

        // Animal Management
        admin.addAnimal("Dog", "Labrador", 2);
        admin.addAnimal("Cat", "Siamese", 3);
        admin.updateAnimalAvailability("Dog", false);

        // Adopter Management
        admin.addAdopter("John Doe");
        admin.updateAdopterStatus("John Doe", "Approved");

        // Adoption Record Management
        admin.recordAdoption("Dog", "John Doe", "2024-10-14");

        // Notifications
        admin.sendNotification("John Doe", "Your adoption has been approved! Please schedule a visit.");
    }
}
