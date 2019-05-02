package Assignment2.Fourth;
import Assignment2.First.*;
/* -----------------------------------------------------
* Assignment: 2
* Written by: Jason Kim 40097242
* Due: 11:59 PM – Friday, February 24, 2019
----------------------------------------------------- */
/**
 * AirCraft class
 * @author Jason Kim, 40097242
 *
 */
public class AirCraft extends PublicTransportation{
	/**
	 * Enumeration class representing the type of class of the AirCraft
	 */
	public enum tclass{
		Helicopter, Airline, Glider, Balloon;
	}
	/**
	 * Enumeration class representing the type of maintenance that the AirCraft needs
	 */
	public enum tmaintenance{
		Weekly, Monthly, Yearly;
	}
	private tclass classtype;
	private tmaintenance maintenancetype;
	/**
	 * Default Constructor
	 */
	public AirCraft() {
		super();
		this.classtype = tclass.Airline;
		this.maintenancetype = tmaintenance.Monthly;
	}
	/**
	 * Parameterized Constructor
	 * @param tp: ticket price
	 * @param s: number of stops
	 * @param ccraft: class type of the aircraft
	 * @param mcraft: maintenance type of the aircraft
	 */
	public AirCraft(double tp, int s, tclass ccraft, tmaintenance mcraft) {
		super(tp, s);
		this.classtype = ccraft;
		this.maintenancetype = mcraft;
	}
	/**
	 * Copy Constructor
	 * @param other: AirCraft class to be copied
	 */
	public AirCraft(AirCraft other) {
		super(other.getTicketPrice(), other.getstops());
		this.classtype = other.getclasstype();
		this.maintenancetype = other.getmaintenancetype();
	}
	/**
	 * Accessor to get the class type
	 * @return class type of AirCraft
	 */
	public tclass getclasstype() {
		return this.classtype;
	}
	/**
	 * Accessor to get the maintenance type
	 * @return maintenance type of AirCraft
	 */
	public tmaintenance getmaintenancetype() {
		return this.maintenancetype;
	}
	/**
	 * Mutator to change the class type of the AirCraft
	 * @param x: new class type of aircraft (must do tclass.newclasstype)
	 */
	public void changeclasstype(tclass ct) {
		this.classtype = ct;
	}
	/**
	 * Mutator to change the maintenance type of the AirCraft
	 * @param x: new maintenance type of aircraft (must do tmaintenance.newclasstype)
	 */
	public void changemaintenancetype(tmaintenance mt) {
		this.maintenancetype = mt;
	}
	/**
	 * toString method
	 * @return string representing the class
	 */
	public String toString() {
		return "This Aircraft costs " + this.getTicketPrice() + " per ticket and has " + this.getstops() + " stops. It is an AirCraft of the class " + this.classtype + " and needs to be maintained every " + this.maintenancetype + ".";
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
			AirCraft other = (AirCraft) compared;
			if((this.getTicketPrice() == other.getTicketPrice()) && (this.getstops() == other.getstops()) && (this.classtype == other.getclasstype()) && (this.maintenancetype == other.getmaintenancetype()))
				return true;
			else
				return false;
		}
	}//In a case where there this class is in an array and each element of the array is being compared to another element, there might be some parts 
	//of the array that might be empty. When an element in an array is empty the computer gives it the value null, therefore, by testing to see if
	//the element is null, it will prevent the program from crashing
}
