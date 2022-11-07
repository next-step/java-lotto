package nextstep.calculator;

public class Operation {
	private final Operator operator;
	private final Number operand;

	public Operation(Operator operator, Number operand) {
		this.operator = operator;
		this.operand = operand;
	}

	public Operation(final String operator, final String operand) {
		this(Operator.of(operator), new Number(operand));
	}

	public Number calculate(Number operand) {
		return operator.calculate(operand, this.operand);
	}
}
