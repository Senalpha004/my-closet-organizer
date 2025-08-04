package closetGUI;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ArrayList<ClothingItem> closet = new ArrayList<>(); //array list to store user inputs
        loadCloset(closet); //load saved items to main list

        System.out.println("Welcome to Closet Organizer");
        System.out.println("A file including the information about your closet will be automatically saved when you exit.");

        Scanner input = new Scanner(System.in);

        System.out.println("What's your name?");
        String user = input.nextLine();

        System.out.println("Welcome to your virtual closet, " + user + "!" );
        System.out.println("Choose an Option from Below: ");

        int option;

        do {
            System.out.println("\nChoose an Option:");
            //menu options to choose from
            System.out.println("1. Add a new clothing");
            System.out.println("2. View Closet");
            System.out.println("3. Remove a clothing");
            System.out.println("4. Check clothing count");
            System.out.println("5. Search for clothing");
            System.out.println("6. Update Your clothing");
            System.out.println("7. Check Your Favourites!");
            System.out.println("8. Change/Update your Favourites!");
            System.out.println("9. Check what you added last time!");
            System.out.println("10. Move the closet to trash");
            System.out.println("11. Sort Closet (A-Z) ;>");
            System.out.println("12. Exit");

            //taking the input and looping the menu until user exits
            while (!input.hasNextInt()) {
                System.out.println("Please enter a valid option!");
                input.next(); //skip invalid inputs
            }

            option = input.nextInt();
            input.nextLine(); //clears buffer

            switch (option) {
                case 1:
                    System.out.println("Clothing type? (Pants/Jeans/etc)");
                    String type = input.nextLine();

                    System.out.println("Clothing name? ");
                    String name = input.nextLine();

                    boolean isFav = false;
                    while (true) {
                        System.out.println("Is this your favourite? (true/false)");
                        String favInput = input.nextLine().trim().toLowerCase();
                        if (favInput.equals("true") || favInput.equals("false")) {
                            isFav = Boolean.parseBoolean(favInput);
                            break;
                        } else {
                            System.out.println("Invalid input! Please enter 'true' or 'false'.");
                        }
                    }

                    //adding the inputs to the class
                    ClothingItem items = new ClothingItem(name, type, isFav);
                    closet.add(items);

                    System.out.println("Clothing added!");
                    break;

                case 2:
                    if(closet.isEmpty()) {
                        System.out.println("Closet is empty!");
                    }else{
                        System.out.println("Your closet has: ");
                        for (ClothingItem clothing : closet) {
                            System.out.println(clothing.name);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Which clothing you wanna remove? ");
                    String removeClothe = input.nextLine();

                    boolean found= false;
                    for(int i = 0; i < closet.size(); i++) {
                        if (closet.get(i).getName().equalsIgnoreCase(removeClothe)) {
                            closet.remove(i);
                            System.out.println("Clothing removed from your closet!");
                            found = true;
                        }
                        if(!found) {
                            System.out.println("Clothing not found or check spellings!");
                            break;
                        }
                    }
                    break;

                case 4:
                    if(closet.isEmpty()) {
                        System.out.println("You don't have any clothes left :(");
                    }else {
                        System.out.println("Number of Clothes you have in your closet: " + closet.size());
                    }
                    break;

                case 5:
                    System.out.println("Type your clothe's name you wanna search: ");
                    String search = input.nextLine();

                    boolean foundSearch = false;

                    for(ClothingItem clothing : closet) {
                        if (clothing.getName().equalsIgnoreCase(search) || clothing.getType().equalsIgnoreCase(search)) {
                            System.out.println("Search results:");
                            System.out.println(clothing.getName() + " ( " + clothing.getType() + " ) ");
                            foundSearch = true;
                        }
                    }
                    if(!foundSearch) {
                        System.out.println("No matches found for " + search);
                        break;
                    }
                    break;


                case 6:
                    System.out.println("Which clothing you wanna update? ");
                    String updateName = input.nextLine();

                    boolean foundUpdate = false;

                    for (ClothingItem clothing : closet) {
                        if (clothing.getName().equalsIgnoreCase(updateName)) {
                            System.out.println("New Name? (Press Enter to skip)");
                            String newName = input.nextLine();
                            if(!newName.isEmpty()) clothing.setName(newName);

                            System.out.println("New Type? (Press Enter to skip)");
                            String newType = input.nextLine();
                            if(!newType.isEmpty()) clothing.setType(newType);

                            boolean isFavourite = false;
                            while (true) {
                                System.out.println("Is this your favourite? (true/false)");
                                String favInput = input.nextLine().trim().toLowerCase();
                                if (favInput.equals("true") || favInput.equals("false")) {
                                    isFavourite = Boolean.parseBoolean(favInput);
                                    break;
                                } else {
                                    System.out.println("Invalid input! Please enter 'true' or 'false'.");
                                }
                            }


                            System.out.println("Updated Your Clothing!");
                            foundUpdate = true;
                        }
                    }
                    if(!foundUpdate) {
                        System.out.println("Clothing doesn't exist to update :(");
                        break;
                    }

                    break;

                case 7:

                    boolean fav = false; //to find whether there are any favourites or not

                    for (ClothingItem clothing : closet) {
                        if (clothing.isFav()) {
                            if (!fav) {
                                System.out.println("These are your favourites:");
                                fav = true;
                            }
                            System.out.println(clothing.getName());
                        }
                    }
                    if(!fav){
                        System.out.println("You don't have any favourites yet :( ");
                        break;
                    }
                    break;

                case 8:
                    System.out.println("Which favourite clothing you wanna update/change? ");
                    String favName = input.nextLine();

                    boolean favChanged = false;
                    for(ClothingItem clothing : closet) {
                        if (clothing.getName().equalsIgnoreCase(favName)) {
                            boolean oldfav = clothing.isFav();
                            clothing.setFav(!oldfav); //changes/toggles the true false status
                            System.out.println("Updated " + favName + " status to: " + !oldfav);
                            favChanged = true;
                        }
                    }
                    if(!favChanged) {
                        System.out.println("Clothing not found or check spellings!");
                        break;
                    }
                    break;

                case 9:
                    if(closet.isEmpty()) {
                        System.out.println("No clothes have been added recently :<");
                    }else {
                        for (ClothingItem clothing : closet) {
                            System.out.println(clothing.getName());
                        }
                    }
                    break;

                case 10:
                    System.out.println("Are you sure you wanna permanently remove the entire clothing? ");
                    String confirmation = input.nextLine();

                    if(confirmation.equalsIgnoreCase("yes") || confirmation.equalsIgnoreCase("yea") || confirmation.equalsIgnoreCase("true")) {
                        closet.clear();
                        System.out.println("Closet is cleared!");

                        //also deletes the file
                        File file = new File("Closet.txt");
                        if(file.exists()) {
                            if(file.delete()) {
                                System.out.println("Closet file is deleted!");
                            }else {
                                System.out.println("Failed to delete the closet file!");
                            }
                        }

                    }else if (confirmation.equalsIgnoreCase("no") || confirmation.equalsIgnoreCase("nah") || confirmation.equalsIgnoreCase("false")) {
                        System.out.println("Clothing are safe :>");
                    } else {
                        System.out.println("Please enter a valid wording!");
                    }
                    break;

                case 11:
                    if(closet.isEmpty()) {
                        System.out.println("Closet is empty, nothing to Sort :(");
                        break;
                    }
                    closet.sort((a, b) -> a.getName().compareToIgnoreCase(b.getName()));
                    System.out.println("Clothing sorted alphabetically!");

                    for(ClothingItem clothing : closet) {
                        System.out.println(clothing.getName());
                    }
                    break;

                case 12:
                    saveClosetToFile(closet,"closet.txt");
                    System.out.println("Bye bye," + user + " Stay Stylish!");
                    break;

                default:
                    System.out.println("Invalid option, Try Again!");
            }

        }while (option != 12);

    }

    public static void saveClosetToFile(ArrayList<ClothingItem> closet, String fileName) {

        try {
            FileWriter writer = new FileWriter(fileName, false);
            writer.write("Clothing Name, Clothing Type, Favourite or Not" + "\n");
            for (ClothingItem clothing : closet) {
                writer.write(clothing.getName() +", "+ clothing.getType() +", "+ clothing.isFav() + "\n");
            }
            writer.close();
            System.out.println("Closet is saved to text file!");
        } catch (IOException e) {
            System.out.println("Error saving to file!" + e.getMessage());;
        }


    }

    public static void loadCloset(List<ClothingItem> closet){
        File file = new File("closet.txt");
        if(!file.exists())return;
        try (Scanner scanner = new Scanner(file)){
            //skips header line
            if (scanner.hasNextLine()) scanner.nextLine();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                if(parts.length == 3){
                    String name = parts[0].trim();
                    String type = parts[1].trim();
                    boolean isFav = Boolean.parseBoolean(parts[2].trim());

                    closet.add(new ClothingItem(name, type, isFav));
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("Previous closet not found!");
        }
    }
}
