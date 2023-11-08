public class Calculator {
	private int result;

	public Calculator() {
		this(0);
	}

	public Calculator(int result) {
		this.result = result;
	}

	public void calculate(int left, char operator, int right) {
		this.result = Operator.calculate(left, operator, right);
	}

	public int result() {
		return this.result;
	}
}
