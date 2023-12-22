package calculator.domain;

public class Multiplication extends Operation {
	public Digit operate(Digit digit1, Digit digit2) {
		return new Digit(digit1.number() * digit2.number());
	}
}
