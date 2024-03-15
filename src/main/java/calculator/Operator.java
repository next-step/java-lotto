package calculator;

import calculator.model.ArithmeticEnum;
import calculator.model.ArithmeticStrategy;

public class Operator {
	private final ArithmeticStrategy strategy;

	public Operator(String operator, Integer left, Integer right) {
		ArithmeticEnum arithmeticEnum = ArithmeticEnum.from(operator);
		this.strategy = arithmeticEnum.createStrategy(left, right);
	}

	public Integer execute() {
		return strategy.calculate();
	}
}
