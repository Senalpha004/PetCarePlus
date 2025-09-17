package com.senethma.src;

public class Dog extends Pet{
    private boolean isTrained;

    public Dog(String petName, int petAge, String petGender, String petBreed, String petMood, String petType, boolean isTrained) {
        super(petName, petAge, petGender, petBreed, petMood, petType);
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
}
