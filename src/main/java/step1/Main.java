package step1;

import step1.controller.CalculatorController;

public class Main {

	public static void main(String[] args) {
		CalculatorController calculatorController = new CalculatorController();
		calculatorController.start();
		calculatorController.calculate();
		calculatorController.end();
	}
}
