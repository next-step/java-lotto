package stringcalculator.domain;

public class StringCalculator {

	private final Number a;
	private final Number b;
	private final Operator operator;

	public StringCalculator(String a, String b, String operator) {
		this.a = new Number(toInt(a));
		this.b = new Number(toInt(b));
		this.operator = new Operator(operator);
	}

	private int toInt(String input) {
		try {
			return Integer.parseInt(input);
		} catch (Exception e) {
			throw new IllegalArgumentException("숫자는 정수만 입력 가능합니다.");
		}
	}

	private String toString(int result) {
		return String.valueOf(result);
	}

	public String calculate() {
		if (this.operator.isPlus()) {
			return this.toString(this.add().getNumber());
		}
		if (this.operator.isMinus()) {
			return this.toString(this.subtract().getNumber());
		}
		if (this.operator.isMultiply()) {
			return this.toString(this.multiply().getNumber());
		}
		return this.toString(this.divide().getNumber());
	}

	public Number add() {
		return new Number(a.getNumber() + b.getNumber());
	}

	public Number subtract() {
		return new Number(a.getNumber() - b.getNumber());
	}

	public Number multiply() {
		return new Number(a.getNumber() * b.getNumber());
	}

	public Number divide() {
		if (b.equals(new Number(0))) {
			throw new IllegalArgumentException("나누려는 숫자는 0일 수 없습니다.");
		}
		return new Number(a.getNumber() / b.getNumber());
	}
}
