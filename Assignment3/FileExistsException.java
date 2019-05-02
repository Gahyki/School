package Assignment3;

/* -----------------------------------------------------
* Assignment: 3
* Written by: Jason Kim 40097242
* Due: 11:59 PM – Sunday, March 17, 2019
----------------------------------------------------- */
/**
 * 
 * @author Jason Kim 40097242
 * @COMP249
 * @Assignment #3
 * @Due Date 03/24/2019
 */
public class FileExistsException extends Exception {
	/**
	 * default constructor for file exists exception
	 */
	public FileExistsException() {
		super("Exception: There is already an existing file for that author. File will be renamed as BU, and older BU files will be deleted!");
	}
	/**
	 * parameterized constructor
	 * @param s - string message
	 */
	public FileExistsException(String s) {
		super(s);
	}
	/**
	 * method to get the message to output
	 */
	public String getMessage() {
		return super.getMessage();
	}
}
