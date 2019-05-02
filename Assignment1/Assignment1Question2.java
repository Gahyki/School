package Assignment1;
import java.util.Scanner;
/* -----------------------------------------------------
* Assignment: 1
* Part: 2
* Written by: Jason Kim 40097242
* Due: 11:59 PM – Friday, February 1, 2019
----------------------------------------------------- */


/**
 * Driver class
 * @author Jason Kim
 *
 */
public class Assignment1Question2 {
	//Method I made to count number of books in a specific Book array
	/**
	 * to find the nb of objects in array
	 * @param array: array of books to look through
	 * @return the number of books inside the array
	 */
	public static int size(Book array[]) {
		int counter = 0;
		for(int i = 0; i < array.length; i++) {
			if (array[i] != null)
				counter++;
		}
		return counter;
	}//Method to find nb of elements in array
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Welcome message
		System.out.println("----- Welcome to THE BOOKSTORE -----");
		
		//Maximum number of books
		System.out.print("Please choose the maximum number of books that the store can contain: ");
		int maxBooks;
		do {maxBooks = sc.nextInt();
			if (maxBooks > 0) {
				break;
			}//end of if statement
			else {
				System.out.print("The maximum number of books must be a positive integer.\nPlease try a new number: ");
			}
		}//end of do while loop
		while (true);//do while loop conditions
		
		//Inventory array
		Book inventory[] = new Book[maxBooks];
		
		//Main menu
		int choice;
		String user;
		int tcounter = 0;//Total attempt counter
		int pcounter = 0;//Specific choice attempt counter
		int toenter;
		String password = "password";
		do {System.out.print("What do you want to do?\r\n" + 
				"1. Enter new books (password required)\r\n" + 
				"2. Change information of a book (password required)\r\n" + 
				"3. Display all books by a specific author\r\n" + 
				"4. Display all books under a certain a price.\r\n" + 
				"5. Quit\r\n" + 
				"Please enter your choice: ");
			choice = sc.nextInt();
			switch(choice){
			case 1:
				while(true) {
					System.out.print("\nPlease enter the password: ");
					user = sc.next();
					if((user.toLowerCase()).equals(password)) {
						tcounter = 0;
						pcounter = 0;
						System.out.print("\nEnter the number of books to enter: ");
						toenter = sc.nextInt();
						if ((Book.findNumberOfCreatedBooks() + toenter) <= maxBooks) {
							System.out.println("There is space in the inventory to add the requested book(s).");
							System.out.println("After adding the requested book(s), there will be " + (maxBooks - (Book.findNumberOfCreatedBooks() + toenter)) + " spaces left.");
							for(int i = 0; i < toenter; i++) {
								sc.nextLine(); //Junk line
								System.out.print("\nEnter the title of the book: ");
								String title = sc.nextLine();
								System.out.print("Enter the author of the book: ");
								String author = sc.nextLine();
								System.out.print("Enter the ISBN of the book: ");
								long ISBN = sc.nextLong();
								System.out.print("Enter the price of the book: ");
								double price = sc.nextDouble();
								inventory[Book.findNumberOfCreatedBooks()] = new Book(title, author, ISBN, price);
								System.out.println("There is " + (toenter - i - 1) + " book(s) left to enter.");
							}//end of adding nb of books requested
							System.out.println("There are now " + (maxBooks - Book.findNumberOfCreatedBooks()) + " space(s) left in the inventory.\n\n");
						}//end of adding books if inventory is not full
						else {
							toenter = maxBooks - Book.findNumberOfCreatedBooks();
							System.out.println("The number of book(s) to be added surpasses the inventory capacity.");
							System.out.println("The maximum number of books that can be added is " + toenter + ". So " + toenter + " book(s) will be added instead.");
							for(int i = 0; i < toenter; i++) {
								sc.nextLine(); //Junk line
								System.out.print("\nEnter the title of the book: ");
								String title = sc.nextLine();
								System.out.print("Enter the author of the book: ");
								String author = sc.nextLine();
								System.out.print("Enter the ISBN of the book: ");
								long ISBN = sc.nextLong();
								System.out.print("Enter the price of the book: ");
								double price = sc.nextDouble();
								inventory[Book.findNumberOfCreatedBooks()] = new Book(title, author, ISBN, price);
								System.out.println("There is " + (toenter - i - 1) + " book(s) left to enter.");
							}//end of adding nb of books requested
							System.out.println("The inventory is full.\n\n");
						}//end of adding books to be exactly full
					break;
					}//if password is valid
					else {
						pcounter++;
						if(pcounter == 3) {
							System.out.println("All of your attempts have been used. You will be brought back to the main menu.");
							pcounter = 0;
							tcounter++;
							break;
						}
						else
							System.out.println("You have a total of 3 attempts. Currently you have " + (3 - pcounter) +" attempt(s) left.");
					}//end of wrong password
				}//End of while loop to check password
				if (tcounter == 4) {
					System.out.println("The program detected suspicous activities and will terminate immediately!");
					break;
				}//Suspicious activities security measure
				continue;
			case 2:
				while(true) {
					System.out.print("\nPlease enter the password: ");
					user = sc.next();
					if((user.toLowerCase()).equals(password)) {
						System.out.print("\nWhich book number would you like to update? ");
						int bookindex = sc.nextInt() - 1; //to transform from position to index
						while (true) {
							if(inventory[bookindex] != null) {
								System.out.println(inventory[bookindex]);
								System.out.print("\nWhat information would you like to change?\r\n" + 
										"1. author\r\n" + 
										"2. title\r\n" + 
										"3. ISBN\r\n" + 
										"4. price\r\n" + 
										"5. Quit\r\n" + 
										"Enter your choice: ");
								int change = sc.nextInt();
								sc.nextLine(); //Junk line
								switch(change) {
									case 1:
										System.out.print("Enter a new name: ");
										String a = sc.nextLine();
										inventory[bookindex].changeA(a);
										continue;
									case 2:
										System.out.print("Enter a new title: ");
										String t = sc.nextLine();
										inventory[bookindex].changeT(t);
										continue;
									case 3:
										System.out.print("Enter a new ISBN: ");
										long i = sc.nextLong();
										inventory[bookindex].changeI(i);
										continue;
									case 4:
										System.out.print("Enter a new price: ");
										double p = sc.nextDouble();
										inventory[bookindex].changeP(p);
										continue;
									case 5:
										break;
								}
								break;
							}
							else {
								System.out.println("\nThere is no book at this location.");
								System.out.print("Please choose an option (1 or 2): \r\n" + 
										"1. Re-enter a new book number\r\n" + 
										"2. Quit to main menu\r\n" + 
										"Please enter your choice: ");
								int case2 = sc.nextInt();
								System.out.println("");
								if (case2 == 2) {
									break;
								}//To go back to main menu
								//No else statement --> continue loop to re-enter book number 
							}//end of options when there is no book at the indicated location
						}//End of of book number to update
						break;
					}//when password is valid
					else {
						pcounter++;
						if(pcounter == 3) {
							System.out.println("All of your attempts have been used. You will be brought back to the main menu.");
							pcounter = 0;
							break;
						}//when password is invalid more than 3 times
						else
							System.out.println("You have a total of 3 attempts. Currently you have " + (3 - pcounter) +" attempt(s) left.");
					}//when password is invalid
				}//End of while loop to check password
				continue;
			case 3:
				sc.nextLine(); //Junk line
				System.out.print("\nPlease enter the author's name: ");
				String name = sc.nextLine();
				for(int i = 0; i < size(Book.findBooksBy(inventory, name)); i++)
					System.out.println("\n" + Book.findBooksBy(inventory, name)[i] + "\n");
					//printing out array which contains books by the author (must input the exact author's name)
				System.out.println("\n");
				continue;
			case 4:
				System.out.println("Please enter a price, which will be considered to be the maximum budget for you book purchase: ");
				double maxprice = sc.nextDouble();
				for(int i = 0; i < size(Book.findCheaperThan(inventory, maxprice)); i++)
					System.out.println("\n" + Book.findCheaperThan(inventory, maxprice)[i] + "\n");
					//printing out array which contains only elements cheaper or equal to the mentioned double value
				System.out.println("\n");
				continue;
			case 5:
				System.out.println("\n\n----- Thank you for using THE BOOKSTORE -----");
				break;
			default:
				System.out.println("This is an INVALID input. Please select a valid option.\n");
				continue;
			}//end of switch
			break;
		}//end of do while loop
		while (true);//do while loop conditions
		sc.close();
	}//end of main method
}//end of class
