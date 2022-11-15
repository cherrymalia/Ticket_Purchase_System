
import java.util.Scanner;

public class GreenTicketingSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String repeat = "Y";
        Flight flight = new Flight();

        System.out.println("\nWelcome to Green Company's Ticketing System!");
        System.out.println("********************************************");

        do {
            //System.out.println("\n\t\tMain Menu \n\"1\" - Purchase a new ticket \n\"2\" - View existing ticket");
            //System.out.print("Your selection: ");
            flight.mainMenu();
            System.out.println("**********************************************");
            System.out.print("Would you like to return the main menu? (Y/N): ");
            repeat = input.nextLine();
            System.out.println("**********************************************");
            /*
             * 
             */
        } while (repeat.equalsIgnoreCase("Y"));

        input.close();
        System.out.println("\n*************************************************************");
        System.out.println("Thank you for using the Green Company Ticket Purchase System.");
        System.out.println("*************************************************************");

    }
}
