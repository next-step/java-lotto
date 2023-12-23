package calculator.domain;

public final class Subtraction extends Operation {
	public Digit operate(Digit first, Digit second) {
		return first.subtract(second);
	}
}
