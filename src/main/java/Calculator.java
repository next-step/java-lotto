public class Calculator {
	private final static Character PLUS = '+';
	private final static Character MINUS = '-';
	private final static Character MULTIPLICATION = '*';
	private final static Character DIVISION = '/';

	private final Character[] operators = {PLUS, MINUS, MULTIPLICATION, DIVISION};
	private int result;

	public Calculator() {
		this(0);
	}

	public Calculator(int result) {
		this.result = result;
	}

	public void calculate(int left, char operator, int right) {
		if(!matches(operator)) {
			throw new IllegalArgumentException("사칙연산 기호를 입력하세요.");
		}

		if(operator == PLUS) {
			result = left + right;
		}

		if(operator == MINUS) {
			result = left - right;
		}

		if(operator == MULTIPLICATION) {
			result = left * right;
		}

		if(operator == DIVISION) {
			result = left / right;
		}
	}

	public int result() {
		return this.result;
	}

	private boolean matches(char inputOperator) {
		for(Character operator : operators) {
			if(operator == inputOperator) {
				return true;
			}
		}

		return false;
	}
}
