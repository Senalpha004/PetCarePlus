package com.senethma.src;

public class Pet {
    private String petName;
    private int petAge;
    private String petGender;
    private String petBreed;
    private String petMood;
    private String petType;

    //constructor to assign and store each input
    public Pet(String petName, int petAge, String petGender, String petBreed, String petMood, String petType) {
        this.petName = petName;
        this.petAge = petAge;
        this.petGender = petGender;
        this.petBreed = petBreed;
        this.petMood = petMood;
        this.petType = petType;
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

    @Override
    public String toString() {
        return "\nName: " + getPetName() + "\nAge: " + getPetAge() +
                "\nGender: " + getPetGender() + "\nBreed: " + getPetBreed() +
                "\nMood: " + getPetMood() + "\nType: " + getPetType();
    }
}
