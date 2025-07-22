import java.util.Scanner;
import java.util.ArrayList;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ArrayList<ClothingItem> closet = new ArrayList<>(); //array list to store user inputs

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
            System.out.println("6. Exit");

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
                    for(ClothingItem item : closet) {
                        if (item.getName().equalsIgnoreCase(removeClothe)) {
                            closet.remove(item);
                            System.out.println("Clothing removed from your closet!");
                            found = true;
                            break;
                        } else {
                            System.out.println("Clothing not found or check spellings!");
                        }
                        break;
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
                        if (clothing.isFav != fav) {
                            System.out.println("These are your favourites: ");
                            System.out.println(clothing.getName());
                            fav = true;
                            break;
                        }
                    }
                    if(!fav){
                        System.out.println("You don't have any favourites yet :( ");
                    }
                    break;

                case 6:
                    System.out.println("Bye bye," + user + " Stay Stylish!");
                    break;

                default:
                    System.out.println("Invalid option, Try Again!");
            }

        }while (option != 6);

    }
}
