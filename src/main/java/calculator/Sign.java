package calculator;

import java.util.regex.Pattern;

public class Sign {
	String sign;

	public Sign(String sign) {
		validate(sign);
		this.sign = sign;
	}

	private void validate(String sign) {
		if (!Pattern.matches("[+\\-*/]", sign)) {
			throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
		}
	}

	public boolean isPlusSign() {
		return sign.equals("+");
	}

	public boolean isMinusSign() {
		return sign.equals("-");
	}

	public boolean isMultiplicationSign() {
		return sign.equals("*");
	}

	public boolean isDivisionSign() {
		return sign.equals("/");
	}
}
