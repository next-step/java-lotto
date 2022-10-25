package step1.controller;

import step1.model.Calculator;
import step1.model.Operations;

public class CalculatorController {

	private static final String NUMBER_PATTERN = "[0-9]";
	private static final String OPERATOR_PATTERN = "[+\\-*/]";

	private final Operations operations;

	public CalculatorController(final String input) {
		this.operations = new Operations(input);
	}

	public int calculating() {
		String[] operations = this.operations.getOperations();
		int result = checkNumberStatus(operations[0]);
		Calculator calculator = new Calculator();
		for (int i = 1; i < operations.length; i += 2) {
			calculator.init(checkOperatorStatus(operations[i]));
			result = calculator.calculate(result, checkNumberStatus(operations[i + 1]));
		}
		return result;
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
