package calculator;

public class CalculatorApplication {

	public static void main(String[] args) {
		Input input = new Input();
		Output output = new Output();
		Calculator calculator = new Calculator();

		String formulaStr = input.inputFormulaStr();

		int result = calculator.calculate(new Formula(formulaStr));

		output.showResult(result);
	}

}
