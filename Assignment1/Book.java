package Assignment1;
/* -----------------------------------------------------
* Assignment: 1
* Part: 1
* Written by: Jason Kim 40097242
* Due: 11:59 PM – Friday, February 1, 2019
----------------------------------------------------- */

import java.text.DecimalFormat;

/**
 * Book class
 * @author Jason Kim
 *
 */

public class Book {
	
	private static final DecimalFormat format = new DecimalFormat("#.##");
	
	//Attributes
	static int nb = 0;
	private String title;
	private String author;
	private long ISBN;
	private double price;
	
	/**
	 * Constructor
	 * @param t: title of book
	 * @param a: author
	 * @param i: ISBN
	 * @param p: price
	 */
	public Book(String t, String a, long i, double p) {
		this.title = t;
		this.author = a;
		this.ISBN = i;
		this.price = p;
		nb += 1;	
	}

	//Accessors
		
	/**
	 * Accessor method to get the title of book
	 * @return title of book as a string
	 */
	public String getT() {
		return this.title;
	}
	/**
	 * Accessor method to get the author of book
	 * @return author of book as a string
	 */
	public String getA() {
		return this.author;
	}
	
	/**
	 * Accessor method to get the ISBN of book
	 * @return ISBN of book as a long
	 */
	public long getI(){
		return this.ISBN;
	}
	
	/**
	 * Accessor method to get the price of book
	 * @return price of book as a double
	 */
	public double getP() {
		return this.price;
	}
	
	/**
	 * Accessor method to get the nb of books created
	 * @return nb of book as an integer
	 */
	public static int findNumberOfCreatedBooks() {
		return nb;
	}
	
	
	//Mutators
	/**
	 * Changing the title attribute
	 * @param t: new title 
	 */
	public void changeT(String t) {
		this.title = t;
	}
	
	/**
	 * Changing the author attribute
	 * @param a: new author name
	 */
	public void changeA(String a) {
		this.author = a;
	}
	
	/**
	 * Changing the ISBN attribute
	 * @param i: new ISBN number
	 */
	public void changeI(long i) {
		this.ISBN = i;
	}
	
	/**
	 * Changing the price attribute
	 * @param p: new price of book
	 */
	public void changeP(double p) {
		this.price = p;
	}
	
	//Other methods
	/**
	 * toString method for the class
	 * @return String value of the class
	 */
	public String toString() {
		return "Author: " + this.author + "\nTitle: " + this.title + "\nISBN: " + this.ISBN + "\nPrice: $" + format.format(this.price);
	}
	
	/**
	 * equals method to see if the two compared objects are equal
	 * @param other: the name of the other object being compared to
	 * @return boolean return value if the two objects are equal
	 */
	public boolean equals(Book other) {
		if ((this.ISBN == other.ISBN)&&(this.price == other.price)) {
			return true;
		}
		else
			return false;
	}
	
	/**
	 *  a method to find all books created by input author
	 * @param inventory: the array of book which is being searched through
	 * @param author: author's name that is being searched
	 * @return an array of books that have the same author
	 */
	public static Book[] findBooksBy(Book[] inventory, String author) {
		int foundcounter = 0;
		Book[] foundbooks = new Book[inventory.length-1];
		for (int i = 0; i < inventory.length; i++) {
			if(inventory[i] != null) {
				if (((inventory[i].getA()).toLowerCase()).equals(author.toLowerCase())) {
					foundbooks[foundcounter] = inventory[i];
					foundcounter++;
				}
			}
		}//end for looking for books with right author name in the inventory
		if(foundcounter == 0)
			System.out.println("There are no books in the inventory by this author.");
		return foundbooks;
	}
	
	/**
	 * a method to find all books cheaper than the input budget
	 * @param inventory: array of all books
	 * @param maxprice: the max price of any book
	 * @return an array of books that fit the maxprice criteria
	 */
	public static Book[] findCheaperThan(Book[] inventory, double maxprice) {
		int cc = 0;
		Book[] cheap = new Book[inventory.length-1];
		for (int i = 0; i < inventory.length; i++) {
			if(inventory[i] != null) {
				if(inventory[i].getP() <= maxprice) {
					cheap[cc] = inventory[i];
					cc++;
				}
			}
		}//end of creating array with books cheaper or equal to the mentioned double value maxprice
		if (cc == 0)
			System.out.println("There are no books as cheap or cheaper than this price.");
		return cheap;
	}
}//end of class
