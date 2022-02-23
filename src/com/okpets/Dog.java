package com.okpets;

public class Dog {

    // class fields
    // name
    public static final String NO_NAME = "Unknown name";

    // breed
    public static final String NO_BREED = "Unknown breed";

    // sex
    public static final int SEX_NONE = -1;
    public static final int SEX_MALE = 0;
    public static final int SEX_FEMALE = 1;
    public static final int SEX_BOTH = 2;

    // instance fields
    private String name;
    private String breed;
    private int sex; // possible values: SEX_NONE, SEX_MALE, SEX_FEMALE
    private int interestedIn; // possible values: SEX_NONE, SEX_MALE, SEX_FEMALE, SEX_BOTH

    // create an uninitialized Dog instance
    public Dog() {
        sex = SEX_NONE;
        interestedIn = SEX_NONE;
    }

    // create a Dog instance with given name, breed, sex, and interestedIn values
    public Dog(String name, String breed, int sex, int interestedIn) {
        this.name = name;
        this.breed = breed;
        this.sex = sex;
        this.interestedIn = interestedIn;
    }

    public int getInterestedIn() {
        return interestedIn;
    }

    public void setInterestedIn(int interestedIn) {
        // update interestedIn only if value is MALE, FEMALE, or BOTH
        if ((sex == SEX_MALE) || (sex == SEX_FEMALE) || (sex == SEX_BOTH)) {
            this.interestedIn = interestedIn;
        }
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        // update sex only if sex is MALE or FEMALE
        if ((sex == SEX_MALE) || (sex == SEX_FEMALE)) {
            this.sex = sex;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        // update name only if different from NO_NAME
        if (!name.equals(NO_NAME)) {
            this.name = name;
        }
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        // update breed only if different from NO_BREED
        if (!breed.equals(NO_BREED)){
            this.breed = breed;
        }
    }

    public boolean isInterestedIn(Dog dog) {
        // If this instance is uninitialized (interestedIn is equal to SEX_NONE), return false.
        // If passed dog instance is uninitialized (sex is equal to SEX_NONE), also return false.
        // return true if interestedIn matches sex of passed dog instance or if interestedIn is SEX_BOTH.
        if (this.interestedIn == dog.getSex()) {
            return false;
        }
        else if (dog.getSex() == SEX_NONE) {
            return false;
        }
        return (this.interestedIn == dog.getSex() || this.interestedIn == SEX_BOTH);
    }

    public String toString() {
        String userSex = "";
        String userInt = "";
        if (sex == SEX_MALE) {
            userSex = "male";
        }
        else if (sex == SEX_FEMALE) {
            userSex = "female";
        }

        if (interestedIn == SEX_MALE) {
            userInt = "interested in males";
        }
        else if (interestedIn == SEX_FEMALE) {
            userInt = "interested in females";
        }
        else if (interestedIn == SEX_BOTH) {
            userInt = "interested in both males and females";
        }
        return this.name + ", " + this.breed + ", " + userSex + ", " + userInt;
    }

}
