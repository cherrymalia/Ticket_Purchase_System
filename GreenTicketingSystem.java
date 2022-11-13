
import java.util.Scanner;

public class GreenTicketingSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String repeat = "";
        Flight flight = new Flight();

        System.out.println("\nWelcome to Green Company's Ticketing System!");
        System.out.println("********************************************");

        do {
            //validate input
            flight.mainMenu();
            System.out.println("*********************************************");
            System.out.print("Would you like to return the main menu? (Y/N): ");
            repeat = input.nextLine();
            System.out.println("*********************************************");
        } while (repeat.equalsIgnoreCase("Y"));

        input.close();
        System.out.println("\n*************************************************************");
        System.out.println("Thank you for using the Green Company Ticket Purchase System.");
        System.out.println("*************************************************************");

    }
}
