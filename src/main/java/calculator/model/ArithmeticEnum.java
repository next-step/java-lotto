package calculator.model;

import java.util.Arrays;

public enum ArithmeticEnum {
	DIVIDE("/") {
		@Override
		public ArithmeticStrategy createStrategy(final Integer left, final Integer right) {
			return new Divide(left, right);
		}
	},
	MULTIPLY("*") {
		@Override
		public ArithmeticStrategy createStrategy(final Integer left, final Integer right) {
			return new Multiply(left, right);
		}
	},
	PLUS("+") {
		@Override
		public ArithmeticStrategy createStrategy(final Integer left, final Integer right) {
			return new Plus(left, right);
		}
	},
	MINUS("-") {
		@Override
		public ArithmeticStrategy createStrategy(final Integer left, final Integer right) {
			return new Minus(left, right);
		}
	};

	private final String operator;

	public abstract ArithmeticStrategy createStrategy(Integer left, Integer right);

	ArithmeticEnum(String operator) {
		this.operator = operator;
	}

	public static ArithmeticEnum from(final String operator) {
		return Arrays.stream(ArithmeticEnum.values())
				.filter(arithmeticEnum -> arithmeticEnum.operator.equals(operator))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("사칙 연산 기호가 아닙니다."));
	}
}
