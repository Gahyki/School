import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;
/* -----------------------------------------------------
* Assignment: 1
* Written by: Jason Kim 40097242
* Due: 11:59 PM – Sunday, May 19, 2019
----------------------------------------------------- */

public class A1TailTet {
	public static double[] tail(double n, double[] r) {
		//base case when n is smaller or equal to 3
		if(n == 3) {
			r[0] = 1;
			r[1] = 0;
			r[2] = 0;
			r[3] = 0;
			return r;
		}
		else if(n < 3) {
			r[0] = 0;
			r[1] = 0;
			r[2] = 0;
			r[3] = 0;
			return r;
		}
		//non base case
		else {
			double[] a =  tail(n - 1, r);
			double sum = r[0] + r[1] + r[2] + r[3]; //addition of the last for numbers
            //shifting numbers
			r[3] = r[2];
            r[2] = r[1];
            r[1] = r[0];
            r[0] = sum;
            return a;
		}
	}

	public static void main(String[] args) {
		PrintWriter pw = null;
		String name = "outtail.txt";//name of output file
		try {
			pw = new PrintWriter(new FileOutputStream(name));
			for(int i = 0; i < 400; i=i+5) {
				long time = System.nanoTime();//time in nanoseconds
				double[] a = {0,0,0,0};//initial numbers
				double[] tetra = tail(i, a);
				pw.println(i + " - " + tetra[i<3?1:0] + " - " + (System.nanoTime() - time) + " ns"); //for all numbers under 3 there should be no value therefore prints index at 1
			}
			System.out.println("The program has finished calculating and will now terminate.");
		}
		catch(IOException b) {
			System.out.println("The program had I/O problems,so this program will terminate.");
			System.exit(0);
		}
		pw.close();// closing program
	}
}
