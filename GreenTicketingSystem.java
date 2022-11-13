
import java.util.Scanner;

public class GreenTicketingSystem {
    public static void main(String[] args) {
        Scanner repeat = new Scanner(System.in);
        Flight flight = new Flight();

        System.out.println("\nWelcome to Green Company's Ticketing System!");
        System.out.println("===============================================");

        do {
            //validate input
            flight.mainMenu();
            System.out.println("===============================================");
            System.out.println("Would you like to return the main menu? (y/n)");
        } while (repeat.nextLine().equals("y"));

        repeat.close();
        System.out.println("Thank you for using the Green Company Ticket Purchase System");

    }
}
