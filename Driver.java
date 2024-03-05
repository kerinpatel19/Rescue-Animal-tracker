import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char choice;

        do {
            displayMenu();
            choice = scanner.next().charAt(0);
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case '1':
                    intakeNewDog(scanner);
                    break;
                case '2':
                    intakeNewMonkey(scanner);
                    break;
                case '3':
                    reserveAnimal(scanner);
                    break;
                case '4':
                    printAnimals(dogList);
                    break;
                case '5':
                    printAnimals(monkeyList);
                    break;
                case '6':
                    printAvailableAnimals();
                    break;
                case 'q':
                case 'Q':
                    System.out.println("Exiting application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        } while (choice != 'q' && choice != 'Q');

        scanner.close();
    }

    // Method to display the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection:");
    }

    // Method to intake a new dog
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        for (Dog dog : dogList) {
            if (dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; // returns to the menu
            }
        }

        System.out.println("Enter the dog's breed:");
        String breed = scanner.nextLine();
        System.out.println("Enter the dog's gender (male/female):");
        String gender = scanner.nextLine();
        System.out.println("Enter the dog's age:");
        String age = scanner.nextLine();
        System.out.println("Enter the dog's weight:");
        String weight = scanner.nextLine();
        System.out.println("Enter the dog's acquisition date (dd-mm-yyyy):");
        String acquisitionDate = scanner.nextLine();
        System.out.println("Enter the dog's acquisition country:");
        String acquisitionCountry = scanner.nextLine();
        System.out.println("Enter the dog's training status:");
        String trainingStatus = scanner.nextLine();
        System.out.println("Is the dog reserved? (true/false):");
        boolean reserved = scanner.nextBoolean();
        scanner.nextLine(); // Consume the newline character
        System.out.println("Enter the dog's in-service country:");
        String inServiceCountry = scanner.nextLine();

        Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate,
                acquisitionCountry, trainingStatus, reserved, inServiceCountry);

        dogList.add(newDog);

        System.out.println("New dog added successfully!");
    }

    // Method to intake a new monkey
    public static void intakeNewMonkey(Scanner scanner) {
        System.out.println("What is the monkey's name?");
        String name = scanner.nextLine();
        for (Monkey monkey : monkeyList) {
            if (monkey.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis monkey is already in our system\n\n");
                return; // returns to the menu
            }
        }

        System.out.println("Enter the monkey's tail length:");
        double tailLength = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character
        System.out.println("Enter the monkey's height:");
        double height = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character
        System.out.println("Enter the monkey's body length:");
        double bodyLength = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character
        System.out.println("Enter the monkey's species:");
        String species = scanner.nextLine();
        System.out.println("Enter the monkey's gender (male/female):");
        String gender = scanner.nextLine();
        System.out.println("Enter the monkey's age:");
        String age = scanner.nextLine();
        System.out.println("Enter the monkey's weight:");
        String weight = scanner.nextLine();
        System.out.println("Enter the monkey's acquisition date (dd-mm-yyyy):");
        String acquisitionDate = scanner.nextLine();
        System.out.println("Enter the monkey's acquisition country:");
        String acquisitionCountry = scanner.nextLine();
        System.out.println("Enter the monkey's training status:");
        String trainingStatus = scanner.nextLine();
        System.out.println("Is the monkey reserved? (true/false):");
        boolean reserved = scanner.nextBoolean();
        scanner.nextLine(); // Consume the newline character
        System.out.println("Enter the monkey's in-service country:");
        String inServiceCountry = scanner.nextLine();

        Monkey newMonkey = new Monkey(name, tailLength, height, bodyLength, species,
                gender, age, weight, acquisitionDate, acquisitionCountry,
                trainingStatus, reserved, inServiceCountry);

        monkeyList.add(newMonkey);

        System.out.println("New monkey added successfully!");
    }

    // Method to reserve an animal
    public static void reserveAnimal(Scanner scanner) {
        System.out.println("Enter the animal type (dog/monkey):");
        String animalType = scanner.nextLine();
        System.out.println("Enter the in-service country of the animal:");
        String inServiceCountry = scanner.nextLine();

        boolean animalFound = false;

        if (animalType.equalsIgnoreCase("dog")) {
            for (Dog dog : dogList) {
                if (dog.getTrainingStatus().equalsIgnoreCase("in service") &&
                        dog.getInServiceLocation().equalsIgnoreCase(inServiceCountry) &&
                        !dog.getReserved()) {
                    dog.setReserved(true);
                    System.out.println("Animal reserved successfully!");
                    animalFound = true;
                    break;
                }
            }
        } else if (animalType.equalsIgnoreCase("monkey")) {
            for (Monkey monkey : monkeyList) {
                if (monkey.getTrainingStatus().equalsIgnoreCase("in service") &&
                        monkey.getInServiceLocation().equalsIgnoreCase(inServiceCountry) &&
                        !monkey.getReserved()) {
                    monkey.setReserved(true);
                    System.out.println("Animal reserved successfully!");
                    animalFound = true;
                    break;
                }
            }
        } else {
            System.out.println("Invalid animal type. Please enter 'dog' or 'monkey'.");
        }

        if (!animalFound) {
            System.out.println("No available animal found matching the criteria.");
        }
    }

    // Method to print information about animals
    public static void printAnimals(ArrayList<? extends RescueAnimal> animalList) {
        if (animalList.isEmpty()) {
            System.out.println("No animals found in the list.");
            return;
        }

        System.out.println("Printing animal details:");

        for (RescueAnimal animal : animalList) {
            System.out.println("\nAnimal Type: " + animal.getClass().getSimpleName());
            System.out.println("Name: " + animal.getName());
            System.out.println("Gender: " + animal.getGender());
            System.out.println("Age: " + animal.getAge());
            System.out.println("Weight: " + animal.getWeight());
            System.out.println("Acquisition Date: " + animal.getAcquisitionDate());
            System.out.println("Acquisition Country: " + animal.getAcquisitionLocation());
            System.out.println("Training Status: " + animal.getTrainingStatus());
            System.out.println("Is Reserved: " + animal.getReserved());
            System.out.println("In-Service Country: " + animal.getInServiceLocation());
        }
    }

    // Method to print a list of all animals that are not reserved
    public static void printAvailableAnimals() {
        System.out.println("Available Animals (Not Reserved):");
        System.out.println("---------------------------------");

        boolean availableAnimalFound = false;

        for (Dog dog : dogList) {
            if (dog.getTrainingStatus().equalsIgnoreCase("in service") && !dog.getReserved()) {
                System.out.println("Dog Name: " + dog.getName());
                System.out.println("Dog Breed: " +  dog.getBreed());
                System.out.println("Dog In-Service Country: " + dog.getInServiceLocation());
                System.out.println("-----------------------------");
                availableAnimalFound = true;
            }
        }

        for (Monkey monkey : monkeyList) {
            if (monkey.getTrainingStatus().equalsIgnoreCase("in service") && !monkey.getReserved()) {
                System.out.println("Monkey Name: " + monkey.getName());
                System.out.println("Monkey Species: " + monkey.getSpecies());
                System.out.println("Monkey In-Service Country: " + monkey.getInServiceLocation());
                System.out.println("-----------------------------");
                availableAnimalFound = true;
            }
        }

        if (!availableAnimalFound) {
            System.out.println("No available animals found.");
        }
    }
}
