package calculator;

import java.util.regex.Pattern;

public class Number {

	private static final Pattern pattern = Pattern.compile("^-?\\d+");

	private int number;

	public Number(String stringNumber) {
		if(!isNumber(stringNumber)) {
			throw new IllegalArgumentException("숫자만 입력하세요.");
		}
		if(!isPositive(stringNumber)) {
			throw new IllegalArgumentException("양수만 입력하세요.");
		}
		this.number = Integer.valueOf(stringNumber);
	}

	private boolean isNumber(String stringNumber) {
		return pattern.matcher(stringNumber).matches();
	}

	private boolean isPositive(String stringNumber) {
		return !stringNumber.startsWith("-");
	}

	public int add(int right) {
		return number + right;
	}
}
