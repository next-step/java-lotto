package controller;

import exception.BlankException;
import model.Calculator;
import view.InputView;
import view.OutputView;

public class CalculatorController {

	private static final OutputView OUTPUT_VIEW = new OutputView();
	private static final InputView INPUT_VIEW = new InputView();
	private static final Calculator CALCULATOR = new Calculator();

	public void stringCalculator() {
		String formula = INPUT_VIEW.askFormula();

		if(formula.isEmpty()){
			throw new BlankException("식을 작성해주세요");
		}
		OUTPUT_VIEW.showResult(formula, CALCULATOR.getResult(formula));
	}
}
