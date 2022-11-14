/*
     *  TO-DO: FIX THIS COMMENT BLOCK
     */

import java.util.*;

public class Ticket {

    String name, flightNum, ticketNum, seatNum;
    ArrayList<Ticket> tickets = new ArrayList<Ticket>();

    /*
     * TO-DO: FIX THIS COMMENT BLOCK
     */
    public Ticket() {
        name = "";
        flightNum = "";
        ticketNum = "";
        seatNum = "";
    }

    /*
     * TO-DO: FIX THIS COMMENT BLOCK
     */
    public Ticket(String user, String flight, String ticket, String seat) {
        name = user;
        ticketNum = ticket;
        flightNum = flight;
        seatNum = seat;
    }

    /*
     * TO-DO: FIX THIS COMMENT BLOCK
     */
    public void flightInfo() {
        System.out.println("Available Flights:");
        System.out.println("Green #100\t   December 9, 2022\nGSO - EWR | 6:00 AM - 7:30 AM\t(1 hr 30 min)\n");
        System.out.println("Green #400\t   December 9, 2022\nGSO - SEA | 4:00 PM - 11:30 PM\t(10 hr 30 min)");
    }

    /*
     * 
     */
    public void confirmation(String seat) {
        System.out.println("\n\n===================================================");
        System.out.println("Thank you for purchasing a ticket with Green Company!");
        System.out.println("===================================================");
        int index = tickets.size() - 1;
        if (tickets.get(index).seatNum.equals(seat)) {
            System.out.println(tickets.get(index).name + "\nTicket: " + tickets.get(index).ticketNum);
            System.out.println(
                    "Flight: Green #" + tickets.get(index).flightNum + "\tSeat: " + tickets.get(index).seatNum);
            if (tickets.get(index).flightNum.equals("100")) {
                System.out.println("\nDecember 9, 2022\nGSO-EWR | 6:30 AM - 7:30 AM\t(1 hr 30 min)");
            } else if (tickets.get(index).flightNum.equals("400")) {
                System.out.println("\nDecember 9, 2022\nGSO-SEA | 4:00 PM - 11:30 PM\t(10 hr 30 min)");
            }
            System.out.println("==================================================\n");
        }
    }

    /*
     * TO-DO: FIX THIS COMMENT BLOCK
     */
    public void generateTicket(Ticket bookingInfo) {
        tickets.add(bookingInfo);
    }

    /*
     * TO-DO: FIX THIS COMMENT BLOCK
     */
    public String getTicket(String num) {
        // check if num is seat number or ticket number
        // find ticket in tickets array that ticketNum matches num
        // print ticket info\

        System.out.println("\n===============================================");
        if (num.matches("^[G][\\d]{7}$")) {
            for (int i = 0; i < tickets.size(); i++) {
                if (tickets.get(i).ticketNum.equals(num)) {
                    System.out.println(tickets.get(i).name + "\nTicket: " + tickets.get(i).ticketNum);
                    System.out.println(
                            "Flight: Green #" + tickets.get(i).flightNum + "\tSeat: " + tickets.get(i).seatNum);
                    if (tickets.get(i).flightNum.equals("100")) {
                        System.out.println("\nDecember 9, 2022\nGSO-EWR | 6:30 AM - 7:30 AM\t(1 hr 30 min)");
                    } else if (tickets.get(i).flightNum.equals("400")) {
                        System.out.println("\nDecember 9, 2022\nGSO-SEA | 4:00 PM - 11:30 PM\t(10 hr 30 min)");
                    }
                    System.out.println("===============================================\n");
                    return "printed";
                }
            }
            System.out.println("Ticket not found.");
            System.out.println("===============================================\n");
            return "printed";
        } else {
            System.out.println("Invalid input. Please try again.");
            System.out.println("===============================================\n");
            return "";
        }
    }
}