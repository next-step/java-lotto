package stringCalculator;

import stringCalculator.domain.Calculator;
import stringCalculator.view.InputView;
import stringCalculator.view.ResultView;

public class StringCalculatorMain {

	public static void main(String[] args) {
		String userInput = InputView.userInput();
		Calculator calculator = new Calculator();
		ResultView.printResult(calculator.calculate(userInput));
	}
}
