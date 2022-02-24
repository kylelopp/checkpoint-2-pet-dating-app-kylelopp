package com.okpets;

public class DogMatch {

    private Dog dog;
    private boolean matchConfirmed = false;

    public DogMatch() {
        this.dog = new Dog();
    }

    public DogMatch(Dog dog) {
        this.dog = dog;
    }

    public boolean isCompatible(Dog myDog) {
        return myDog.isInterestedIn(this.dog) && this.dog.isInterestedIn(myDog);
    }

    public boolean isMatchConfirmed() {
        return matchConfirmed;
    }

    public void confirmMatch() {
        matchConfirmed = true;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Dog getDog() {
        return this.dog;
    }
}
