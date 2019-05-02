package Assignment4;
import java.util.Scanner;

import Assignment4.CellList.CellNode;

import java.util.NoSuchElementException;
import java.io.FileInputStream;
//-----------------------------------------------------
//Assignment 4
//Question: 2
//Written by: Gang Hyun Kim, 40097242
//-----------------------------------------------------
import java.io.FileNotFoundException;

/**
 * Driver class
 * COMP249
 * Assignment 4
 * April 8, 2019
 * @author Jason Kim, 40097242
 *
 */
public class CellListUtilization {

	public static void main(String[] args) throws NoSuchElementException, FileNotFoundException {
		CellList c1 = new CellList();
		CellList c2 = new CellList();
		Scanner sc = null;
		Scanner op = new Scanner(System.in);
		try {
			sc = new Scanner(new FileInputStream("src/Assignment4/Cell_Info.txt"));
			CellPhone p1 = null;
			String info = "";
			int counter = 0;
			while(sc.hasNext()) {
				if(counter == 4) {
					String[] put = info.split(" ");
					p1 = new CellPhone(Long.parseLong(put[0]), put[1], Integer.parseInt(put[3]), Double.parseDouble(put[2]));
					if(!(c1.contains(Long.parseLong(put[0]))))
						c1.addToStart(p1);
					info = "";
					counter = 0;
				}
				info += sc.next() + " ";
				counter++;
			}
			String[] put = info.split(" ");;
			p1 = new CellPhone(Long.parseLong(put[0]), put[1], Integer.parseInt(put[3]), Double.parseDouble(put[2]));
			if(!(c1.contains(Long.parseLong(put[0]))))
				c1.addToStart(p1);
			System.out.println(c1.showContents());
			System.out.println("--------------------------------------------------------------------------\nLets try inputting some more elements!");
			int max;
			while(true) {
				System.out.println("Please enter how many more elements you would like to input: ");
				max = op.nextInt();
				if(max > 0)
					break;
				System.out.println("The input was not valid, so please try again.");
			}
			int ic = 0;
			do {
				System.out.println("Please input a serial number: ");
				long sn = op.nextLong();
				if(!(c1.contains(sn))) {
					System.out.println("Please input the brand name: ");
					String bd = op.next();
					System.out.println("Please input the year: ");
					int yr = op.nextInt();
					System.out.println("Please input the price: ");
					double pe = op.nextDouble();
					CellPhone np = new CellPhone(sn, bd, yr, pe);
					c1.addToStart(np);
					ic++;
					System.out.println("The phone has been accepted and has been added to the list.\n");
				}
				else {
					System.out.println("This serial number already exists. Please try another one.\n");
				}
			}while(ic < max);
			System.out.println("--------------------------------------------------------------------------\n");
			System.out.println(c1.showContents());
			System.out.println("--------------------------------------------------------------------------\n");
			System.out.println("Testing when there are no elements in the list.");
			System.out.println(c2.showContents() + "\n");
			System.out.println("Testing when there is only one element in the list(using inserAtIndex method).");
			CellPhone another1 = new CellPhone(1,"Xiaomi", 2,1);
			c2.insertAtIndex(another1, 0);
			System.out.println(c2.showContents() + "\n");
			System.out.println("Adding more elements to test out other methods...");
			CellPhone another2 = new CellPhone(another1, 2);
			CellPhone another3 = new CellPhone(64789865, "Huawei", 2019, 1050.55);
			c2.addToStart(another2);
			c2.addToStart(another3);
			System.out.println(c2.showContents() + "\n");
			System.out.println("Adding an existing element again.");
			c2.addToStart(another3);
			System.out.println(c2.showContents() + "\n");
			System.out.println("Deleting first element.");
			c2.deleteFromStart();
			System.out.println(c2.showContents() + "\n");
			System.out.println("Replacing first element.");
			CellPhone another4 = new CellPhone(2, "Huawei", 2019, 1050.55);
			c2.replaceAtIndex(another4, 0);
			System.out.println(c2.showContents() + "\n");
			System.out.println("Replacing second element.");
			CellPhone another5 = new CellPhone(5, "Samsung", 2019, 650.25);
			c2.replaceAtIndex(another5, 1);
			System.out.println(c2.showContents() + "\n");
			
			System.out.println("Finding an element in the list using the find method.");
			System.out.println(c2.find(1)); //Non existent element
			System.out.println(c2.find(2)); //Existing element
			
			System.out.println("\nPrivacy leak testing...\nBefore: ");
			CellList c3 = c2.clone();
			CellNode destroy = c3.find(200000);
			System.out.println(destroy.getphone());
			
			System.out.println("After: ");
			destroy.getphone().setbrand("Google");
			destroy.getphone().setprice(870.56);
			destroy.getphone().setserialnum(9834567);
			destroy.getphone().setyear(2020);
			destroy.setnext(null);
			System.out.println(destroy.getphone());
			
			System.out.println("Next element: ");
			System.out.println(destroy.getnext());
			System.out.println("Cannot print the whole list because when deleting all elements that come after the selected node, the size did not change accordingly, therefore it will crash.");

			System.out.println("\nChecking to see if the list contains a specific element.");
			System.out.println(c2.showContents());
			System.out.println("It is " + c2.contains(1) + " that the list contains a phone with the serial number " + "1.");
			System.out.println("It is " + c2.contains(2) + " that the list contains a phone with the serial number " + "2.");
			System.out.println("Trying out the equals method.");
			System.out.println("It is " + c1.equals(c2) + " that c1 equals c2.");
			
			CellList c4 = new CellList(c1);
			System.out.println("It is " + c1.equals(c4) + " that c1 equals c4.");
			System.out.println(c4.showContents());
			System.out.println(c4.getsize());
			
			System.out.println("Please enter an index: ");
			int wow = op.nextInt();
			CellPhone bruh = new CellPhone(187654, "1", 2019, 2000);
			c4.insertAtIndex(bruh, wow);
			System.out.println(c4.showContents());
			System.out.println("--------------------------------------------------------------------------\n");
		}
		catch(NoSuchElementException a) {
			System.out.println("There is no such element in the list. The program will now exit.");
			System.exit(0);
		}
		catch(FileNotFoundException b) {
			System.out.println("The file was not found. This program will now exit.");
			System.exit(0);
		}
		sc.close();
		op.close();
	}

}
