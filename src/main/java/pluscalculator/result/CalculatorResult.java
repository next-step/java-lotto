package pluscalculator.result;

public class CalculatorResult {

	private int result;

	private CalculatorResult(int result) {
		this.result = result;
	}

	public static CalculatorResult of(int initValue) {
		return new CalculatorResult(initValue);
	}

	public String viewResult() {
		return String.valueOf(result);
	}
}
