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
        Scanner input = new Scanner(System.in);

        System.out.println("What's your name?");
        String user = input.nextLine();

        System.out.println("Welcome to your virtual closet, " + user + "!" );
        System.out.println("Choose an Option from Below: ");

        int option;

        do {
            System.out.println("\nChoose an Option:");
            //menue options to choose from
            System.out.println("1. Add a new clothing");
            System.out.println("2. View Closet");
            System.out.println("3. Remove a clothing");
            System.out.println("4. Check clothing count");
            System.out.println("5. Check Your Favourites!");
            System.out.println("6. Check what you added last time!");
            System.out.println("7. Exit");

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

                    System.out.println("Is this your favourite? True/False");
                    boolean isFav = input.nextBoolean();
                    input.nextLine(); //clears buffer

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
                    }
                    break;

                case 6:
                    for(ClothingItem clothing : closet) {
                        System.out.println(clothing.getName());
                    }
                    break;

                case 7:
                    saveClosetToFile(closet,"closet.txt");
                    System.out.println("Bye bye," + user + " Stay Stylish!");
                    break;

                default:
                    System.out.println("Invalid option, Try Again!");
            }

        }while (option != 7);

    }

    public static void saveClosetToFile(ArrayList<ClothingItem> closet, String fileName) {

        try {
            FileWriter writer = new FileWriter(fileName, false);
            writer.write("Clothing Name, Clothing Type, Favourite or Not" + "\n");
            for (ClothingItem clothing : closet) {
                writer.write(clothing.getName() +", "+ clothing.getType() +", "+ clothing.isFav() + "\n");
            }
            writer.close();
            System.out.println("Closet has been saved to file!");
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
