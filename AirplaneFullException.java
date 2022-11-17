/**
 * @file AirplaneFullException.java
 * 
 * @author Malia Cherry
 *
 * @date Nov. 2022
 **/

 /**
 * The AirplaneFullException class is used to throw an exception when the airplane is full.
 */
public class AirplaneFullException extends Exception {
    /**
     * Default constructor for the AirplaneFullException class. 
     *
     * @param none
     */
    public AirplaneFullException() {
        super("\nThe airplane is full!\n");
        //return;
    }
}
