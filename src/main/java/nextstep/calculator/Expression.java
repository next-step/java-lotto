package nextstep.calculator;

import java.util.List;

public class Expression {
	private final Number operand;
	private final List<Operation> operations;

	public Expression(Number operand, List<Operation> operations) {
		this.operand = operand;
		this.operations = operations;
	}

	public Number calculate() {
		Number result = operand;
		for (Operation operation : operations) {
			result = operation.calculate(result);
		}
		return result;
	}
}
