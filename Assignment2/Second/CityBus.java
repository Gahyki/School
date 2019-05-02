package Assignment2.Second;
import Assignment2.First.*;
/* -----------------------------------------------------
* Assignment: 2
* Written by: Jason Kim 40097242
* Due: 11:59 PM – Friday, February 24, 2019
----------------------------------------------------- */
/* -----------------------------------------------------
* Assignment: 2
* Part: 2
* Written by: Jason Kim 40097242
* Due: 11:59 PM – Wednesday, February 20, 2019
----------------------------------------------------- */

/**
 * CityBus class
 * @author Jason Kim, 40097242
 *
 */
public class CityBus extends PublicTransportation {
	//attributes
	protected long routenb;
	protected int beginoperationyear;
	protected String linename;
	protected String drivername;
	//constructors
	/**
	 * Default Constructor
	 */
	public CityBus() {
		super();
		this.routenb = 104;
		this.beginoperationyear = 2019;
		this.linename = "Orange";
		this.drivername = "Bob";
	}
	/**
	 * Parameterized Constructor
	 * @param tp: ticket price
	 * @param stops: number of stops
	 * @param routenb: route number
	 * @param beginoperationyear: year of the start of operation
	 * @param linename: line name
	 * @param drivername: driver name
	 */
	public CityBus(double tp, int stops, long routenb, int beginoperationyear, String linename, String drivername) {
		super(tp, stops);
		this.routenb = routenb;
		this.beginoperationyear = beginoperationyear;
		this.linename = linename;
		this.drivername = drivername;
	}
	/**
	 * Copy Constructor
	 * @param cb: Another CityBus class
	 */
	public CityBus(CityBus cb) {
		super.changeticketprice(cb.getTicketPrice());
		super.changestops(cb.getstops());
		this.routenb = cb.getroutenb();
		this.beginoperationyear = cb.getoperationyear();
		this.linename = cb.linename;
		this.drivername = cb.drivername;
	}
	//accessor
	/**
	 * Accessor to get route number
	 * @return route number
	 */
	public long getroutenb() {
		return this.routenb;
	}
	/**
	 * Accessor to get year of start of operation
	 * @return year of start of operation
	 */
	public int getoperationyear() {
		return this.beginoperationyear;
	}
	/**
	 * Accessor to get line name
	 * @return line name
	 */
	public String getlinename() {
		return this.linename;
	}
	/**
	 * Accessor to get driver's name
	 * @return driver's name
	 */
	public String getdrivername() {
		return this.drivername;
	}
	
	//mutator
	/**
	 * Mutator to change the route number
	 * @param route: new route number
	 */
	public void changeroutenb(long route) {
		this.routenb = route;
	}
	/**
	 * Mutator to change operation year
	 * @param year: year of start of operation
	 */
	public void changeoperationyear(int year) {
		this.beginoperationyear = year;
	}
	/**
	 * Mutator to change line name
	 * @param name: new line name
	 */
	public void changelinename(String name) {
		this.linename = name;
	}
	/**
	 * Mutator to change driver name
	 * @param name: new driver name
	 */
	public void changedrivername(String name) {
		this.drivername = name;
	}
	//others
	/**
	 * toString method
	 * @return string representing the class
	 */
	public String toString() {
		return "This CityBus costs " + super.getTicketPrice() + " per ticket, and has " + super.getstops() + " stops. Its route number is " + routenb + " and began its operation on " + beginoperationyear + ". The line name is " + linename + " and the driver's name is " + drivername + ".";
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
			CityBus other = (CityBus) compared;
			if((super.getTicketPrice() == other.getTicketPrice()) && (super.getstops() == other.getstops()) && (routenb == other.routenb) && (beginoperationyear == other.beginoperationyear) && (linename == other.linename) && (drivername == other.drivername))
				return true;
			else
				return false;
		}
	}//In a case where there this class is in an array and each element of the array is being compared to another element, there might be some parts 
	//of the array that might be empty. When an element in an array is empty the computer gives it the value null, therefore, by testing to see if
	//the element is null, it will prevent the program from crashing
}