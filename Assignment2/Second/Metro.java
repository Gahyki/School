package Assignment2.Second;
/* -----------------------------------------------------
* Assignment: 2
* Written by: Jason Kim 40097242
* Due: 11:59 PM – Friday, February 24, 2019
----------------------------------------------------- */

/**
 * Metro class
 * @author Jason Kim, 40097242
 *
 */
public class Metro extends CityBus {
	//Attributes
	private int nbvehicles;
	private String city;
	
	/**
	 * Default Constructor
	 */
	public Metro() {
		super();
		this.nbvehicles = 10;
		this.city = "Montreal";
	}

	/**
	 * Parameterized Constructor
	 * @param tp: ticket price
	 * @param stops: number of stops
	 * @param routenb: route number
	 * @param beginoperationyear: year of the start of operation 
	 * @param linename: line name
	 * @param drivername: driver name
	 * @param nbvehicles: number of vehicles
	 * @param city: name of city
	 */
	public Metro(double tp, int stops, long routenb, int beginoperationyear, String linename, String drivername, int nbvehicles, String city) {
		super(tp, stops, routenb, beginoperationyear, linename, drivername);
		this.nbvehicles = nbvehicles;
		this.city = city;		
	}
	/**
	 * Copy Constructor
	 * @param mt: Another Metro class
	 */
	public Metro(Metro mt) {
		super(mt.getTicketPrice(), mt.getstops(), mt.getroutenb(), mt.getoperationyear(), mt.getlinename(), mt.getdrivername());
		this.nbvehicles = mt.getnbvehicles();
		this.city = mt.getcity();
	}
	/**
	 * Accessor to get number of vehicles
	 * @return integer number of vehicles
	 */
	public int getnbvehicles() {
		return this.nbvehicles;
	}
	/**
	 * Accessor to get name of city
	 * @return name of city
	 */
	public String getcity() {
		return this.city;
	}
	/**
	 * Mutator to change number of vehicles
	 * @param nb: new number of vehicles
	 */
	public void changenbvehicles(int nb) {
		this.nbvehicles = nb;
	}
	/**
	 * Mutator to change name of city
	 * @param city: new name of city
	 */
	public void changecity(String city) {
		this.city = city;
	}
	/**
	 * toString method
	 * @return String that represents the class
	 */
	public String toString() {
		return "The Metro costs " + super.getTicketPrice() + " per ride and has " + super.getstops() + " number of stops. The route number is " + routenb + " and began its operation on " + beginoperationyear + ".\nThe line name is " + linename + " and the driver's name is " + drivername + ". This Metro has " + this.nbvehicles + " vehicles and is in the city of " + this.city + ".";
	}
	/**
	 * equals method
	 * @param other: class that is to be compared
	 * @return boolean value if they are equal or not
	 */
	public boolean equals(Object compared) {
		if(compared == null|| this.getClass() != compared.getClass()) {
			return false;
		}
		else {
			Metro other = (Metro) compared;
			if((super.getTicketPrice() == other.getTicketPrice()) && (super.getstops() == other.getstops()) && (routenb == other.routenb) && (beginoperationyear == other.beginoperationyear) && (linename == other.linename) && (drivername == other.drivername) && (this.nbvehicles == other.getnbvehicles()) && (this.city.toUpperCase() == other.city.toUpperCase()))
				return true;
			else
				return false;
		}
	}//In a case where there this class is in an array and each element of the array is being compared to another element, there might be some parts 
	//of the array that might be empty. When an element in an array is empty the computer gives it the value null, therefore, by testing to see if
	//the element is null, it will prevent the program from crashing
}
