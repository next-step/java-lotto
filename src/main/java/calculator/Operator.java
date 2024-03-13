package calculator;

import calculator.model.*;

public class Operator {
	private final ArithmeticStrategy strategy;

	public Operator(String operator, Integer left, Integer right) {
		if(operator.equals("+"))
			this.strategy = new Plus(left, right);
		else if(operator.equals("-"))
			this.strategy = new Minus(left, right);
		else if(operator.equals("*"))
			this.strategy = new Multiply(left, right);
		else if(operator.equals("/"))
			this.strategy = new Divide(left, right);
		else
			throw new IllegalArgumentException("사칙 연산 기호가 아닙니다. +, -, *, / 중 하나를 입력하세요.");
	}

	public Integer execute() {
		return strategy.calculate();
	}
}
