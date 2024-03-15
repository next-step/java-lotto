package calculator;

import calculator.model.ArithmeticEnum;
import calculator.model.ArithmeticStrategy;

public class ArithmeticFactory {
	private final ArithmeticStrategy strategy;

	public ArithmeticFactory(String operator, Integer left, Integer right) {
		ArithmeticEnum arithmeticEnum = ArithmeticEnum.from(operator);
		this.strategy = arithmeticEnum.createStrategy(left, right);
	}

	public Integer execute() {
		return strategy.calculate();
	}
}
