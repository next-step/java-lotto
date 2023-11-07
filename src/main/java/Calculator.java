public class Calculator {
	public int calculation(int left, char c, int right) {
		if(c == '+') {
			return left + right;
		}

		if(c == '-') {
			return left - right;
		}

		if(c == '*') {
			return left * right;
		}

		if(c == '/') {
			return left / right;
		}

		throw new IllegalArgumentException("사칙연산 기호를 입력하세요.");
	}
}
