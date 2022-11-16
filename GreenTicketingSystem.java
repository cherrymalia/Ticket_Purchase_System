
import java.util.Scanner;

public class GreenTicketingSystem {
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

//fix comments for methods and files