package calculator.domain;

import java.util.Arrays;

public enum Operator {
	PLUS("+") {
		public Digit operate(Digit first, Digit second) {
			return first.add(second);
		}
	},
	MINUS("-") {
		public Digit operate(Digit first, Digit second) {
			return first.subtract(second);
		}
	},
	MULTIPLICATION("*") {
		public Digit operate(Digit first, Digit second) {
			return first.multiply(second);
		}
	},
	DIVISION("/") {
		public Digit operate(Digit first, Digit second) {
			return first.divide(second);
		}
	};

	private final String value;

	Operator(String operator) {
		value = operator;
	}

	public abstract Digit operate(Digit first, Digit second);

	public static Operator find(String letter) {
		return Arrays.stream(Operator.values()).filter(operator -> operator.value.equals(letter))
			.findFirst()
			.orElseThrow( () -> new IllegalArgumentException("Need correct arithmetic operator"));
	}
}
