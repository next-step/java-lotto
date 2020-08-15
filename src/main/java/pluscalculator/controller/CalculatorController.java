package pluscalculator.controller;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import pluscalculator.argument.CalculatorArguments;
import pluscalculator.calculator.StringCalculator;
import pluscalculator.input.InputView;
import pluscalculator.output.OutputView;
import pluscalculator.result.CalculatorResult;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CalculatorController {

	public static void execute() {
		CalculatorArguments arguments = InputView.input();
		CalculatorResult result = StringCalculator.calculate(arguments);
		OutputView.output(result);
	}
}
