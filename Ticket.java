public class Ticket {

    String name, flightNum, ticketNum, seatNum;

    public Ticket() {
        String name, flightNum, ticketNum, seatNum = "";
    }

    public Ticket(String name, String flightNum, String ticketNum, String seatNum) {
        this.name = name;
        this.ticketNum = ticketNum;
        this.flightNum = flightNum;
        this.seatNum = seatNum;
    }

    public void getTicket(String num) {
        // display ticket
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
    }
}