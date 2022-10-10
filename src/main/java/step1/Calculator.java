package step1;

public class Calculator {
	private int result;
	private final Separator separator;

	public Calculator(String input) {
		Separator separator = new Separator(input);
		result = Validator.validateNumber(separator.getTerm());
		this.separator = separator;
	}

	public int start() {
		for (int i = 1; i <= separator.getFormula().size() - 2; i += 2) {
			calculate(Validator.validateSign(separator.getSignTerm(i)),
				Validator.validateNumber(separator.getTerm(i + 1)));
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
