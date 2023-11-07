public class Calculator {
	private final static Character PLUS = '+';
	private final static Character MINUS = '-';
	private final static Character MULTIPLICATION = '*';
	private final static Character DIVISION = '/';

	private final Character[] operators = {PLUS, MINUS, MULTIPLICATION, DIVISION};

	public int calculation(int left, char operator, int right) {
		if(!matches(operator)) {
			throw new IllegalArgumentException("사칙연산 기호를 입력하세요.");
		}

		if(operator == PLUS) {
			return left + right;
		}

		if(operator == MINUS) {
			return left - right;
		}

		if(operator == MULTIPLICATION) {
			return left * right;
		}

		if(operator == DIVISION) {
			return left / right;
		}

		return -1;
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
