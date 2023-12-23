package calculator.domain;

public final class Multiplication extends Operation {
	public Digit operate(Digit first, Digit second) {
		return first.multiply(second);
	}
}
