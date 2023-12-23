package calculator.domain;

public final class Multiplication extends Operation {
	public Digit operate(Digit digit1, Digit digit2) {
		return new Digit(digit1.digit() * digit2.digit());
	}
}
