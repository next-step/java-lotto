package calculator.domain;

import java.util.List;

public class Calculator {
	private final List<Operand> operands;
	private final List<Operator> operators;

	public Calculator(List<Operand> operands, List<Operator> operators) {
		this.operands = List.copyOf(operands);
		this.operators = List.copyOf(operators);
	}

	public int calculateOutput() {
		int result = operands.get(0)
			.getNumber();
		for (int i = 0; i < operators.size(); i++) {
			Operator operator = operators.get(i);
			result = operator.apply(result, operands.get(i + 1)
				.getNumber());
		}
		return result;
	}

}
