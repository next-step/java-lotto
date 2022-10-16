package step1.controller;

import step1.exception.BlankException;
import step1.model.Calculator;
import step1.view.InputView;
import step1.view.OutputView;

public class CalculatorController {

	private static final OutputView OUTPUT_VIEW = new OutputView();
	private static final InputView INPUT_VIEW = new InputView();
	private static final Calculator CALCULATOR = new Calculator();

	public void stringCalculator() {
		String formula = INPUT_VIEW.askFormula();
		if (formula.isBlank()) {
			throw new BlankException("식을 입력하세요");
		}
		OUTPUT_VIEW.showResult(formula, CALCULATOR.getResult(formula));
	}
}
