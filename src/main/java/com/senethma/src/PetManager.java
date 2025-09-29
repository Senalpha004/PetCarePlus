package com.senethma.src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class PetManager {

    private ArrayList<Pet> petList = new ArrayList<>();
    private final File file = new File("Pet Details.txt");

    public void saveToFile(){
        try(FileWriter writer = new FileWriter(file)){
            writer.write("Pet Details...\n");
            for (Pet pet : petList){
                writer.write(pet.toString() + "\n\n");
            }

        }catch (Exception e){
            System.out.println("Error saving file" + e.getMessage());;
        }
    }

    public void loadFromFile(){
        if(!file.exists()){
            petList = new ArrayList<>();
        }
        try{
            FileReader reader = new FileReader("Pet Details.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            bufferedReader.readLine();
            bufferedReader.close();

        }catch (Exception e){
            System.out.println("Error loading file" + e.getMessage());
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

    public void feedOrPlayPet(Scanner scanner, ArrayList<Pet> petList){
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
        System.out.println("Would you like to 1) feed OR 2) play with" + selectedPet.getPetName());
        System.out.println("Your option? (Enter number only)");
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

        //show updated status
        System.out.println("\nUpdated status of the pet: " + selectedPet.getStatus());
    }
}
