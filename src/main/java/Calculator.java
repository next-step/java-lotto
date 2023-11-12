public class Calculator {
	private int result;

	public Calculator() {
		this(0);
	}

	public Calculator(int result) {
		this.result = result;
	}

	public void calculate(String[] inputs) {
		int left = Integer.parseInt(inputs[0]);
		for (int i = 1; i < inputs.length; i += 2) {
			String operator = inputs[i];
			int right = Integer.parseInt(inputs[i+1]);

			this.calculate(left, operator, right);
			left = this.result;
		}
	}

	public void calculate(int left, String operator, int right) {
		this.result = Operator.calculate(left, operator, right);
	}

	public int result() {
		return this.result;
	}
}
