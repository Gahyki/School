package Assignment4;
import java.util.NoSuchElementException;

//-----------------------------------------------------
//Assignment 4
//Question: 2
//Written by: Gang Hyun Kim, 40097242
//-----------------------------------------------------
/**
 * CellList class
 * COMP249
 * Assignment 4
 * April 8, 2019
 * @author Jason Kim, 40097242
 */
public class CellList {
	//Attributes
	private CellNode head;
	private int size = 0;
	
	//CellNode
	/**
	 * CellNode class
	 * @author Jason Kim, 40097242
	 *
	 */
	public class CellNode {
		private CellPhone phone;
		private CellNode next;
		
		public CellNode() {
			phone = null;
			next = null;
		}
		/**
		 * Parameterized constructor
		 * @param p: CellPhone object
		 * @param n: next CellNode in the CellList
		 */
		public CellNode(CellPhone p, CellNode n) {
			phone = p;
			next = n;
		}
		/**
		 * Copy constructor
		 * @param other: CellNode object to be copied
		 */
		public CellNode(CellNode other) {
			phone = other.getphone();
			next = other.getnext();
		}
		/**
		 * Method to access next CellNode
		 * @return CellNode object
		 */
		public CellNode getnext() {
			return next;
		}
		/**
		 * Method to access the CellPhone object
		 * @return CellPhone object
		 */
		public CellPhone getphone() {
			return phone;
		}
		/**
		 * Method to set another CellNode object as the next CellNode in CellList
		 * @param other: New CellNode object
		 */
		public void setnext(CellNode other) {
			next = other;
		}
		/**
		 * Method to set another CellPhone object
		 * @param other: New CellPhone object
		 */
		public void setphone(CellPhone other) {
			phone = other;
		}
		/**
		 * Clone method
		 * @return CellNode
		 */
		public CellNode clone() {
			int x = 300000; //Serial number starting from 300000 are clones
			CellNode cl = new CellNode(this.getphone().clone(x), null);
			x++;
			return cl;
		}
		
	}
	
	//Constructors
	/**
	 * Default CellList constructor
	 */
	public CellList() {
		head = null;
	}
	/**
	 * Copy CellList constructor
	 * @param other: CellList object to be copied
	 */
	public CellList(CellList other) {
		size = other.getsize();
		CellNode t1, t2 ,t3;
		t1 = other.head;
		t2 = head;
		int sncounter = 0;
		if(t1 != null) {
			for(int i = 0; i < size; i++) {
				if((t1 != null)&&(head == null)){
					t3 = new CellNode(t1.getphone().clone(700000 + sncounter), null);
					sncounter++;
					head = t3;
					t2 = t3;
					t1 = t1.next;
				}
				else {
					t3 = new CellNode(t1.getphone().clone(700000 + sncounter), null);
					sncounter++;
					t2.next = t3;
					t2 = t2.next;
					t1 = t1.next;
				}
			}
			
		}
	}	
	public CellNode gethead() {
		return head;
	}
	public int getsize() {
		return size;
	}
	/**
	 * Method to add a new CellPhone object in front at the beginning of the list
	 * @param other: New CellPhone object to add
	 */
	public void addToStart(CellPhone other) {
		if(head == null) {
			CellNode node = new CellNode(other, null);
			head = node;
			size++;
		}
		else {
			if(!(contains(other.getserialnum()))) {
				CellNode node = new CellNode(other, head);
				head = node;
				size++;
			}
		}
	}
	/**
	 * Method to insert a new CellPhone object at an indicated index
	 * @param p: New CellPhone object
	 * @param ind: index to insert the new object
	 * @throws NoSuchElementException: Exception to throw if the indicated index does not exist in the CellList
	 */
	public void insertAtIndex(CellPhone p, int ind) throws NoSuchElementException {
		if(ind == 0) {
			if(!(contains(p.getserialnum()))) {
				CellNode node = new CellNode(p, head);
				head = node;
				size++;
			}
		}		
		else if((0 < ind)&&(ind < (size - 1))) {
			CellNode t = head;
			for(int i = 0; i < (ind - 1); i++)
				t = t.next;
			if(!(contains(p.getserialnum()))) {
				CellNode node = new CellNode(p, t.next);
				t.next = node;
				size++;
			}
		}
		else
			throw new NoSuchElementException();
	}
	/**
	 * Method to delete a CellPhone(or CellNode) object at an indicated index
	 * @param ind: index to remove the element
	 * @throws NoSuchElementException: Exception to throw when the indicated index does not exist in the CellList
	 */
	public void deleteFromIndex(int ind) throws NoSuchElementException {
		if(head == null)
			throw new NoSuchElementException();
		else if (ind == 0) {
			head = head.next;
			size--;
		}
		else{
			CellNode t = head;
			for(int i = 0; i < (ind - 1); i++)
				t = t.next;
			t.next = t.next.next;
			size--;
		}
	}
	/**
	 * Method to delete the first element of the CellList
	 * @throws NoSuchElementException: Exception to throw of there are no elements in the CellList
	 */
	public void deleteFromStart()throws NoSuchElementException {
		if(head == null)
			throw new NoSuchElementException();
		else if(head.next == null) {
			head = null;
			size--;
		}
		else {
			head = head.next;
			size--;
		}		
	}
	public void replaceAtIndex(CellPhone p, int ind) {
		CellNode c = head;
		boolean check = false;
		if(head != null) {
			for(int i = 0; i < size; i++) {
				if(c.phone.getserialnum() == p.getserialnum())
					if(i != ind)
						check = true;		
				c = c.next;
			}
		}
		else
			System.out.println("The list is empty, therefore, there is nothing to be replaced.");
		if(!check) {
			CellNode t = head;
			if(ind == 0) {
				CellNode node = new CellNode(p, t.next);
				head = node;
			}
			else if ((ind > 0)&&(ind < size)){
				for(int i = 0; i < (ind - 1); i++)
					t = t.next;
				CellNode node = new CellNode(p, t.next.next);
				t.next = node;
			}
		}
		else if ((head != null)&&(check)){
			System.out.println("The element already exists, therefore, it cannot be replaced.");
		}
	}
	/**
	 * Method to find the CellPhone object in the CellList
	 * @param nb: the serial number of the phone you want to find
	 * @return: null if the object does not exist in the CellList and returns the toString method of the CellPhone if the CellPhone is found
	 */
	/*
	 * Can cause a privacy leak due to the fact that it returns a node.
	 * This allows anyone to be able to take a node from the list and modify the list according to their needs.
	 * To avoid them, the find method must be private or the node class itself should become private.
	 */
	public CellNode find(long nb) {
		if(head == null)
			return null;
		else {
			CellNode t = head;
			if(head.phone.getserialnum() == nb)
				return t;
			for(int i = 0; i < (size - 1); i++) {
				t = t.next;
				if(t.phone.getserialnum() == nb)
					return t;
			}
			return null;
		}
	}
	/**
	 * Method to find if an element exists in the CellList
	 * @param nb: the serial number of the CellPhone that is being searched
	 * @return: returns true if the element exists and false if it does not
	 */
	public boolean contains(long nb) {
		if(head == null)
			return false;
		else {
			CellNode t = head;
			if(head.phone.getserialnum() == nb)
				return true;
			for(int i = 0; i < (size - 1); i++) {
				t = t.next;
				if(t.phone.getserialnum() == nb)
					return true;
			}
			return false;
		}
	}
	/**
	 * Method to show all CellPhone objects that are contained in the CellList object
	 * @return: a String of all the information of every CellPhone object
	 */
	public String showContents() {
		String msg = "The current size of the list is " + size + ". Here are the contents of the list\n" + "==========================================================================\n";
		if((head != null)&&(size > 1)) {
			int three_c = 1;
			CellNode t = head;
			msg += "{" + t.phone + "} ---> ";
			t = t.next;
			for(int i = 0; i < (size - 1); i++) {
				if(t.next != null) {
					msg += "{" + t.phone + "} ---> ";
					three_c++;
					if(three_c == 3) {
						msg += "\n";
						three_c = 0;
					}
				}
				else {
					msg += "{" + t.phone + "} ---> X";
					three_c++;
				}	
				t = t.next;
			}
		}
		else if(size == 1) {
			msg += "{" + head.phone + "} ---> X";
		}
		else
			msg += "X";
		return msg;
	}
	/**
	 * Method to compare if two CellList are equal to each other
	 * @param other: The other CellList object to compare to
	 * @return: returns true if the they are equal and false if they are not equal
	 */
	public boolean equals(CellList other) {
		if(size == other.size) {
			CellNode t = head;
			CellNode s = other.head;
			if(!(t.phone.equals(s.phone)))
				return false;
			for(int i = 0; i < (size - 1); i++) {
				t = t.next;
				s = s.next;
				if(!(t.phone.equals(s.phone)))
					return false;
			}
			return true;
		}
		return false;
	}
	/**
	 * Method to make a deep copy of all elements of the CellList
	 */
	public CellList clone() {
		CellNode t1, t2 ,t3;
		t1 = head;
		CellList L = new CellList();
		t2 = L.head;
		int sncounter = 0;
		if(t1 == null) {
			return L;
		}
		for(int i = 0; i < size; i++) {
			if((t1 != null)&&(L.gethead() == null)) {
				t3 = new CellNode(t1.getphone().clone(200000 + sncounter), null);
				sncounter++;
				L.head = t3;
				L.size++;
				t2 = t3;
				t1 = t1.next;
			}
			else {
				t3 = new CellNode(t1.getphone().clone(200000 + sncounter), null);
				sncounter++;
				t2.next = t3;
				L.size++;
				t2 = t2.next;
				t1 = t1.next;
			}
		}
		return L;
	}
}


