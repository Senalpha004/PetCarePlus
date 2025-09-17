package com.senethma.src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class PetManager {

    private ArrayList<Pet> petList = new ArrayList<>();
    private final File file = new File("Pet Details.txt");

    public void saveToFile(){
        try{
            FileWriter writer = new FileWriter(file);
            writer.write(petList.toString() + "\n_______________________");
            writer.close();

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
}
