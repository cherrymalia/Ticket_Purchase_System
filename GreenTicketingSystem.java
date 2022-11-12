import java.util.*;
//import java.io.*;

public class GreenTicketingSystem {
    public static void main(String[] args) {

        System.out.println("\nGreen Company Ticket Purchase System");
        System.out.println("====================================");
        Scanner input = new Scanner(System.in);
        Flight flight = new Flight();
        String selection = "";
        System.out.println("\n\tMain Menu \n\"1\" - Purchase a new ticket \n\"2\" - View existing ticket");
        System.out.print("Your selection: ");

        while (!selection.equals("1") && !selection.equals("2")) {
            selection = input.next();
            switch (selection) {
                case "1":
                    System.out.println("===============================================");
                    flight.flightInfo();
                    System.out.println("===============================================\n");
                    System.out.print("Please enter the flight number you would like to purchase: ");
                    flight.buyTicket(input.next());
                    break;
                case "2":
                    // display prompt to enter ticket/seat number
                    // display ticket
                    // flight.getTicket(ticket);
                    System.out.println("WIP");
                    break;
                default:
                    System.out.println("\n\nCommand not recognized. Please try again.");
                    System.out.println("\n\"1\" - Purchase a new ticket \n\"2\" - View existing ticket");
                    System.out.print("Your selection: ");
                    break;
            }
        }

        System.out.println("Thank you for using the Green Company Ticket Purchase System");

    }
}
