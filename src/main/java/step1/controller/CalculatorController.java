package step1.controller;

import step1.model.Calculator;
import step1.model.Operator;

import java.util.stream.IntStream;

public class CalculatorController {

	private static final String NUMBER_PATTERN = "[0-9]";
	private static final String OPERATOR_PATTERN = "[+\\-*/]";

	private final Operator operator;

	public CalculatorController(final String input) {
		this.operator = new Operator(input);
	}

	public int calculating() {
		String[] operations = operator.getOperations();
		Calculator calculator = Calculator.init(checkNumberStatus(operations[0]));
		IntStream.iterate(1, i -> i < operations.length, i -> i + 2).forEachOrdered(i -> {
			calculator.calculate(checkOperatorStatus(operations[i]), checkNumberStatus(operations[i + 1]));
		});
		return calculator.getResult();
	}

	private int checkNumberStatus(String number) {
		if (!number.matches(NUMBER_PATTERN)) throw new IllegalArgumentException("숫자가 아닌 다른 문자가 입력되어있습니다.");
		return Integer.parseInt(number);
	}

	private String checkOperatorStatus(String operator) {
		if (!operator.matches(OPERATOR_PATTERN)) throw new IllegalArgumentException("연산자가 아닌 다른 문자가 입력되어있습니다.");
		return operator;
	}
}
