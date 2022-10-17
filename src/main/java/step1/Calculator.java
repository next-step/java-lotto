package step1;

public class Calculator {
	private int result;
	private final Separator separator;

	public Calculator(String input) {
		Separator separator = new Separator(input);
		result = separator.getTerm();
		this.separator = separator;
	}

	public int start() {
		for (int i = 0; i < separator.getSigns().size(); i++) {
			calculate(separator.getSignTerm(i), separator.getTerm(i + 1));
		}
		return result;
	}

	private void calculate(String sign, int number) {
		this.result = Sign.result(sign, this.result, number);
	}

	public int getResult() {
		return result;
	}
}
