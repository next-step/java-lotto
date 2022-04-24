package calculator;

import util.Parser;

public class Calculator {
	private int sum;
	private Operator activeOperator;

	public Calculator() {
		this(Operator.PLUS);
	}

	public Calculator(Operator activeOperator) {
		this.activeOperator = activeOperator;
	}

	public int calculate(String formula) {
		validateFormula(formula);
		for (String value : formula.split(" ")) {
			add(value);
		}
		return sum;
	}

	public boolean isNumber(String value) {
		try {
			Parser.toInt(value);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private boolean isCalculatorOperator(String value) {
		return Operator.containCode(value);
	}

	public int add(String value) {
		validateValue(value);
		if (isNumber(value)) {
			sum = activeOperator.calculate(sum, Parser.toInt(value));
		} else if (isCalculatorOperator(value)) {
			setOperator(value);
		}
		return sum;
	}

	private void validateFormula(String formula) {
		if (formula == null || formula.isBlank()) {
			throw new IllegalArgumentException();
		}
	}

	private void validateValue(String value) {
		if (!isNumber(value) && !isCalculatorOperator(value)) {
			throw new IllegalArgumentException("숫자와 사칙연산 연사자만 입력 가능합니다. [value=" + value + "]");
		}
	}

	private void setOperator(String value) {
		activeOperator = Operator.valueOfCode(value);
	}

}
