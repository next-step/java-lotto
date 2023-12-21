package calculator.controller;

import calculator.domain.Number;

public class Addition {
	public Number plus(Number number1, Number number2){
		return new Number(number1.number() + number2.number());
	}
}
