package calculator;

public class StringAddCalculator {
	public static int splitAndSum(String calculatorInput) {
		CalculatorContext context = new CalculatorContext(calculatorInput);
		return context.expression().resultNumber(context.delimiter()).ToInteger();
	}
}
