package Assignment4;

//-----------------------------------------------------
//Assignment 4
//Question: 2
//Written by: Gang Hyun Kim, 40097242
//-----------------------------------------------------
/**
 * CellPhone class
 * COMP249
 * Assignment 4
 * April 8, 2019
 * @author Jason Kim, 40097242
 * 
 */
public class CellPhone {
	private long serialNum;
	private String brand;
	private int year;
	private double price;
	/**
	 * Parameterized constructor
	 * @param s: serial number
	 * @param b: brand
	 * @param y: year
	 * @param p: price
	 */
	public CellPhone(long s, String b, int y, double p) {
		this.serialNum = s;
		this.brand = b;
		this.year = y;
		this.price = p;
	}
	/**
	 * Copy constructor
	 * @param other: CellPhone object to be copied
	 * @param s: new serial number
	 */
	public CellPhone(CellPhone other, long s) {
		this.serialNum = s;
		this.brand = other.getbrand();
		this.year = other.getyear();
		this.price = other.getprice();
	}
	
	//methods
	/**
	 * Method to get the serial number
	 * @return (long) serial number of the CellPhone
	 */
	public long getserialnum() {
		return this.serialNum;
	}
	/**
	 * Method to get the brand of the CellPhone
	 * @return (String) brand of the CellPhone
	 */
	public String getbrand() {
		return this.brand;
	}
	/**
	 * Method to get the year of the CellPhone
	 * @return (int) year of the CellPhone object
	 */
	public int getyear() {
		return this.year;
	}
	/**
	 * Method to the price of the CellPhone
	 * @return (double) price of the CellPhone object
	 */
	public double getprice() {
		return this.price;
	}
	
	/**
	 * Method to set a new serial number for the CellPhone object
	 * @param n: new serial number
	 */
	public void setserialnum(long n) {
		this.serialNum = n;
	}
	/**
	 * Method to change the brand of the CellPhone
	 * @param b: new brand
	 */
	public void setbrand(String b) {
		this.brand = b;
	}
	/**
	 * Method to change the year of the CellPhone
	 * @param y: new year
	 */
	public void setyear(int y) {
		this.year = y;
	}
	/**
	 * Method to change the price of the CellPhone
	 * @param p: new price
	 */
	public void setprice(double p) {
		this.price = p;
	}
	/**
	 * Method to compare two CellPhone objects
	 * @param other: the CellPhone object to compare
	 * @return (boolean) true if the two CellPhone objects are equal
	 */
	public boolean equals(Object other) {
		if(other == null| this.getClass() != other.getClass())
			return false;
		else {
			CellPhone compare = (CellPhone) other;
			if((this.getbrand() == compare.getbrand()) && (this.getyear() == compare.getyear()) && (this.getprice() == compare.getprice()))
				return true;
			else
				return false;
		}
	}
	/**
	 * toString method
	 * @return String output of all the information on the CellPhone object
	 */
	public String toString() {
		return this.getserialnum() + ":  " + this.getbrand() + " " + this.getprice() + "$ " + this.getyear();
	}
	/**
	 * Method to make a deep copy of the CellPhone object
	 * @param x: new serial number
	 * @return new CellPhone object with a new serial number
	 */
	public CellPhone clone(long x) {
		return new CellPhone(this, x);
	}
}
