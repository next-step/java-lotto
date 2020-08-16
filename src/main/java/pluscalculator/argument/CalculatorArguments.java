package pluscalculator.argument;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@AllArgsConstructor(staticName = "of")
public class CalculatorArguments {
	private static final CalculatorArguments NON_VALUE = new CalculatorArguments(Operands.zero(), Operator.NONE);

	private final Operands operands;
	private final Operator operator;

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
