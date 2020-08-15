package pluscalculator.calculator;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import pluscalculator.argument.CalculatorArguments;
import pluscalculator.result.CalculatorResult;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StringCalculator {

	public static CalculatorResult calculate(CalculatorArguments arguments) {
		CalculatorResult result = CalculatorResult.init(arguments.getFirst());

		while (arguments.hasNextOperand()) {
			result.nextResult(arguments.getOperator(), arguments.nextOperand());
		}

		return result;
	}
}
