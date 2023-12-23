package calculator.domain;

public final class Division extends Operation {
	public Digit operate(Digit first, Digit second) {
		return first.divide(second);
	}
}
