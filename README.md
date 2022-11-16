# Green Company Ticket Purchase System
A simple version of a ticket purchasing system for an airport.

## Author
* [Malia Cherry](https://github.com/cherrymalia)

## Full Description

Design and implement a Green Airplane Ticket Purchase System for Green Company. This company operates two airplanes on a daily basis. The airplane Green 100 has 21 seats. It departs from Greensboro at 6:00 AM and arrives in Newark at 7:30 AM. The airplane Green 400 has 60 seats. It departs from Greensboro  at 4:00 PM and arrives in Seattle at 11:30 PM. A person must purchase a ticket before taking the airplane. The ticket should include a person's name, flight number, travel date and time. 

### The Requirements

1. Constructor:  
```
A constructor sets the number of seats.
```
2. airplaneFull method:
```
A method airplaneFull to check if there are any seats available. 
```
3. buyTicket method:
```
A person purchases a ticket via buyTicket method. This method returns an integer indicating the row number and a character indicating the seat that could be A, B, or C. If a customer tries to buy a ticket but all tickets are sold out an AirplaneFullException exception will be thrown.
```
4. AirplaneFullException:
```
AirplaneFullException must have an exception handler that should display "The airplane is full!"
```
5. Confirmation:
```
If a customer bought a ticket the person's name, flight number, travel date, time and seat number should be displayed. 
```
6. Returning seat:
```
If a customer returns a ticket, the seat will become available.  
```