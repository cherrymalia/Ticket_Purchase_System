
/*
    *  TO-DO: FIX COMMENTS
    */
import java.util.*;

public class Flight extends Ticket {
    Scanner input = new Scanner(System.in);
    Random rand = new Random();
    String flightNum, ticketNum = "";
    String[] seatArray;
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
     * TO-DO: MAKE NAVIGATION BETWEEN MENU OPTIONS QUICKER
     * ADD OPTION TO PURCHASE TICKETS BACK TO BACK
     * CORRECT FLOW AFTER CANCELLING TICKET
     */
    public void mainMenu() {
        testFull(G400);
        String selection = "";
        String number = "";
        String returned = "";
        System.out.println("\n\t\tMain Menu \n\"1\" - Purchase a new ticket \n\"2\" - View existing ticket");
        System.out.print("Your selection: ");

        while (!selection.equals("1") && !selection.equals("2")) {
            selection = input.nextLine();
            switch (selection) {
                case "1":
                    // String repeat = "";
                    System.out.println("\n***********************************************");
                    flightInfo();
                    System.out.println("***********************************************\n");

                    do {
                        System.out.print("Please enter the flight number you would like to purchase: ");
                        number = buyTicket(input.nextLine());
                        if (number.equals("FULL")) {
                            System.out.println("Please select another flight.");
                        }
                    } while (number.equals(""));

                    if (number.equals("FULL")) {
                        break;
                    } else {
                        confirmation(number);
                    }
                    /*
                     * System.out.println("***********************************************");
                     * System.out.print("Would you like to purchase another ticket? (Y/N): ");
                     * repeat = input.nextLine();
                     * System.out.println("***********************************************");
                     */
                    break;
                case "2":

                    do {
                        System.out.print("\nPlease enter your ticket number: ");
                        number = getTicket(input.nextLine());
                    } while (number.equals(""));

                    if (number.equals("not found")) {
                        break;
                    } else {
                        System.out.print("Would you like to cancel your ticket? (Y/N): ");
                        if (input.nextLine().equalsIgnoreCase("Y")) {
                            returned = returnTicket(number.toUpperCase());
                        } else {
                            break;
                        }

                        String flight = number.toUpperCase().substring(0, 4);
                        if (flight.equals("G100")) {
                            returnSeat(returned, G100);
                        } else {
                            returnSeat(returned, G400);
                        }
                    }

                    break;
                default:
                    System.out.println("\n\nCommand not recognized. Please try again.");
                    System.out.println("\n\"1\" - Purchase a new ticket \n\"2\" - View existing ticket");
                    System.out.print("Your selection: ");
                    break;
            }
        }
    }

    public void testFull(boolean[][] flight) {
        for (int i = 0; i < flight.length; i++) {
            for (int j = 0; j < flight[i].length; j++) {
                flight[i][j] = true;
            }
        }
    }

    /*
     * TO-DO: REGEX FOR NAME (?)
     */
    public String buyTicket(String flightNum) {
        Ticket ticket;
        String name, ticketNum, seat = "";

        switch (flightNum) {
            case "100":
                try {
                    AirplaneFull(G100);
                } catch (AirplaneFullException e) {
                    System.out.println(e.getMessage());
                    return "FULL";
                }
                System.out.print("\nEnter your first and last name: ");
                name = input.nextLine();
                displaySeats(G100);
                do {
                    seat = seatSelector(G100);
                } while (seat == "");

                ticketNum = "G100" + String.format("%04d", rand.nextInt(9998));
                ticket = new Ticket(name, flightNum, ticketNum, seat);
                generateTicket(ticket);
                return seat;
            case "400":
                try {
                    AirplaneFull(G400);
                } catch (AirplaneFullException e) {
                    System.out.println(e.getMessage());
                    return "FULL";
                }
                System.out.print("\nEnter your first and last name: ");
                name = input.nextLine();
                displaySeats(G400);
                do {
                    seat = seatSelector(G400);
                } while (seat == "");
                ticketNum = "G400" + String.format("%04d", rand.nextInt(9998));
                ticket = new Ticket(name, flightNum, ticketNum, seat);
                generateTicket(ticket);
                return seat;
            default:
                System.out.println("Flight number not recognized. Please try again.");
                return "";
        }
    }

    /*
     * TO-DO: FIX THIS COMMENT BLOCK
     */
    public boolean AirplaneFull(boolean[][] flight) throws AirplaneFullException {
        int totalSeats = (flight.length * flight[0].length);
        int unavailableSeats = 0;
        for (int i = 0; i < flight.length; i++) {
            for (int j = 0; j < flight[i].length; j++) {
                if (flight[i][j] == true) {
                    unavailableSeats++;
                }
            }
        }
        if (unavailableSeats == totalSeats) {
            throw new AirplaneFullException();
        } else {
            return false;
        }

    }

    /*
     * TO-DO: CHANGE ENTERED SEAT FROM BOOKED TO AVAILABLE
     */
    public void returnSeat(String seat, boolean[][] flight) {
        int row, column = 0;
        String columnLabel = "";
        if (seat.length() == 2) {
            row = Integer.parseInt(seat.substring(0, 1))-1;
            columnLabel = seat.substring(1, 2);
        } else {
            row = Integer.parseInt(seat.substring(0, 2))-1;
            columnLabel = seat.substring(2, 3);
        }

        switch (columnLabel) {
            case "A":
                column = 0;
                break;
            case "B":
                column = 1;
                break;
            case "C":
                column = 2;
                break;
        }

        for (int i = 0; i < flight.length; i++) {
            for (int j = 0; j < flight[i].length; j++) {
                if (i == row && j == column) {
                    flight[i][j] = false;
                }
            }
        }

    }

    /*
     * TO-DO: FIX THIS COMMENT BLOCK
     */
    public void displaySeats(boolean[][] flightNum) {
        System.out.println("\n\n     A   B   C\n   -------------");
        for (int i = 0; i < flightNum.length; i++) {
            System.out.print(" " + (i + 1) + " |");

            for (int j = 0; j < flightNum[i].length; j++) {
                if (flightNum[i][j] == false) {
                    System.out.print("   |");
                } else {
                    System.out.print(" X |");
                }
            }
            System.out.println("\n   -------------");
        }
        System.out.println("\nX = Unavailable\n");
    }

    /*
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

        if (!seat.contains(",")) {
            System.out.println("Invalid seat selection. Please try again.");
            return "";
        } else {
            seatArray = seat.split(",");
            if (!seatArray[0].matches("\\d+")) {
                System.out.println("Invalid seat selection. Please try again.");
                return "";
            }
            int row = Integer.parseInt(seatArray[0]) - 1;
            int col = 0;

            if (row < 0 || row > flightNum.length) {
                System.out.println("Invalid seat selection. Please try again.");
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
                        System.out.println("Invalid seat selection. Please try again.");
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
