package com.okpets;

import java.util.Scanner;
import java.util.Random;

public class MenuManager {

    private final Scanner scnr;
    private boolean hasPressedQuit = false;
    private char menuOption = 'q';
    private Dog myDog;
    private final MatchesDatabase matches;

    public MenuManager() {
        scnr = new Scanner(System.in);
        Random randGen = new Random();
        matches = new MatchesDatabase(randGen);
        myDog = new Dog();
    }

    public MenuManager(Random randGen) {
        scnr = new Scanner(System.in);
        matches = new MatchesDatabase(randGen);
        myDog = new Dog();
    }

    public MatchesDatabase getDatabase() {
        return matches;
    }

    public void commandAllMatches() {
        System.out.println("Show all dogs in the database.");
        matches.showAllMatches();
        showMenu();
        menuOption = scnr.next().charAt(0);
        scnr.nextLine(); // make sure we consume rest of the line
    }

    public void commandFindMatches() {
        System.out.println("Find potential dog matches.");
        matches.showCompatibleMatches(myDog);
        showMenu();
        menuOption = scnr.next().charAt(0);
        scnr.nextLine(); // make sure we consume rest of the line
    }

    public void commandUpdateDogInfo() {
        System.out.println("Updating my dog information.");
        System.out.println("Enter dog name: ");
        String name = scnr.next();
        myDog.setName(name);
        scnr.nextLine();
        System.out.println("Enter dog breed: ");
        String breed = scnr.nextLine();
        myDog.setBreed(breed);
        System.out.println("Enter dog sex (0 - Male, 1 - Female)");
        int sex = scnr.nextInt();
        myDog.setSex(sex);
        System.out.println("Is your dog interested in (0 - Male, 1 - Female, 2 - both)?");
        int interest = scnr.nextInt();
        myDog.setInterestedIn(interest);

        System.out.println("Updated my dog information:");
        myDog = new Dog(name, breed, sex, interest);
        System.out.println(myDog);
        System.out.println();
        showMenu();
        menuOption = scnr.next().charAt(0);
        scnr.nextLine(); // make sure we consume rest of the line
    }

    public void commandShowMatchedDogs() {
        System.out.println("Show matched dogs.");
        matches.confirmPotentialMatches(myDog);
        matches.showConfirmedMatches(myDog);
        showMenu();
        menuOption = scnr.next().charAt(0);
        scnr.nextLine(); // make sure we consume rest of the line
    }

    public void commandQuit() {
        hasPressedQuit = true;
        System.out.println("Quit. Thank you for using okPets!");
    }

    public void commandInvalid() {
        System.out.println();
        System.out.println("Invalid command! You entered: " + menuOption);
        System.out.println("Please try again.");
        System.out.println();
        showMenu();
        menuOption = scnr.next().charAt(0);
        scnr.nextLine(); // make sure we consume rest of the line
    }

    public void showMenu() {
        System.out.println("MENU");
        System.out.println("a - Show all dogs in the database");
        System.out.println("f - Find potential dog matches");
        System.out.println("u - update my dog information");
        System.out.println("m - Show dogs you have matched with");
        System.out.println("q - quit");
    }

    public void runMenu() {
        System.out.println("==================");
        System.out.println("Welcome to okPets!");
        System.out.println("==================");
        System.out.println();
        showMenu();
        menuOption = scnr.next().charAt(0);
        scnr.nextLine(); // make sure we consume rest of the line
        while (!hasPressedQuit) {
            switch (menuOption) {
                case 'a':
                    commandAllMatches();
                    break;
                case 'f':
                    commandFindMatches();
                    break;
                case 'u':
                    commandUpdateDogInfo();
                    break;
                case 'm':
                    commandShowMatchedDogs();
                    break;
                case 'q':
                    commandQuit();
                    break;
                default:
                    commandInvalid();
            }
        }
    }

    public static void main(String[] args) {
        Random randGen = new Random(10); // for reproducible results
        MenuManager manager = new MenuManager(randGen);
        manager.getDatabase().addMatch(new Dog("Fuzzy", "Pomeranian", 0, 0));
        manager.getDatabase().addMatch(new Dog("Scout", "Golden Retriever", 0, 2));
        manager.getDatabase().addMatch(new Dog("Bella", "German Shepherd", 1, 2));
        manager.getDatabase().addMatch(new Dog("Daisy", "Dachshund", 1, 1));
        manager.runMenu();
    }
}
