package com.senethma;

import com.senethma.src.Cat;
import com.senethma.src.Dog;
import com.senethma.src.Pet;
import com.senethma.src.PetManager;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("\nWelcome to Pet Care Plus!");

        Scanner input = new Scanner(System.in);
        boolean running = true;
        //object created to access pet manager class's methods easily
        PetManager petManager = new PetManager();

        while (running) {
            System.out.println("----- MENU options -----");
            System.out.println("1. Add Pet");
            System.out.println("2. Feed/Play with Pets");
            System.out.println("3. View all Pets");
            System.out.println("4. Exit");

            try {
                System.out.println("Your Choice? (Type the Number only)");
                int choice = input.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Pet's Name?");
                        String petName = input.next();
                        System.out.println("Pet's Age?");
                        int petAge = input.nextInt();
                        System.out.println("Pet's Gender?");
                        String petGender = input.next();
                        System.out.println("Pet's Breed? ");
                        String petBreed = input.next();
                        System.out.println("Pet's Mood?");
                        String petMood = input.next();
                        System.out.println("Pet's Type? (Dog, Cat, Hamster etc..)");
                        String petType = input.next();

                        if (petType.equalsIgnoreCase("dog")) {
                            System.out.println("Trained? (True/False)");
                            boolean isTrained = input.nextBoolean();
                            Dog newPet = new Dog(petName, petAge, petGender, petBreed, petMood, petType, isTrained);
                            petManager.addPet(newPet);

                        } else if (petType.equalsIgnoreCase("cat")) {
                            System.out.println("Trained? (True/False)");
                            boolean isTrained = input.nextBoolean();
                            Cat newPet = new Cat(petName, petAge, petGender, petBreed, petMood, petType, isTrained);
                            petManager.addPet(newPet);

                        }else {
                            //creating an object of the pet class to assign and store the inputs
                            Pet newPet = new Pet(petName, petAge, petGender, petBreed, petMood, petType);
                            petManager.addPet(newPet);
                        }
                        System.out.println("Your pet's details are stored successfully!");
                        break;

                    case 2:
                        break;

                    case 3:
                        petManager.viewPets();
                        break;

                    case 4:
                        System.out.println("Exiting PetCarePlus ...");
                        running = false;
                        break;

                    default:
                        System.out.println("Please enter a correct choice!");
                }
            }catch (InputMismatchException e) {
                System.out.println("Try Again");
                return;
            }
        }

    }
}