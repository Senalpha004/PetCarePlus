package com.senethma.src;

import java.io.Serializable;

public abstract class Pet implements Serializable {

    private static final long serialVersionUID = 1L;

    private String petName;
    private int petAge;
    private String petGender;
    private String petBreed;
    private String petMood;
    private String petType;

    protected int hunger;
    protected int happiness;

    //constructor to assign and store each input
    public Pet(String petName, int petAge, String petGender, String petBreed, String petMood, String petType) {
        this.petName = petName;
        this.petAge = petAge;
        this.petGender = petGender;
        this.petBreed = petBreed;
        this.petMood = petMood;
        this.petType = petType;

        this.hunger = 50;
        this.happiness = 50;
    }

    //getters and setters to store and access user inputs
    public String getPetName() {
        return petName;
    }
    public void setPetName(String petName) {
        this.petName = petName;
    }
    public int getPetAge() {
        return petAge;
    }
    public void setPetAge(int petAge) {
        this.petAge = petAge;
    }
    public String getPetGender() {
        return petGender;
    }
    public void setPetGender(String petGender) {
        this.petGender = petGender;
    }
    public String getPetBreed() {
        return petBreed;
    }
    public void setPetBreed(String petBreed) {
        this.petBreed = petBreed;
    }
    public String getPetMood() {
        return petMood;
    }
    public void setPetMood(String petMood) {
        this.petMood = petMood;
    }

    public String getPetType() {
        return petType;
    }
    public void setPetType(String petType) {
        this.petType = petType;
    }

    public int getHunger() {
        return hunger;
    }
    public void setHunger(int hunger) {
        this.hunger = hunger;
    }
    public int getHappiness() {
        return happiness;
    }
    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public abstract void feed();
    public abstract void play();
    public abstract String getStatus();

    @Override
    public String toString() {
        return "\nName: " + getPetName() + "\nAge: " + getPetAge() +
                "\nGender: " + getPetGender() + "\nBreed: " + getPetBreed() +
                "\nMood: " + getPetMood() + "\nType: " + getPetType();
    }
}
