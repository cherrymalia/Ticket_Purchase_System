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
    public Ticket(String name, String flightNum, String ticketNum, String seatNum) {
        this.name = name;
        this.ticketNum = ticketNum;
        this.flightNum = flightNum;
        this.seatNum = seatNum;
    }

    /*
     * TO-DO: FIX THIS COMMENT BLOCK
     */
    public void flightInfo() {
        System.out.println("Available Flights:");
        System.out.println("Green 100\t!!!DATE!!!\nGSO - EWR | 6:30 AM - 7:30 AM\t(1 hr 30 min)\n");
        System.out.println("Green 400\t!!!DATE!!!\nGSO - SEA | 4:00 PM - 11:30 PM\t(10 hr 30 min)");
    }

    /*
     *  TO-DO: FIX THIS COMMENT BLOCK
     */
    public void generateTicket(Ticket bookingInfo) {
        tickets.add(bookingInfo);
        for (int i = 0; i < tickets.size(); i++) {
            System.out.println("\n" + bookingInfo.name + "\t" + bookingInfo.flightNum + "\t" + bookingInfo.ticketNum + "\t"
                    + bookingInfo.seatNum + "\n\n");
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
                System.out.println("!!!DATE!!!\nGSO-EWR | 6:30 AM - 7:30 AM\t1 hr 30 min\n");
            } else if (flightNum.equals("400")) {
                System.out.println("!!!DATE!!!\nGSO-SEA | 4:00 PM - 11:30 PM\t10 hr 30 min\n");
            }
            System.out.println("Ticket Number: " + ticketNum);
            System.out.println("Seat Number: " + seatNum);
        } else {
            System.out.println("Ticket not found.");
        }
        System.out.println("===============================================\n");
    }
}