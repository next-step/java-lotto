package step1.calculator;

import step1.calculator.domain.Calculator;

public class Application {
	public static void main(String[] args) {
		Calculator calculator = Calculator.create();

		calculator.run();
	}
}
