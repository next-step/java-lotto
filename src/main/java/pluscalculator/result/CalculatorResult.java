package pluscalculator.result;

import pluscalculator.argument.Operator;

public class CalculatorResult {

	private int result;

	private CalculatorResult(int result) {
		this.result = result;
	}

	public static CalculatorResult init(int initValue) {
		return new CalculatorResult(initValue);
	}

	public void nextResult(Operator operator, int operand2) {
		result = operator.calculate(result, operand2);
	}

	public String viewResult() {
		return String.valueOf(result);
	}
}
