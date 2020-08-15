package pluscalculator.util;

import org.apache.commons.lang3.StringUtils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import pluscalculator.argument.CalculatorArguments;
import pluscalculator.argument.Operands;
import pluscalculator.argument.Operator;
import pluscalculator.argument.OperatorType;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InputAnalyzer {

	public static CalculatorArguments analyze(String inputOfUser) {
		if (StringUtils.isBlank(inputOfUser)) {
			return CalculatorArguments.nonValue();
		}

		OperatorType operatorType = OperatorType.getOperatorTypeBy(inputOfUser);
		Operands operands = operatorType.toOperandsFrom(inputOfUser);
		Operator operator = operatorType.getOperator();

		return CalculatorArguments.of(operands, operator);
	}
}
