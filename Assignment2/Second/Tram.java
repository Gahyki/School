package Assignment2.Second;
/* -----------------------------------------------------
* Assignment: 2
* Written by: Jason Kim 40097242
* Due: 11:59 PM – Friday, February 24, 2019
----------------------------------------------------- */
/**
 * Tram class
 * @author Jason Kim, 40097242
 *
 */
public class Tram extends CityBus {
	//attribute
	private int maxspeed;
	//constructor
	/**
	 * Default Constructor
	 */
	public Tram() {
		super();
		this.maxspeed = 25;
	}
	/**
	 * Parameterized Constructor
	 * @param tp: ticket price
	 * @param stops: number of stops
	 * @param routenb: route number
	 * @param beginoperationyear: year of start of operation
	 * @param linename: line name
	 * @param drivername: driver name
	 * @param maxspeed: maximum speed that the tram can achieve
	 */
	public Tram(double tp, int stops, long routenb, int beginoperationyear, String linename, String drivername, int maxspeed) {
		super(tp, stops, routenb, beginoperationyear, linename, drivername);
		this.maxspeed = maxspeed;
	}
	/**
	 * Copy Constructor
	 * @param tm: Tram class which will be copied
	 */
	public Tram(Tram tm) {
		super.changeticketprice(tm.getTicketPrice());
		super.changestops(tm.getstops());
		this.routenb = tm.getroutenb();
		this.beginoperationyear = tm.getoperationyear();
		this.linename = tm.linename;
		this.drivername = tm.drivername;
		this.maxspeed = tm.getspeed();
	}
	/**
	 * Accessor to get max speed attribute
	 * @return max speed
	 */
	public int getspeed() {
		return this.maxspeed;
	}
	//mutator
	/**
	 * Mutator to change the max speed
	 * @param speed: new max speed
	 */
	public void changespeed(int speed) {
		this.maxspeed = speed;
	}
	//others
	/**
	 * toString method
	 * @return String that represents the class
	 */
	public String toString() {
		return "This Tram costs " + super.getTicketPrice() + " per ticket, and has " + super.getstops() + " stops. Its route number is " + routenb + " and began its operation on " + beginoperationyear + ".\nThe line name is " + linename + " and the driver's name is " + drivername + ". The Tram goes at a max speed of " + this.maxspeed + "km/h.";
	}
	/**
	 * equals method
	 * @param other: class that is to be compared
	 * @return boolean value if they are equal or not
	 */
	public boolean equals(Tram compared) {
		if(compared == null|| this.getClass() != compared.getClass()) {
			return false;
		}
		else {
			Tram other = (Tram) compared;
			if((super.getTicketPrice() == other.getTicketPrice()) && (super.getstops() == other.getstops()) && (routenb == other.routenb) && (beginoperationyear == other.beginoperationyear) && (linename == other.linename) && (drivername == other.drivername) && (this.maxspeed == other.getspeed()))
				return true;
			else
				return false;
		}
	}//In a case where there this class is in an array and each element of the array is being compared to another element, there might be some parts 
	//of the array that might be empty. When an element in an array is empty the computer gives it the value null, therefore, by testing to see if
	//the element is null, it will prevent the program from crashing
}
