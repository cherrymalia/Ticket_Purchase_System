
/**
 * @file GreenTicketingSystem.java
 * 
 * @author Malia Cherry
 *
 * @date Nov. 2022
 **/

import java.util.Scanner;

/**
 * The GreenTicketingSystem class contains the main method to run the program. 
 */
public class GreenTicketingSystem {
    /**
     * The main method creates a new Flight object and calls the mainMenu method.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String repeat = "";
        Flight flight = new Flight();

        System.out.println("\nWelcome to Green Company's Ticketing System!");
        System.out.println("********************************************");

        do {
            flight.mainMenu();
            System.out.print("\n\t Main Menu? (Y/N): ");
            repeat = input.nextLine();
        } while (repeat.equalsIgnoreCase("Y"));

        input.close();
        System.out.println("\n*************************************************************");
        System.out.println("Thank you for using the Green Company Ticket Purchase System.");
        System.out.println("*************************************************************");

    }
}

// input validatio for main menu
// change date on ticket to current date ???