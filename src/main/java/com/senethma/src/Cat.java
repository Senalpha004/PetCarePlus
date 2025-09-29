package com.senethma.src;

public class Cat extends Pet {
    private boolean isTrained;

    public Cat(String petName, int petAge, String petGender, String petBreed, String petMood, String petType, boolean isTrained) {
        super(petName, petAge, petGender, petBreed, petMood,  petType);
        this.isTrained = isTrained;
    }

    public boolean isTrained() {
        return isTrained;
    }
    public void setIsTrained(boolean isTrained) {
        this.isTrained = isTrained;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTrained: " + (isTrained() ? "Yes" : "No");
    }

    @Override
    public void feed() {
        hunger -= 20;
        System.out.println(getPetName() + " is fed by you and is happy.");
    }

    @Override
    public void play() {
        happiness += 20;
        System.out.println(getPetName() + " is fed by you and is happy.");
    }

    @Override
    public String getStatus() {
        return getPetName() + " | Hunger: " + hunger + " | Happiness: " + happiness;
    }
}
