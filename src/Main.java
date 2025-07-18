import java.util.Scanner;
import java.util.ArrayList;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ArrayList<String> closet = new ArrayList<>(); //array list to store user inputs

        System.out.println("Welcome to Closet Organizer");
        Scanner input = new Scanner(System.in);

        System.out.println("What's your name?");
        String name = input.nextLine();

        System.out.println("Welcome to your virtual closet, " + name + "!" );
        System.out.println("Choose an Option from Below: ");

        int option;

        do {
            System.out.println("\nChoose an Option:");
            //menue options to choose from
            System.out.println("1. Add a new clothing");
            System.out.println("2. View Closet");
            System.out.println("3. Remove a clothing");
            System.out.println("4. Check clothing count");
            System.out.println("5. Exit");

            //taking the input and looping the menu until user exits
            while (!input.hasNextInt()) {
                System.out.println("Please enter a valid option!");
                input.next(); //skip invalid inputs
            }

            option = input.nextInt();
            input.nextLine(); //clears buffer

            switch (option) {
                case 1:
                    System.out.println("Clothing name? ");
                    String clothingName = input.nextLine();
                    closet.add(clothingName);
                    System.out.println("Clothing added!");
                    break;

                case 2:
                    System.out.println("Your closet has: ");
                    for(String clothing : closet) {
                        System.out.println(clothing);
                    }
                    break;

                case 3:
                    System.out.println("Which clothing you wanna remove? ");
                    String removeClothe = input.nextLine();
                    if (closet.remove(removeClothe)) {
                        System.out.println("Clothing removed!");
                    } else {
                        System.out.println("Clothing not found or check spellings!");
                    }
                    break;

                case 4:
                    System.out.println("Number of Clothes you have in your closet: " + closet.size());
                    break;

                case 5:
                    System.out.println("Bye bye," + name + " Stay Stylish!");
                    break;

                default:
                    System.out.println("Invalid option, Try Again!");
            }

        }while (option != 5);

    }
}
