package step1.controller;

import java.util.List;

import step1.model.number.Number;
import step1.model.number.Numbers;
import step1.model.operator.Operators;
import step1.view.InputView;
import step1.view.OutputView;

public class CalculatorController {
	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();

	private Numbers numbers = new Numbers();
	private Operators operators = new Operators();
	private Number result;

	public void start() {
		List<String> inputs = inputView.getInput();

		numbers = numbers.convertToNumbers(inputs);
		operators = operators.convertToOperators(inputs);
	}

	public void calculate() {
		result = numbers.get(0);

		operators.forEach(
			operator -> operator.operate(numbers.get(operators.indexOf(operator) + 1).getValue(), result)
		);
	}

	public void end() {
		outputView.printResult(result.getValue());
	}
}
