package calculator.controller;

import calculator.model.Calculator;
import calculator.view.CalculatorInputView;
import calculator.view.CalculatorOutputView;

public class CalculatorController {

	public static void main(String[] args) {
		CalculatorInputView calculatorInputView = new CalculatorInputView();
		String inputValue = calculatorInputView.requestView();

		Calculator calculator = Calculator.createCalculator(inputValue);

		CalculatorOutputView calculatorOutputView = new CalculatorOutputView();
		calculatorOutputView.calculateResultView(calculator.calculate());

	}
}
