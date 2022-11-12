import java.util.*;

public class Flight extends Ticket {
    Scanner input = new Scanner(System.in);
    Random rand = new Random();
    String name, flightNum, ticketNum, seatNum = "";
    ArrayList<Ticket> tickets = new ArrayList<Ticket>();

    public Flight() {
        boolean[][] G100 = new boolean[7][3];
        boolean[][] G400 = new boolean[20][3];
    }

    public void flightInfo() {
        System.out.println("Available Flights:");
        System.out.println("Green 100\t!!!DATE!!!\nGSO - EWR | 6:30 AM - 7:30 AM\t(1 hr 30 min)\n");
        System.out.println("Green 400\t!!!DATE!!!\nGSO - SEA | 4:00 PM - 11:30 PM\t(10 hr 30 min)");
        // System.out.println("Please enter the flight number you would like to
        // purchase: ");
    }

    public String buyTicket(String flightNum) {
        String name, ticketNum, seatNum = "";
        switch (flightNum) {
            case "100":
                System.out.print("\nEnter your first and last name: ");
                name = input.nextLine();
                // seatNum = seatSelector("G100");
                ticketNum = "G100" + String.format("%04d", rand.nextInt(9998));
                System.out.println(ticketNum);
                //tickets.add(new Ticket(name, flightNum, ticketNum, seatNum));
                break;
            case "400":
                System.out.print("\nEnter your first and last name: ");
                name = input.nextLine();
                // seatNum = seatSelector("G400");
                ticketNum = "G400" + String.format("%04d", rand.nextInt(9998));
                System.out.println(ticketNum);
                //tickets.add(new Ticket(name, flightNum, ticketNum, seatNum));
                break;
            default:
                System.out.println("Flight number not recognized. Please try again.");
                break;
        }

        return "";
    }

    public String seatSelector(boolean[][] flightNum) {
        // display seats for flight and prompt for seat selection
        // check input for valid seat (prompt for seat row[1-#], then seat
        // column[A,B,C])
        // if seat is taken, prompt for another seat
        // if seat is available, assign seat number and return seat number
        for (int i = 0; i < flightNum.length; i++) {
            for (int j = 0; j < flightNum[i].length; j++) {
                //System.out.print
            }
        }
        return "";
    }
}
