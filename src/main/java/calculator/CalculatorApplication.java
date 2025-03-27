package calculator;

import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorApplication {
	public static void main(String[] args) {
		Calculator calculator = new Calculator(new InputView(), new OutputView());
		calculator.startCalculation();
	}
}
