import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class A2 {
	
	
	public static void main(String[] args) {
		Scanner sc = null;
		PrintWriter pw = null;
		A2Stack op; //
		A2Stack val;
		String out = "A2OUTPUT.txt";
		try {
			sc = new Scanner(new FileInputStream("a2.txt"));
			pw = new PrintWriter(new FileOutputStream(out));
			while(sc.hasNextLine()) {
				op = new A2Stack();
				val = new A2Stack();
				String spaced = sc.nextLine().replaceAll("\\s+", "");
				spaced = spaced.replaceAll("\\d+", " $0 ");
				spaced = spaced.replaceAll("\\^", " $0 ");
				spaced = spaced.replaceAll("\\(", " $0 ");
				spaced = spaced.replaceAll("\\)", " $0 ").trim();
				spaced += " $";
				String[] A = spaced.split("\\s+");
				
				for(int i = 0; i < A.length; i++) {
					if(A[i].equals("(")) {
						op.push(A[i]);
					}//for (
					else if(A[i].equals(")")) {
						while(!op.top().equals("(")) {
							A2Methods.repeatOps(val, op, op.top());
						}//evaluate the numbers in the parenthesis
						op.pop();
					}//removed ( --> val has the computed number
					else if(A2Methods.isanb(A[i])) {
						val.push(A[i]);
					}//insert number
					else {
						A2Methods.repeatOps(val, op, A[i]);
						op.push(A[i]);
					}
					
				}
				pw.println(val.top());
			}
			System.out.println("The program has finished and will now terminate.");
		}
		catch(Exception z) {
			z.printStackTrace();;
		}
		sc.close();
		pw.close();
	}

}
