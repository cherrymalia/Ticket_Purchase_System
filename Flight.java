
/*
    *  TO-DO: FIX COMMENTS
    */
import java.util.*;

public class Flight extends Ticket {
    Scanner input = new Scanner(System.in);
    Random rand = new Random();
    String flightNum, ticketNum = "";
    int seatNum = 0;
    boolean[][] G100;
    boolean[][] G400;

    /*
     * TO-DO: FIX THIS COMMENT BLOCK
     */
    public Flight() {
        G100 = new boolean[7][3];
        G400 = new boolean[20][3];
    }

    /*
     * TO-DO: COMPLETE CASE 2 FOR THIS METHOD
     * TO-DO: FIGURE OUT HOW TO GET THE PROGRAM TO LOOP BACK TO THE MAIN MENU
     */
    public void mainMenu() {
        String selection = "";
        System.out.println("\n\tMain Menu \n\"1\" - Purchase a new ticket \n\"2\" - View existing ticket");
        System.out.print("Your selection: ");

        while (!selection.equals("1") && !selection.equals("2")) {
            selection = input.nextLine();
            switch (selection) {
                case "1":
                    System.out.println("===============================================");
                    flightInfo();
                    System.out.println("===============================================\n");
                    System.out.print("Please enter the flight number you would like to purchase: ");
                    buyTicket(input.nextLine());
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
    }

    

    /*
     * TO-DO: CHECK IF PLANE IS FULL USING AIRPLANEFULL() METHOD
     * TO-DO: CHECK IF TICKETNUM IS ALREADY IN USE
     * TO-DO: CREATE TICKET OBJECT AND CALL FOR BUYTICKET()
     * TO-DO: REGEX FOR NAME
     * TO-DO: FIX THIS COMMENT BLOCK
     */
    public String buyTicket(String flightNum) {
        Ticket ticket;
        String name, ticketNum, seat = "";
        // String name, ticketNum, seat = "";
        switch (flightNum) {
            case "100":
                System.out.print("\nEnter your first and last name: ");
                name = input.nextLine();
                System.out.println("Name: " + name + "\n");
                displaySeats(G100);
                do {
                    seat = seatSelector(G100);
                } while (seat == "");
                System.out.println("Seat: " + seat);
                ticketNum = "G100" + String.format("%04d", rand.nextInt(9998));
                System.out.println(ticketNum);
                ticket = new Ticket(name, flightNum, ticketNum, seat);
                generateTicket(ticket);
                break;
            case "400":
                System.out.print("\nEnter your first and last name: ");
                name = input.nextLine();
                System.out.println("Name: " + name + "\n");
                displaySeats(G400);
                do {
                    seat = seatSelector(G400);
                } while (seat == "");
                System.out.println("Seat: " + seat);
                ticketNum = "G400" + String.format("%04d", rand.nextInt(9998));
                System.out.println(ticketNum);
                ticket = new Ticket(name, flightNum, ticketNum, seat);
                generateTicket(ticket);
                break;
            default:
                System.out.println("Flight number not recognized. Please try again.");
                break;
        }
        
        return seat;
    }

    /*
     * public boolean AirplaneFull() {
     * 
     * return false;
     * }
     * 
     * public void AirplaneFullException() throws Exception {
     * 
     * }
     */

    /*
     * TO-DO: FIX THIS COMMENT BLOCK
     */
    public void displaySeats(boolean[][] flightNum) {
        System.out.println("     A   B   C\n   -------------");
        for (int i = 0; i < flightNum.length; i++) {
            System.out.print(" " + (i + 1) + " |");

            for (int j = 0; j < flightNum[i].length; j++) {
                if (flightNum[i][j] == false) {
                    System.out.print(" O |");
                } else {
                    System.out.print(" X |");
                }
            }
            System.out.println("\n   -------------");
        }
        System.out.println("\nO = Available\tX = Unavailable\n");
    }

    /*
     * TO-DO: FIND A WAY TO VALIDATE THE SEAT INPUT
     * I.E. IF THE USER ENTERS A LETTER INSTEAD OF A NUMBER (regex?)
     * TO-DO: FIX THIS COMMENT BLOCK
     */
    public String seatSelector(boolean[][] flightNum) {
        // display seats for flight and prompt for seat selection
        // check input for valid seat (prompt for seat row[1-#], then seat
        // column[A,B,C])
        // if seat is taken, prompt for another seat
        // if seat is available, assign seat number and return seat number
        System.out.print("Please enter the seat you would like to purchase (row, column): ");
        String seat = input.nextLine();
        seat = seat.toUpperCase();
        seat = seat.replaceAll(" ", "");
        System.out.println(seat);

        if (!seat.contains(",")) {
            System.out.println("Invalid seat selection. Please try again.");
            return "";
        } else {
            String[] seatArray = seat.split(",");
            int row = Integer.parseInt(seatArray[0]) - 1;
            int col = 0;

            if (row < 0 || row > flightNum.length) {
                System.out.println("Invalid row selection. Please try again.");
                return "";
            } else {
                switch (seatArray[1].toUpperCase()) {
                    case "A":
                        col = 0;
                        break;
                    case "B":
                        col = 1;
                        break;
                    case "C":
                        col = 2;
                        break;
                    default:
                        System.out.println("Invalid column selection. Please try again.");
                        return "";
                }

                if (flightNum[row][col] == false) {
                    flightNum[row][col] = true;
                    return seatArray[0] + seatArray[1];
                } else {
                    System.out.println("Seat is unavailable. Please try again.");
                    return "";
                }
            }
        }
    }
}
