import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/* -----------------------------------------------------
* Assignment: 1
* Written by: Jason Kim 40097242
* Due: 11:59 PM – Sunday, May 19, 2019
----------------------------------------------------- */
public class A1ExpT {
	public static int tet(int n) {
		//base case when n is smaller than 3
		if(n < 3)
			return 0;
		//base case when n is equal to 3
		if(n == 3)
			return 1;
		//non base case where we sum the 4 instances of the function
		return tet(n-1) + tet(n-2) + tet(n-3) + tet(n-4);
	}
	
	public static void main(String[] args) {
		PrintWriter pw = null;
		String name = "outexp.txt";//name of the output file
		try {
			pw = new PrintWriter(new FileOutputStream(name));
			for(int i = 0; i < 35; i++) {
				long time = System.nanoTime();//time in nanoseconds
				int tetra = tet(i);
				pw.println(i + " - " + tetra + " - " + (System.nanoTime() - time) + " ns");
			}
			System.out.println("The program has finished calculating and will now terminate.");
		}
		catch(FileNotFoundException x) {
			System.out.println("The file was not found.");
			System.exit(0);
		}
		catch(IOException y) {
			System.out.println("The program had I/O problems,so this program will terminate.");
			System.exit(0);
		}

		pw.close();
	}
}
