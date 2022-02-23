package com.okpets;

import java.util.ArrayList;
import java.util.Random;

public class MatchesDatabase {

    private ArrayList<DogMatch> allMatches;
    private Random randGen;

    public MatchesDatabase() {
        allMatches = new ArrayList<DogMatch>();
        randGen = new Random();
    }

    public MatchesDatabase(Random randGen) {
        allMatches = new ArrayList<DogMatch>();
        this.randGen = randGen;
    }

    public void addMatch(Dog dog) {
        DogMatch aMatch = new DogMatch(dog);
        allMatches.add(aMatch);
    }

    public void showAllMatches() {
        for (int i = 0; i< allMatches.size(); i++) {
            System.out.println(allMatches.get(i).getDog());
        }
            if (allMatches.isEmpty()) {
                System.out.println("There are no matches in the database!");
        }
        System.out.println();
    }

    public void showCompatibleMatches(Dog myDog) {
        // show all compatible matches.
        int i;
        boolean found = false;
        DogMatch aMatch;
        for (i = 0; i < allMatches.size(); i++) {
            aMatch = allMatches.get(i);
            if (aMatch.isCompatible(myDog)) {
                System.out.println("Compatible: " + aMatch.getDog());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No potential matches found!");
        }
        System.out.println();
    }

    public void showConfirmedMatches(Dog myDog) {
        int i;
        boolean found = false;
        DogMatch aMatch;
        for (i = 0; i < allMatches.size(); i++) {
            aMatch = allMatches.get(i);
            if (aMatch.isCompatible(myDog) && aMatch.isMatchConfirmed()) {
                System.out.println("Confirmed: " + aMatch.getDog());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No confirmed matches found!");
        }
        System.out.println();
    }

    public void confirmPotentialMatches(Dog myDog) {
        // if a match is compatible, flip a coin to decide if confirmed (equivalent to 50-50 chance)
        int i;
        DogMatch aMatch;
        boolean found = false;
        for (i = 0; i < allMatches.size(); i++) {
            aMatch = allMatches.get(i);
            if (aMatch.isCompatible(myDog)) {
                if (randGen.nextBoolean()) {
                    aMatch.confirmMatch();
                    found = true;
                }
            }
        }
        if (found) {
            System.out.println("You have some confirmed matches!");
        }
        else {
            System.out.println("You have no confirmed match.");
        }
        System.out.println();
    }
}
