package calculator;

import calculator.model.*;

import static calculator.model.ArithmeticEnum.*;

public class Operator {
	private final ArithmeticStrategy strategy;

	public Operator(String operator, Integer left, Integer right) {
		if(PLUS.getOperator().equals(operator)){
			this.strategy = new Plus(left, right);
			return;
		}

		if(MINUS.getOperator().equals(operator)){
			this.strategy = new Minus(left, right);
			return;
		}

		if(MULTIPLY.getOperator().equals(operator)){
			this.strategy = new Multiply(left, right);
			return;
		}

		if(DIVIDE.getOperator().equals(operator)){
			this.strategy = new Divide(left, right);
			return;
		}

		throw new IllegalArgumentException("사칙 연산 기호가 아닙니다.");
	}

	public Integer execute() {
		return strategy.calculate();
	}
}
