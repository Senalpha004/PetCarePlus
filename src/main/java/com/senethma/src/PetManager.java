package com.senethma.src;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PetManager {

    private ArrayList<Pet> petList = new ArrayList<>();
    private final File file = new File("Pet Details.txt");

    public void saveToFile(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
            oos.writeObject(petList); // saves the entire list

        }catch (Exception e){
            System.out.println("Error saving file" + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadFromFile(){
        if(!file.exists()){
            petList = new ArrayList<>();
        }
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            petList = (ArrayList<Pet>) ois.readObject();

        }catch (Exception e){
            System.out.println("Error loading file" + e.getMessage());
            petList =  new ArrayList<>();
        }
    }

    public void addPet(Pet newPet) {
        petList.add(newPet);
        saveToFile();
    }

    public void viewPets(){
        if(petList.isEmpty()){
            System.out.println("There are no pets added :(");
        }else {
            loadFromFile();
            for(Pet pet : petList){
                System.out.println(pet.toString() + "\n_______________________");
            }
        }
    }

    public void feedOrPlayPet(Scanner scanner){
        if (petList.isEmpty()) {
            System.out.println("There are no pets to interact with :(");
            return;
        }

        //list pets with indices
        System.out.println("\nWhich pet you like to interact with?");
        for (int i = 0; i < petList.size(); i++) {
            System.out.println((i + 1) + ". " + petList.get(i).getPetName() + " (" + petList.get(i).getPetMood() + ")");
        }

        System.out.println("Your Choice? (Enter number only)");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice < 0 || choice > petList.size()) {
            System.out.println("Invalid choice");
            return;
        }

        Pet selectedPet = petList.get(choice - 1);

        //feeding or playing
        System.out.println("Would you like to" + "\n" + "1) feed" + "\n" + " OR" + "\n" + "2) play" + " with " + selectedPet.getPetName() + "?");
        System.out.println("\n(Enter number only)");
        int option = scanner.nextInt();
        scanner.nextLine();

            switch (option) {
                case 1:
                    selectedPet.feed();
                    break;

                case 2:
                    selectedPet.play();
                    break;

                default:
                    System.out.println("Invalid option");
                    return;
            }
            //save updated mood
            saveToFile();
            //show updated status
            System.out.println("\nUpdated status of the pet: " + selectedPet.getStatus());
    }
}

