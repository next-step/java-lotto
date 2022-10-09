package step1;

public class Calculator {
	private String[] formula;
	public Calculator(String input) {
		formula = input.split(" ");
	}

	public String[] getFormula() {
		return formula;
	}
}
