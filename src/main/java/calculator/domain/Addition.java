package calculator.domain;

public final class Addition extends Operation {
	public Digit operate(final Digit digit1, final Digit digit2) {
		return new Digit(digit1.digit() + digit2.digit());
	}
}
