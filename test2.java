import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.EOFException;

public class test2 {

	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner sc = new Scanner(System.in);
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		long id;
		String courseName, firstName, lastName, jk, s;
		char ch1, ch2, ch3;

		try {
			ois = new ObjectInputStream(new FileInputStream("test_registeration.dat"));
			oos = new ObjectOutputStream(new FileOutputStream("real_registeration.dat"));
			try
			{
				s = ois.readUTF();		// Reads the first line of the file and display it
				System.out.println(s);
				while(true)			
				{
					// read the id, the two tabs, the first name, the space, then the last name
				
					id = ois.readLong();
					ch1 = ois.readChar();				// Read the two tabs 
					ch2 = ois.readChar();
					firstName = ois.readUTF();		
					ch3 = ois.readChar();				// Read the space between the names
					lastName = ois.readUTF();
				
					System.out.println("" + id + ch1 + ch2 + firstName + ch3 + lastName);
				}
			}
			catch(EOFException e)
			{
				System.out.println("Reading test_registeration has been completed.");
			}
			ois.close();

		}
		catch(FileNotFoundException b) {
			System.out.println("The file could not be found.");
			System.exit(0);
		}
		catch(IOException a){
			System.out.println("There was a problem in the IO of this program.");
			System.exit(0);
		}
		sc.close();
		ois.close();
		oos.close();
	}

	
}
