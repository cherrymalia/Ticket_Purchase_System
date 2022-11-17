/**
 * @file Ticket.java
 * 
 * @author Malia Cherry
 *
 * @date Nov. 2022
 **/
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * The Ticket class contains the methods to create a ticket for a flight.
 */
public class Ticket {
    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy");
    String name, flightNum, ticketNum, seatNum;
    ArrayList<Ticket> tickets = new ArrayList<Ticket>();

    /**
     * Default constructor for the Ticket class.
     *
     * @param none
     */
    public Ticket() {
        name = "";
        flightNum = "";
        ticketNum = "";
        seatNum = "";
    }

    /**
     * Overloaded constructor for the Ticket class used to create a ticket.
     *
     * @param user  The name of the user
     * @param flight    The flight number
     * @param ticket    The ticket number
     * @param seat  The seat number
     */
    public Ticket(String user, String flight, String ticket, String seat) {
        name = user;
        ticketNum = ticket;
        flightNum = flight;
        seatNum = seat;
    }

    /**
     * Displays the information about the flights.
     *
     * @param none
     */
    public void flightInfo() {
        System.out.println("Available Flights:");
        System.out.println("Green #100\t   " + formatter.format(date) + "\nGSO - EWR | 6:00 AM - 7:30 AM\t(1 hr 30 min)\n");
        System.out.println("Green #400\t   " + formatter.format(date) + "\nGSO - SEA | 4:00 PM - 11:30 PM\t(10 hr 30 min)");
    }

    /**
     * Finds the ticket in the array list from the ticket number. 
     * If found, the ticket is removed from the array list.
     *
     * @param num    The ticket number
     */
    public String returnTicket(String num) {
        String seat = "";

        for (int i = 0; i < tickets.size(); i++) {
            if (num.equals(tickets.get(i).ticketNum)) {
                seat = tickets.get(i).seatNum;
                tickets.remove(i);
                System.out.println("Ticket " + num + " has been cancelled.\n");
            }
        }
        return seat;
    }

    /**
     * Displays the ticket to the user after a flight is booked.
     *
     * @param seat The seat number
     */
    public void confirmation(String seat) {
        System.out.println("\n\n=====================================================");
        System.out.println("Thank you for purchasing a ticket with Green Company!");
        System.out.println("=====================================================");
        int index = tickets.size() - 1;
        if (tickets.get(index).seatNum.equals(seat)) {
            System.out.println(tickets.get(index).name + "\nTicket: " + tickets.get(index).ticketNum);
            System.out.println(
                    "Flight: Green #" + tickets.get(index).flightNum + "\tSeat: " + tickets.get(index).seatNum);
            if (tickets.get(index).flightNum.equals("100")) {
                System.out.println("\n" + formatter.format(date) + "\nGSO-EWR | 6:30 AM - 7:30 AM\t(1 hr 30 min)");
            } else if (tickets.get(index).flightNum.equals("400")) {
                System.out.println("\n" + formatter.format(date) + "\nGSO-SEA | 4:00 PM - 11:30 PM\t(10 hr 30 min)");
            }
            System.out.println("==================================================\n");
        }
    }

    /**
     * Adds the ticket to the array list.
     *
     * @param bookingInfo   The array list of the ticket information
     */
    public void generateTicket(Ticket bookingInfo) {
        tickets.add(bookingInfo);
    }

    /**
     * Finds the ticket in the array list from the ticket number and 
     * displays the ticket information to the user.
     *
     * @param num  The ticket number
     */
    public String getTicket(String num) {
        // check if num is seat number or ticket number
        // find ticket in tickets array that ticketNum matches num
        // print ticket info\
        num = num.toUpperCase();
        System.out.println("\n===============================================");
        if (num.matches("^[G][\\d]{7}$")) {
            for (int i = 0; i < tickets.size(); i++) {
                if (tickets.get(i).ticketNum.equals(num)) {
                    System.out.println(tickets.get(i).name + "\nTicket: " + tickets.get(i).ticketNum);
                    System.out.println(
                            "Flight: Green #" + tickets.get(i).flightNum + "\tSeat: " + tickets.get(i).seatNum);
                    if (tickets.get(i).flightNum.equals("100")) {
                        System.out.println("\n" + formatter.format(date) + "\nGSO-EWR | 6:30 AM - 7:30 AM\t(1 hr 30 min)");
                    } else if (tickets.get(i).flightNum.equals("400")) {
                        System.out.println("\n" + formatter.format(date) + "\nGSO-SEA | 4:00 PM - 11:30 PM\t(10 hr 30 min)");
                    }
                    System.out.println("===============================================\n");
                    return num;
                }
            }
            System.out.println("Ticket not found.");
            System.out.println("===============================================");
            return "not found";
        } else {
            System.out.println("Invalid input. Please try again.");
            System.out.println("===============================================\n");
            return "";
        }
    }
}