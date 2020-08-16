package pluscalculator.calculator;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import pluscalculator.argument.CalculatorArguments;
import pluscalculator.result.CalculatorResult;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StringCalculator {

	public static CalculatorResult calculate(CalculatorArguments arguments) {
		int result = arguments.getFirst();

		while (arguments.hasNextOperand()) {
			result += arguments.getOperator().calculate(result, arguments.nextOperand());
		}

		return CalculatorResult.of(result);
	}
}
