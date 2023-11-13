package calculator.operator;

import calculator.operator.Operator;

public class Multiply implements Operator {
	@Override
	public int calculate(int a, int b) {
		return a * b;
	}
}
