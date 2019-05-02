package Assignment2.Third;
import Assignment2.First.*;
/* -----------------------------------------------------
* Assignment: 2
* Written by: Jason Kim 40097242
* Due: 11:59 PM – Friday, February 24, 2019
----------------------------------------------------- */
/**
 * Ferry Class
 * @author Jason's Laptop
 *
 */
public class Ferry extends PublicTransportation {
	private int buildyear;
	private String shipname;
	/**
	 * Default Constructor
	 */
	public Ferry() {
		super();
		this.buildyear = 2019;
		this.shipname = "Clash";
	}
	/**
	 * Parameterized Constructor
	 * @param tp: ticket price
	 * @param s: number of stops
	 * @param by: year it was built
	 * @param sn: name of ship
	 */
	public Ferry(double tp, int s, int by, String sn) {
		super(tp, s);
		this.buildyear = by;
		this.shipname = sn;
	}
	/**
	 * Copy Constructor
	 * @param other: Ferry class to be copied
	 */
	public Ferry(Ferry other) {
		super(other.getTicketPrice(), other.getstops());
		this.buildyear = other.getbuildyear();
		this.shipname = other.getshipname();
	}
	/**
	 * Accessor method to get year it was built
	 * @return year the ship was built
	 */
	public int getbuildyear() {
		return this.buildyear;
	}
	/**
	 * Accessor method to get the ship name
	 * @return ship name
	 */
	public String getshipname() {
		return this.shipname;
	}
	/**
	 * Mutator method to change year ship was built
	 * @param by: new year that the ship was made
	 */
	public void changebuildyear(int by) {
		this.buildyear = by;
	}
	/**
	 * Mutator method to change ship name
	 * @param sn: new ship name
	 */
	public void changeshipname(String sn) {
		this.shipname = sn;
	}
	/**
	 * toString method
	 * @return string representing the class
	 */
	public String toString() {
		return "This Ferry has " + this.getstops() + ", and costs " + this.getTicketPrice() + ". It was built in " + this.buildyear + " and its name is " + this.getbuildyear() + ".";
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
			Ferry other = (Ferry) compared;
			if((this.getTicketPrice() == other.getTicketPrice()) && (this.getstops() == other.getstops()) && (this.buildyear == other.getbuildyear()) && (this.shipname.toUpperCase() == other.getshipname().toUpperCase()))
				return true;
			else
				return false;
		}
	}//In a case where there this class is in an array and each element of the array is being compared to another element, there might be some parts 
	//of the array that might be empty. When an element in an array is empty the computer gives it the value null, therefore, by testing to see if
	//the element is null, it will prevent the program from crashing
}
