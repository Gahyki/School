
public class A2Stack {
	private String[] st;
	private int size;
	public A2Stack() {
		st =  new String[5];
		size = 0;
	}
	public void push(String a) {
		if (size == st.length) {
			String[] temp = new String[size+5];
			for(int i = 0; i < st.length; i++) {
				temp[i] = st[i];
			}
			st = temp;
		}
		st[size] = a;
		size++;
	}
	public String pop() {
		if(size != 0) {
			String temp = st[size-1];
			st[size-1] = null;
			size--;
			return temp;
		}
		else {
			return "There are no elements in the stack.";
		}
	}
	public int getsize() {
		return size;
	}
	public String top() {
		if(size > 0)
			return st[size-1];
		else
			return "";
	}
	public String toString() {
		String value = "";
		for(int i = 0; i < size; i++) {
			value += st[i] + " ";
		}
		return value;
	}
	
}
