
/**
 * @file Flight.java
 * 
 * @author Malia Cherry
 *
 * @date Nov. 2022
 **/

import java.util.*;

/**
 * The Flight class contains the methods used to create and book flights.
 */
public class Flight extends Ticket {
    Scanner input = new Scanner(System.in);
    Random rand = new Random();
    String flightNum, ticketNum = "";
    String[] seatArray;
    boolean[][] G100;
    boolean[][] G400;

    /**
     * Constructor for the Flight class. Initializes the array of seats.
     *
     * @param none
     */
    public Flight() {
        G100 = new boolean[7][3];
        G400 = new boolean[20][3];
    }

    /**
     * Prompt the user to select an option from the main menu and
     * calls to the function that corresponds to the user's selection.
     *
     * @param none
     */
    public void mainMenu() {
        testFull(G100);
        // testFull(G400);
        String selection = "";
        String number = "";
        String returned = "";
        String repeat = "Y";
        System.out.println("\n\t\tMain Menu \n\"1\" - Purchase a new ticket \n\"2\" - View existing ticket");
        System.out.print("Your selection: ");

        while (!selection.equals("1") && !selection.equals("2")) {
            selection = input.nextLine();
            switch (selection) {
                case "1":
                    while (repeat.equalsIgnoreCase("Y")) {
                        System.out.println("\n***********************************************");
                        flightInfo();
                        System.out.println("***********************************************\n");

                        do {
                            System.out.print("Please enter the flight number you would like to purchase: ");
                            number = buyTicket(input.nextLine());
                            if (number.equals("FULL")) {
                                System.out.println("Please select another flight.");
                                number = "";
                            }
                        } while (number.equals(""));

                        if (number.equals("FULL")) {
                            break;
                        } else {
                            confirmation(number);
                        }
                        System.out.println("***********************************************");
                        System.out.print("Would you like to purchase another ticket? (Y/N): ");
                        repeat = input.nextLine();
                        System.out.println("***********************************************");

                        while (!repeat.equalsIgnoreCase("Y")) {

                            if (repeat.equalsIgnoreCase("N")) {
                                break;
                            } else {
                                System.out.println("Invalid input. Please try again.\n");
                                repeat = "";
                            }
                            System.out.println("***********************************************");
                            System.out.print("Would you like to purchase another ticket? (Y/N): ");
                            repeat = input.nextLine();
                            System.out.println("***********************************************");
                        }
                    }

                    break;
                case "2":
                    if (tickets.size() == 0) {
                        System.out.println("There are no tickets to view.");
                        repeat = "";
                    }

                    while (repeat.equalsIgnoreCase("Y")) {
                        do {
                            System.out.print("\nPlease enter your ticket number: ");
                            number = getTicket(input.nextLine());
                        } while (number.equals(""));

                        if (number.equals("not found")) {
                            repeat = "Y";
                        } else {
                            System.out.println("***********************************************");
                            System.out.print("Would you like to cancel your ticket? (Y/N): ");
                            repeat = input.nextLine();
                            System.out.println("***********************************************");

                            if (repeat.equalsIgnoreCase("Y")) {
                                returned = returnTicket(number.toUpperCase());
                            } else {
                                while (!repeat.equalsIgnoreCase("Y")) {

                                    if (repeat.equalsIgnoreCase("N")) {
                                        break;
                                    } else {
                                        System.out.println("Invalid input. Please try again.\n");
                                        repeat = "";
                                    }
                                    System.out.println("***********************************************");
                                    System.out.print("Would you like to cancel your ticket? (Y/N): ");
                                    repeat = input.nextLine();
                                    System.out.println("***********************************************");
                                }
                                returned = returnTicket(number.toUpperCase());
                            }

                            String flight = number.toUpperCase().substring(0, 4);
                            if (flight.equals("G100")) {
                                returnSeat(returned, G100);
                            } else {
                                returnSeat(returned, G400);
                            }

                            if (tickets.size() == 0) {
                                System.out.println("\nThere are no tickets to view.");
                                break;
                            }

                            System.out.println("***********************************************");
                            System.out.print("Would you like to view another ticket? (Y/N): ");
                            repeat = input.nextLine();
                            System.out.println("***********************************************");

                            if (repeat.equalsIgnoreCase("Y") && tickets.size() == 0) {
                                System.out.println("\nThere are no tickets to view.");
                                break;
                            }

                            while (!repeat.equalsIgnoreCase("Y")) {
                                if (tickets.size() == 0) {
                                    System.out.println("\nThere are no tickets to view.");
                                    break;
                                }
                                if (repeat.equalsIgnoreCase("N")) {
                                    break;
                                } else {
                                    System.out.println("Invalid input. Please try again.\n");
                                    repeat = "";
                                }
                                System.out.println("***********************************************");
                                System.out.print("Would you like to view another ticket? (Y/N): ");
                                repeat = input.nextLine();
                                System.out.println("***********************************************");
                            }

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

    /**
     * Changes all seats on the plane to true(booked) to test the full flight.
     *
     * @param flight the flight to be tested
     */
    public void testFull(boolean[][] flight) {
        for (int i = 0; i < flight.length; i++) {
            for (int j = 0; j < flight[i].length; j++) {
                flight[i][j] = true;
            }
        }
    }

    /**
     * Gathers information from user to purchase a ticket for the given flight.
     * Generates a ticket with entered information.
     *
     * @param flightNum the flight the user wants to buy a ticket for
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
                System.out.print("\nEnter your first and last name (ex: J D or John Doe): ");
                name = input.nextLine();
                while (!name.matches("^[a-zA-Z']+\s[a-zA-Z-']+")) {
                    System.out.println("Invalid input. Please try again.");
                    System.out.print("Enter your first and last name: ");
                    name = input.nextLine();
                }
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
                while (!name.matches("^[a-zA-Z']+\s[a-zA-Z-']+")) {
                    System.out.println("Invalid input. Please try again.");
                    System.out.print("Enter your first and last name: ");
                    name = input.nextLine();
                }
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

    /**
     * Throws an exception if the flight is full
     *
     * @param flight the flight to be checked
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

    /**
     * Changes the seat on the given flight from true(booked) to false(unbooked).
     *
     * @param seat   the seat to be returned
     * @param flight the flight the seat is in
     */
    public void returnSeat(String seat, boolean[][] flight) {
        int row, column = 0;
        String columnLabel = "";
        if (seat.length() == 2) {
            row = Integer.parseInt(seat.substring(0, 1)) - 1;
            columnLabel = seat.substring(1, 2);
        } else {
            row = Integer.parseInt(seat.substring(0, 2)) - 1;
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

    /**
     * Displays the seats on the given flight.
     *
     * @param flightNum the flight to be displayed
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

    /**
     * Changes a seat on the given flight from false(unbooked) to true(booked).
     *
     * @param flightNum the flight to the seat will be booked on
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
