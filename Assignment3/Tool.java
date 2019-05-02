package Assignment3;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;
/* -----------------------------------------------------
* Assignment: 3
* Written by: Jason Kim 40097242
* Due: 11:59 PM – Saturday, March 23, 2019
----------------------------------------------------- */
/**
 * 
 * @author Jason Kim 40097242
 * @COMP249
 * @Assignment #3
 * @Due Date 03/24/2019
 */
public class Tool {
	static int exists = 0;
	/**
	 * Method to find author among the articles
	 * @param target - String author that is being searched
	 * @param sc - scanner input
	 * @param IEEE - printwriter output
	 * @param ACM - printwriter output
	 * @param NJ - printwriter output
	 * @throws FileNotFoundException - file not found exception
	 * @throws IOException - input output exception
	 */
	public static void AuthorBibCreator (String target, Scanner sc, PrintWriter IEEE, PrintWriter ACM, PrintWriter NJ) throws FileNotFoundException, IOException {
		String line = "";
		String author = "";
		String title = "";
		String journal = "";
		String volume = "";
		String number = "";
		String pages = "";
		String month = "";
		String year = "";
		String doi = "";
		
		StringTokenizer aut1;
		StringTokenizer aut2;
		StringTokenizer aut3;		
		
		String output1 = "";
		String output2 = "";
		String output3 = "";
		while(sc.hasNext()) {
			//try buffered reader
			line = sc.next();
			if (line.equals("}")) {
				if(author.contains(target)) {
					exists++;
					//IEEE part
					aut1 = new StringTokenizer(author);
					while(aut1.hasMoreTokens()) {
						String token1 = aut1.nextToken();
						if(!(token1.equals("and"))) {
							output1 += token1 + " ";
						}
						else {
							output1 = output1.substring(0, (output1.length() - 1));
							output1 += ", ";
						}
					}
					output1 = output1.substring(1, (output1.length() - 3)) + ". \"" + title.substring(1, (title.length() - 3)) + "\", " + journal.substring(1, (journal.length() - 3));
					output1 += ", vol." + volume.substring(1, (volume.length() - 2)) + ", no. " + number.substring(1, (number.length() - 2)) + ", p. " + pages.substring(1, (pages.length() - 2));
					output1 += ", " + month.substring(1, (month.length() - 2)) + " " + year.substring(1, (year.length() - 2)) + ".";
					IEEE.println(output1 + "\n");
					IEEE.flush();
					output1 = "";
					
					
					
					//ACM part
					aut2 = new StringTokenizer(author);
					while (aut2.hasMoreTokens()) {
						String token2 = aut2.nextToken();
						if(!(token2.equals("and"))) { 
							output2 += token2 + " ";
						}
						else {
							output2 = output2.substring(0, (output2.length() - 1));
							break;
						}
					}
					output2 = "[" + exists + "]\t" + output2.substring(1) + " et al. " + year.substring(1, (year.length() - 2)) + ". " + title.substring(1, (title.length() - 3)) + ". " + journal.substring(1, (journal.length() - 3)) + ". ";
					output2 += volume.substring(1, (volume.length() - 2)) + ", " + number.substring(1, (number.length() - 2)) + " (" + year.substring(1, (year.length() - 2)) + "), " + pages.substring(1, (pages.length() - 2));
					output2 += ". DOI:https://doi.org/" + doi.substring(1, (doi.length() - 2));
					ACM.println(output2 + "\n");
					ACM.flush();
					//acm_counter++;
					output2 = "";
					
					
					
					//NJ part
					aut3 = new StringTokenizer(author);
					while (aut3.hasMoreTokens()) {
						String token3 = aut3.nextToken();
						if(!(token3.equals("and"))) { 
							output3 += token3 + " ";
						}
						else {
							output3 += "& ";
						}
					}
					output3 = output3.substring(1, (output3.length() - 2)) + ". " + title.substring(1, (title.length() - 3)) + ". " + journal.substring(1, (journal.length() - 3)) + ". " + volume.substring(1, (volume.length() - 2));
					output3 += ", " + pages.substring(1, (pages.length() - 2)) + "(" + year.substring(1, (year.length() - 2)) + ").";
					NJ.println(output3 + "\n");
					NJ.flush();
					output3 = "";
				}

				
				if(!(author.equals(""))) {
					author = "";
					title = "";
					journal = "";
					volume = "";
					number = "";
					pages = "";
					month = "";
					year = "";
					doi = "";
				}

			}
			//Decomposing the files
			else if(line.contains("author=")) {
				author += line.substring(7) + " ";
				while(!(line.contains("}"))) {
					line = sc.next();
					author += line + " ";
				}
			
			}
			else if(line.contains("title=")) {
				title += line.substring(6) + " ";
				while(!(line.contains("}"))) {
					line = sc.next();
					title += line + " ";
				}
			}

			else if(line.contains("journal=")) {
				journal += line.substring(8) + " ";
				while(!(line.contains("}"))) {
					line = sc.next();
					journal += line + " ";
				}
			}
			else if(line.contains("volume=")) {
				volume += line.substring(7);
				while(!(line.contains("}"))) {
					line = sc.next();
					volume += line + " ";
				}				
			}
			else if(line.contains("number=")) {
				number += line.substring(7);
				while(!(line.contains("}"))) {
					line = sc.next();
					number += line + " ";
				}			
			}
			else if(line.contains("pages=")) {
				pages += line.substring(6);
				while(!(line.contains("}"))) {
					line = sc.next();
					pages += line + " ";
				}
			}
			else if(line.contains("month=")) {
				month += line.substring(6);
				while(!(line.contains("}"))) {
					line = sc.next();
					month += line + " ";
				}
			}
			else if(line.contains("year=")) {
				year += line.substring(5);
				while(!(line.contains("}"))) {
					line = sc.next();
					year += line + " ";
				}
			}
			else if(line.contains("doi=")) {
				doi += line.substring(4);
				while(!(line.contains("}"))) {
					line = sc.next();
					doi += line + " ";
				}
			}
		}

		
	}
	public static void main(String[] args) throws FileExistsException {
		// TODO Auto-generated method stub
		Scanner input = null;
		Scanner sc = null;
		File I = null;
		File A = null;
		File N = null;
		PrintWriter IEEE = null;
		PrintWriter ACM = null;
		PrintWriter NJ = null;
		int error = 0;
		String find = "";
		try {
			System.out.println("Welcome to BibCreator!\n");
			input = new Scanner(System.in);
			System.out.print("Please enter the author name you are targeting: ");
			String target = input.next();
			find = target;
			I = new File(target + "-IEEE.json");
			A = new File(target + "-ACM.json");
			N = new File(target + "-NJ.json");
			if(I.exists() | A.exists() | N.exists()) {
				throw new FileExistsException();
			}
			
			for(int i = 1; i <= 10; i++) {
				error = i;
				sc = new Scanner(new FileInputStream("src/Assignment3/Assg_3-Needed-Files/Latex" + i + ".bib"));
				
				if(I.exists() && A.exists() && N.exists()) {
					IEEE = new PrintWriter(new FileOutputStream(target + "-IEEE.json", true));
					ACM = new PrintWriter(new FileOutputStream(target + "-ACM.json", true));
					NJ = new PrintWriter (new FileOutputStream(target + "-NJ.json", true));
					AuthorBibCreator(target, sc, IEEE, ACM, NJ);
				}
				else {
					IEEE = new PrintWriter(new FileOutputStream(target + "-IEEE.json"));
					ACM = new PrintWriter(new FileOutputStream(target + "-ACM.json"));
					NJ = new PrintWriter (new FileOutputStream(target + "-NJ.json"));
					AuthorBibCreator(target, sc, IEEE, ACM, NJ);
				}
				

			}
			if(exists == 0) {
				System.out.println("No records were found for author(s) with name: " + target);
				System.out.println("No files have been created!\n");
				System.out.println("Goodbye! Hope you have enjoyed creating the needed files using AuthorBibCreator.");
				File I1 = new File(target + "-IEEE.json");
				File A1 = new File(target + "-ACM.json");
				File N1 = new File(target + "-NJ.json");
				System.out.println(I1.delete());
				
				System.exit(0);
			}
			else {
				System.out.println("A total of " + exists + " records were found for author(s) with name:" + target);
				System.out.println("Files " + I + ", " + A + ", and " + N + " have been created!");
				System.out.println("Goodbye! Hope you have enjoyed creating the needed files using AuthorBibCreator.");
			}
		}
		catch(FileNotFoundException a) {
			System.out.println("Could not open input file " + error + " for reading. Please check if file exists! Program will terminate after closing any opened files.");
			System.exit(0);
		}
		catch(IOException b) {
			System.out.println("The program had I/O problems,so this program will terminate.");
			System.exit(0);
		}
		catch(FileExistsException c) {
			c.getMessage();
			File fI = new File(find + "-BU-IEEE.json");
			File fA = new File(find + "-BU-ACM.json");
			File fN = new File(find + "-BU-NJ.json");
			boolean rI;
			boolean rA;
			boolean rN;
			if(I.exists()) {
				System.out.println("A file already exists with the name: " + I);
				fI.delete();
				rI = I.renameTo(fI);
				if(rI)
					System.out.println("File will be renamed as: " + fI + " and any old BUs will be deleted.");
				else
					System.out.println("There was an error renaming the files. This program will now exit.");
			}
			if(A.exists()) {
				System.out.println("A file already exists with the name: " + A);
				fA.delete();
				rA = A.renameTo(fA);
				if(rA)
					System.out.println("File will be renamed as: " + fA + " and any old BUs will be deleted.");
				else
					System.out.println("There was an error renaming the files. This program will now exit.");
			}
			if(N.exists()) {
				System.out.println("A file already exists with the name: " + N);
				fN.delete();
				rN = N.renameTo(fN);
				if(rN)
					System.out.println("File will be renamed as: " + fN + " and any old BUs will be deleted.");
				else
					System.out.println("There was an error renaming the files. This program will now exit.");
			}

			System.exit(0);
		}
		sc.close();
		input.close();
		IEEE.close();
		ACM.close();
		NJ.close();
		

	}
}
