package pluscalculator.argument;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class CalculatorArguments {
	private final Operands operands;
	private final Operator operator;
	private static final CalculatorArguments NON_VALUE = new CalculatorArguments(Operands.zero(), Operator.NONE);

	public static final CalculatorArguments nonValue() {
		return NON_VALUE;
	}

	public boolean hasNextOperand() {
		return operands.hasNext();
	}

	public int nextOperand() {
		return operands.next();
	}

	public int getFirst() {
		return operands.getFirst();
	}

	public Operator getOperator() {
		return this.operator;
	}

	public static CalculatorArguments from(String inputOfUser) {
		if (StringUtils.isBlank(inputOfUser)) {
			return CalculatorArguments.nonValue();
		}

		OperatorType operatorType = OperatorType.getOperatorTypeBy(inputOfUser);
		Operands operands = operatorType.toOperandsFrom(inputOfUser);
		Operator operator = operatorType.getOperator();

		return CalculatorArguments.of(operands, operator);
	}
}
