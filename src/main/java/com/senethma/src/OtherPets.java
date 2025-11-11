package com.senethma.src;

public class OtherPets extends Pet{

    public OtherPets(String petName, int petAge, String petGender, String petBreed, String petMood, String petType){
        super(petName, petAge, petGender, petBreed, petMood, petType);
        setHunger(5);
        setHappiness(5);
    }

    @Override
    public void feed() {
        setHunger(Math.max(0, getHunger() - 2));
        System.out.println(getPetName() + " is fed by you and is happy.");
    }

    @Override
    public void play() {
        setHappiness(Math.min(10, getHappiness() + 2));
        System.out.println(getPetName() + " is fed by you and is happy.");
    }

    @Override
    public String getStatus() {
        return getPetName() + " | Hunger: " + getHunger() + " | Happiness: " + getHappiness();
    }
}
