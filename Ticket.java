/*
     *  TO-DO: FIX THIS COMMENT BLOCK
     */

    import java.util.*;
public class Ticket {

    String name, flightNum, ticketNum, seatNum;
    ArrayList<Ticket> tickets = new ArrayList<Ticket>();

    /*
     *  TO-DO: FIX THIS COMMENT BLOCK
     */
    public Ticket() {
        name = "";
        flightNum = "";
        ticketNum = "";
        seatNum = "";
    }

     /*
     *  TO-DO: FIX THIS COMMENT BLOCK
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
        System.out.println("Green 100\t   December 9, 2022\nGSO - EWR | 6:30 AM - 7:30 AM\t(1 hr 30 min)\n");
        System.out.println("Green 400\t   December 9, 2022\nGSO - SEA | 4:00 PM - 11:30 PM\t(10 hr 30 min)");
    }
    
    public void confirmation(String seat) {
        System.out.println("Thank you for purchasing a ticket with Green Company!");
        getTicket(seat);
    }
    /*
     *  TO-DO: FIX THIS COMMENT BLOCK
     */
    public void generateTicket(Ticket bookingInfo) {
        tickets.add(bookingInfo);
        for (int i = 0; i < tickets.size(); i++) {
            System.out.println("\n" + tickets.get(i).name + "\n" + tickets.get(i).flightNum + "\n"
                    + tickets.get(i).ticketNum + "\n" + tickets.get(i).seatNum);
        }
        //getTicket(bookingInfo.ticketNum);
    }


    /*
     *  TO-DO: FIX THIS COMMENT BLOCK
     */
    public void getTicket(String num) {
        // display ticket
        System.out.println("\n===============================================");
        if (num.equals(ticketNum)) {
            System.out.println("Name: " + name);
            System.out.println("Flight Number: " + flightNum);
            if (flightNum.equals("100")) {
                System.out.println("December 9, 2022\nGSO-EWR | 6:30 AM - 7:30 AM\t1 hr 30 min\n");
            } else if (flightNum.equals("400")) {
                System.out.println("December 9, 2022\nGSO-SEA | 4:00 PM - 11:30 PM\t10 hr 30 min\n");
            }
            System.out.println("Ticket Number: " + ticketNum);
            System.out.println("Seat Number: " + seatNum);
        } else {
            System.out.println("Ticket not found.");
        }
        System.out.println("===============================================\n");
    }
}