package Assignment2.First;
/* -----------------------------------------------------
* Assignment: 2
* Written by: Jason Kim 40097242
* Due: 11:59 PM – Friday, February 24, 2019
----------------------------------------------------- */

/**
 * PublicTransportation class
 * @author Jason Kim, 40097242
 *
 */
public class PublicTransportation {
	//attribute
	private double ticketprice;
	private int stops;
	//constructor
	/**
	 * Default Constructor
	 */
	public PublicTransportation() {
		this.ticketprice = 20;
		this.stops = 10;
	}
	/**
	 * Parameterized Constructor
	 * @param tp: ticket price
	 * @param s: number of stops
	 */
	public PublicTransportation(double tp, int s){
		this.ticketprice = tp;
		this.stops = s;
	}
	/**
	 * Copy Constructor
	 * @param pb: PublicTransportation class to be copied
	 */
	public PublicTransportation(PublicTransportation pb) {
		this.ticketprice = pb.getTicketPrice();
		this.stops = pb.getstops();
	}
	//accessors
	/**
	 * Accessor to get ticket price
	 * @return price of ticket 
	 */
	public double getTicketPrice() {
		return this.ticketprice;
	}
	/**
	 * Accessor to get number of stops
	 * @return integer number of stops
	 */
	public int getstops() {
		return this.stops;
	}
	//mutators
	/**
	 * Mutator to change ticket price
	 * @param price: new ticket price
	 */
	public void changeticketprice(double price) {
		this.ticketprice = price;
	}
	/**
	 * Mutator to change number of stops
	 * @param s: new number of stops
	 */
	public void changestops(int s) {
		this.stops = s;
	}
	//others
	/**
	 * toString method
	 * @return string representing the class
	 */
	public String toString() {
		return "This Public Transportation has " + this.stops + " stops, and costs " + this.ticketprice + " dollars.";
	}
	/**
	 * equals method
	 * @param other: class to be compared
	 * @return boolean value that determines if the comparison is true or not
	 */
	public boolean equals(Object compared) {
		if(compared == null|| this.getClass() != compared.getClass()) {
			return false;
		}
		else {
			PublicTransportation other = (PublicTransportation) compared;
			if((this.getTicketPrice() == other.getTicketPrice()) && (this.getstops() == other.getstops()))
				return true;
			else
				return false;
		}
	}//In a case where there this class is in an array and each element of the array is being compared to another element, there might be some parts 
	//of the array that might be empty. When an element in an array is empty the computer gives it the value null, therefore, by testing to see if
	//the element is null, it will prevent the program from crashing
}
