package Assignment2.First;
import Assignment2.Second.*;
import Assignment2.Third.*;
import Assignment2.Fourth.*;
import Assignment2.Fourth.AirCraft.tclass;
import Assignment2.Fourth.AirCraft.tmaintenance;
/* -----------------------------------------------------
* Assignment: 2
* Written by: Jason Kim 40097242
* Due: 11:59 PM – Friday, February 24, 2019
----------------------------------------------------- */
/**
 * Driver class
 * @author Jason's Laptop
 *
 */
public class Driver {
	/**
	 * Finding cheapest and most expensive indexes
	 * @param mix: input PublicTransportation array
	 * @return String expressing the cheapest and most expensive ticket index and value of the classes
	 */
	public static String trace(PublicTransportation[] mix) {
		int cheapest = 0;
		int ouch = 0;
		//Find cheapest
		for(int i = 0; i < mix.length ; i++) {
			if (mix[cheapest].getTicketPrice() > mix[i].getTicketPrice()) {
				cheapest = i;
			}
			if(mix[ouch].getTicketPrice() < mix[i].getTicketPrice()) {
				ouch = i;
			}
		}
		return "\nHere is the object with the cheapest ticket.\n" + mix[cheapest] + "It is located on the index number " + cheapest +".\n\nHere is the object with the most expensive ticket.\n" + mix[ouch] + "\nIt is located on the index number " + ouch + ".";
	}
	/**
	 * copying all instances of City Bus into an output array
	 * @param other: input PublicTransportation array
	 * @return PublicTransportation array with only instances of City Bus
	 */
	public static PublicTransportation[] copyCityBus(PublicTransportation[] other) {
		PublicTransportation[] arr = new PublicTransportation[other.length];
		for(int i = 0; i < other.length; i++) {
			if(other[i] instanceof CityBus) {
				arr[i] = new CityBus((CityBus)other[i]);
			}
			else
				arr[i] = null;
		}
		return arr;
	}
	/**
	 * Driver class
	 * @param args
	 */
	public static void main(String[] args) {
		//array
		PublicTransportation[] array = new PublicTransportation[15];
		array[0] = new PublicTransportation();
		array[1] = new CityBus();
		array[2] = new Metro();
		array[3] = new Tram();
		array[4] = new Ferry();
		array[5] = new AirCraft();
		
		array[6] = new PublicTransportation(2.50, 5);
		array[7] = new CityBus(3.25, 7, 138, 2015, "Sherbrooke/Decarie", "Samuel");
		array[8] = new Metro(5.75, 15, 98, 2000, "Blue", "James", 3, "Montreal");
		array[9] = new Tram(4.30, 4, 3, 1986, "Bleurie", "Jacques", 40);
		array[10] = new Ferry(20, 3, 1974, "Mocking Bird II");
		array[11] = new AirCraft(500, 2, tclass.Helicopter, tmaintenance.Monthly);
		
		array[12] = new CityBus((CityBus) array[1]);
		array[13] = new Tram((Tram) array[3]);
		array[14] = new Ferry((Ferry) array[4]);
		
		//toSting methods
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i] + "\n");
		}
		
		//equals methods
		System.out.println("Public Transportation Default Vs. City Bus Default: " + array[0].equals(array[1]));
		System.out.println("City Bus Default Vs. Public Transportation Default: " + array[1].equals(array[0]));
		System.out.println("City Bus Default Vs. City Bus Copy: " + array[1].equals(array[12]));
		System.out.println("City Bus Default  Vs. City Bus Parametrized: " + array[1].equals(array[7]));
		System.out.println("Metro Default Vs. Tram Default: " + array[2].equals(array[3]));
		System.out.println("Metro Default Vs. Metro Parametrized: " + array[2].equals(array[8]));
		System.out.println("Tram Default Vs. Tram Parametrized: " + array[3].equals(array[9]));
		System.out.println("Tram Default Vs. Tram Copy: " + array[3].equals(array[13]));
		System.out.println("Ferry Default Vs. Ferry Copy: " + array[4].equals(array[14]));
		System.out.println("AirCraft Default Vs. AirCraft Parametrized: " + array[4].equals(array[14]));
		
		System.out.println("\n" +trace(array));
		System.out.println("-----------------------------------------Pt 2----------------------------------------------\n");
		PublicTransportation[] two = new PublicTransportation[12];
		two[0] = new PublicTransportation();
		two[1] = new CityBus();
		two[2] = new Metro();
		two[3] = new Tram();
		two[4] = new Ferry();
		two[5] = new AirCraft();
		
		two[6] = new PublicTransportation(2.50, 5);
		two[7] = new CityBus(3.25, 7, 138, 2015, "Sherbrooke/Decarie", "Samuel");
		two[8] = new Metro(5.75, 15, 98, 2000, "Blue", "James", 3, "Montreal");
		two[9] = new Tram(4.30, 4, 3, 1986, "Bleurie", "Jacques", 40);
		two[10] = new Ferry(20, 3, 1974, "Mocking Bird II");
		two[11] = new AirCraft(500, 2, tclass.Helicopter, tmaintenance.Monthly);
		
		PublicTransportation[] copied = copyCityBus(two);
		//print methods
		System.out.println("\n\n------------------------------Original------------------------------");
		for(int i = 0; i < two.length; i++) {
			System.out.println(two[i] + "\n");
		}
		System.out.println("\n\n------------------------------Copied------------------------------");
		for(int i = 0; i < copied.length; i++) {
			System.out.println(copied[i] + "\n");
		}
		//All the expected results were output. The instructions demanded for all City Buses to be copied into the copied array, so since the Metro and Tram
		//classes can be considered to be a City Bus, I made the copyCityBus method copy all instances of the CityBus and made whatever is not an instance
		//of City Bus to be null. Therefore, when I printed the copied array, it printed all of my instances normally and those that are not as null.
		CityBus a = new CityBus();
		
		System.out.println(a.getClass().toString().substring(0,4));

		
	}

}
