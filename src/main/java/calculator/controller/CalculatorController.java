package calculator.controller;

import calculator.model.Calculator;
import calculator.model.Characters;
import calculator.view.CalculatorInputView;
import calculator.view.CalculatorOutputView;

public class CalculatorController {

	public static void main(String[] args) {
		String inputValue = CalculatorInputView.requestView();

		Calculator calculator = new Calculator();
		Characters characters = calculator.createCharacters(inputValue);
		CalculatorOutputView.calculateResultView(calculator.calculate(characters));

	}
}
