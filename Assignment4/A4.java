package Assignment4;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.File;


public class A4 {
	
	public static void main(String[] args) {
		PrintWriter pw = null;
		Scanner sc = null;
		Scanner input = null;
		File ot = null;
		ArrayList<String> alpha = new ArrayList<String>();
		try {
			//Output
			pw = new PrintWriter(new FileOutputStream("SubDictionary.txt"));
			

			
			//Input
			input = new Scanner(System.in);
			System.out.println("Please enter the name of the file you would like to read: ");
			String toread = input.next();
			sc = new Scanner(new FileInputStream("src/Assignment4/" + toread + ".txt"));
			
			//Reading file + Filtering
			while(sc.hasNext()) {
				String word = sc.next();
				String[] pun = word.split("");				
				String clean = "";
				for(String ch : pun) {
					//Remove punctuation
					if(!(ch.equals(".")||ch.equals("?")||ch.equals(":")||ch.equals(",")||ch.equals("=")||ch.equals(";")||ch.equals("!")))
						clean += ch;
					//Remove numbers
					if(ch.equals("0")||ch.equals("1")||ch.equals("2")||ch.equals("3")||ch.equals("4")||ch.equals("5")||ch.equals("6")||ch.equals("7")||ch.equals("8")||ch.equals("9")) {
						clean = "";
						break;
					}
					//Apostrophes
					if(ch.equals("’")) {
						clean = clean.substring(0, clean.length() - 1);
						break;
					}	
				}
				//Removing numbers
				if(clean.equals(""))
					continue;
				//Removing single characters
				if (clean.length() == 1 && (!(clean.equals("A")||clean.equals("I"))))
					continue;
				//Adding to the ArrayList
				if(!(alpha.contains(clean.toUpperCase()))) 
					alpha.add(clean.toUpperCase());
			}
			//Sorting in alphabetic order
			alpha.sort(null);
			pw.println("The document produced this sub-dictionary, which includes " + alpha.size() + " entries.");
			char previous = ' ';
			char now = ' ';
			//Printing + Separation between alphabets
			for(String element : alpha) {
				now = element.charAt(0);
				if (now > previous) {
					pw.println("\n" + now);
					pw.println("==");
					pw.println(element);
					previous = element.charAt(0);
				}
				else
					pw.println(element);
			}
			System.out.println("\nThe sub dictionary has successfully been created. Thank you for using this program.");
		}
		catch(FileNotFoundException a) {
			ot = new File("SubDictionary.txt");
			System.out.println("The file was not found.");
			pw.close();
			ot.delete();
			System.exit(0);
		}
		pw.close();
		sc.close();
		input.close();
	}
}
