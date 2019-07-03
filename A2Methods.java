public class A2Methods {
	public static void doOp(A2Stack ops, A2Stack val) {
		double x = Double.parseDouble(val.pop());
		double y = Double.parseDouble(val.pop());
		String operator = ops.pop();
		String result = compute(operator, y, x).toString();
		val.push(result);
	}
	
	public static void repeatOps(A2Stack val, A2Stack op, String operator) {
		while(val.getsize() > 1 && prec(operator) >= prec(op.top())) {
			doOp(op, val);
		}
	}
	
	public static Object compute(String operator, double a, double b) {
		switch(operator) {
			case "^":
				return Math.pow(a, b);
			case "*":
				return a*b;
			case "/":
				return a/b;
			case "+":
				return a+b;
			case "-":
				return a-b;
			case ">":
				return a > b;
			case "<":
				return a < b;
			case ">=":
				return a >= b;
			case "<=":
				return a <= b;
			case "==":
				return a == b;
			case "!=":
				return a != b;
			default:
				return 0;
		}
	}
	
	public static boolean isanb(String pnb) {
		try {
			Integer.parseInt(pnb);
			return true;
		}
		catch(NumberFormatException b) {
			return false;
		}
	}
	
	public static int prec(String op) {
		switch(op) {
			case "^":
				return 0;
			case "*":
				return 1;
			case "/":
				return 1;
			case "+":
				return 2;
			case "-":
				return 2;
			case "(":
				return 3;
			case ">=":
				return 4;
			case "<=":
				return 4;
			case "==":
				return 4;
			case "!=":
				return 4;
			default:
				return 5;
		}
	}
}
