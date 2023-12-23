package calculator.domain;

public final class Subtraction extends Operation {
	public Digit operate(Digit first, Digit second) {
		return new Digit(first.digit() - second.digit());
	}
}
