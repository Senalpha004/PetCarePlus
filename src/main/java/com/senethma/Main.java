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
        ArrayList<Pet> petList = new ArrayList<>();
        boolean running = true;
        //object created to access pet manager class's methods easily
        PetManager petManager = new PetManager();

        while (running) {
            System.out.println("\n----- MENU options -----");
            System.out.println("1. Add Pet");
            System.out.println("2. Feed/Play with Pets");
            System.out.println("3. View all Pets");
            System.out.println("4. Exit");

            try {
                System.out.println("Your Choice? (Type the Number only)");
                int choice = input.nextInt();
                input.nextLine(); //clears buffer

                switch (choice) {
                    case 1:
                        System.out.println("Pet's Name?");
                        String petName = input.nextLine();
                        System.out.println("Pet's Age? (months)");
                        int petAge = input.nextInt();
                        input.nextLine();
                        System.out.println("Pet's Gender?");
                        String petGender = input.nextLine();
                        System.out.println("Pet's Breed? ");
                        String petBreed = input.nextLine();
                        System.out.println("Pet's Mood?");
                        String petMood = input.nextLine();
                        System.out.println("Pet's Type? (Dog, Cat, Hamster etc..)");
                        String petType = input.nextLine();

                        if (petType.equalsIgnoreCase("dog")) {
                            boolean validInput = false;
                            while (!validInput) {
                                try {
                                    System.out.println("Trained? (true/false)");
                                    boolean isTrained = input.nextBoolean();
                                    input.nextLine(); //clears buffer
                                    validInput = true;

                                    Dog newPet = new Dog(petName, petAge, petGender, petBreed, petMood, petType, isTrained);
                                    petManager.addPet(newPet);
                                } catch (InputMismatchException e) {
                                    System.out.println("Please enter only true or false");
                                    input.nextLine(); //clears wrong input
                                }
                            }

                        } else if (petType.equalsIgnoreCase("cat")) {
                            boolean validInput = false;
                            while (!validInput) {
                                try {
                                    System.out.println("Trained? (true/false)");
                                    boolean isTrained = input.nextBoolean();
                                    validInput = true;

                                    Cat newPet = new Cat(petName, petAge, petGender, petBreed, petMood, petType, isTrained);
                                    petManager.addPet(newPet);
                                } catch (InputMismatchException e) {
                                    System.out.println("Please enter only true or false");
                                    input.nextLine();
                                }
                            }

                        }else {
                            //creating an object of the pet class to assign and store the inputs
                            Pet newPet = new Pet(petName, petAge, petGender, petBreed, petMood, petType);
                            petManager.addPet(newPet);
                        }
                        System.out.println("Your pet's details are stored successfully!");
                        break;

                    case 2:
                        petManager.feedOrPlayPet(input, petList);
                        break;

                    case 3:
                        System.out.println("\nPet Details...\n");
                        petManager.viewPets();
                        break;

                    case 4:
                        System.out.println("Exiting PetCarePlus ...");
                        running = false;
                        break;

                    default:
                        System.out.println("Please enter a correct choice!");
                        break;
                }
            }catch (InputMismatchException e) {
                System.out.println("Try Again");
                input.nextLine();
            }
        }
        input.close();

    }
}
