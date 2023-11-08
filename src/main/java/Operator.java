import java.util.Arrays;

public enum Operator {
	PLUS('+') {
		public int apply(int left, int right) {
			return left + right;
		}
	},
	MINUS('-') {
		public int apply(int left, int right) {
			return left - right;
		}
	},
	MULTIPLICATION('*') {
		public int apply(int left, int right) {
			return left * right;
		}
	},
	DIVISION('/') {
		public int apply(int left, int right) {
			return left / right;
		}
	};

	private final char symbol;

	Operator(char symbol) {
		this.symbol = symbol;
	}

	public char symbol() {
		return this.symbol;
	}

	public static int calculate(int left, char operator, int right) {
		return Operator.fromChar(operator).apply(left, right);
	}

	public static Operator fromChar(char inputOperator) {
		return Arrays.stream(Operator.values())
				.filter(operator -> operator.symbol() == inputOperator)
				.findAny()
				.orElseThrow(() -> new IllegalArgumentException("사칙연산 기호를 입력하세요."));
	}

	abstract int apply(int left, int right);
}
