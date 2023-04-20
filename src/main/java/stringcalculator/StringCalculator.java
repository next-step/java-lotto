package stringcalculator;

public class StringCalculator {

	private final Number a;
	private final Number b;

	public StringCalculator(String a, String b) {
		this.a = new Number(toInt(a));
		this.b = new Number(toInt(b));
	}

	private int toInt(String input) {
		try {
			return Integer.parseInt(input);
		} catch (Exception e) {
			throw new IllegalArgumentException("숫자는 정수만 입력 가능합니다.");
		}
	}

	public Number add() {
		return new Number(a.getNumber() + b.getNumber());
	}

	public Number subtract() {
		return new Number(a.getNumber() - b.getNumber());
	}
}
