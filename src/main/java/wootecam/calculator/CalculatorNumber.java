package wootecam.calculator;

import wootecam.util.StringUtils;

public class CalculatorNumber {

	private static final String NUMERIC_ERROR_MESSAGE = "0이상 정수만 입력 가능합니다.";

	private final String number;

	public CalculatorNumber(String number) {
		if (!StringUtils.isNumeric(number)) {
			throw new RuntimeException(NUMERIC_ERROR_MESSAGE);
		}
		this.number = number;
	}

	public int parseNumber() {
		return Integer.parseInt(this.number);
	}
}
