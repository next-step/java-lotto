package step1;

public class Calculator {
	public int result;
	private final Separator separator;

	public Calculator(String input) {
		separator = new Separator(input);
		validCharacter(validNullOrBlank(), "공백, null 은 입력할 수 없습니다");
		result = Integer.parseInt(separator.getFormula().get(0));
	}

	private int validNumber(String number) {
		if (number.charAt(0) == '-') {
			validCharacter('9' < number.charAt(1) || number.charAt(1) < '1', "문자는 계산할 수 없습니다");
		} else {
			validCharacter('9' < number.charAt(0) || number.charAt(0) < '1', "문자는 계산할 수 없습니다");
		}
		return Integer.parseInt(number);
	}

	private void validCharacter(boolean number, String message) {
		if (number) {
			throw new IllegalArgumentException(message);
		}
	}

	private boolean validNullOrBlank() {
		return separator.getFormula().get(0).isBlank() || separator.getFormula().get(0).isEmpty();
	}

	public int start() {
		System.out.println(separator.getFormula());
		for (int i = 1; i <= separator.getFormula().size() - 2; i += 2) {
			calculate(separator.getFormula().get(i), separator.getFormula().get(i + 1));
		}
		return result;
	}

	private void calculate(String sign, String number) {
		if (sign.equals("+")) {
			this.result += validNumber(number);
		}
		if (sign.equals("-")) {
			this.result -= validNumber(number);
		}
		if (sign.equals("*")) {
			this.result *= validNumber(number);
		}
		if (sign.equals("/")) {
			this.result /= validNumber(number);
		}
	}
}
