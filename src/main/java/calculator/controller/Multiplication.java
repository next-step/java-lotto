package calculator.controller;

import calculator.domain.Number;

public class Multiplication {
	public Number multiply(Number number1, Number number2) {
		return new Number(number1.number() * number2.number());
	}
}
