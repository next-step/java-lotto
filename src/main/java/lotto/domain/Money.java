package lotto.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Money {

	private static final String NUMBER_REGEX = "^[1-9]\\d+";
	private static final Pattern PATTERN = Pattern.compile(NUMBER_REGEX);
	private static final String INVALID_NUMBER_MESSAGE = "유효하지 않은 숫자입니다.";

	private final int value;

	Money(String money) {
		validate(money);

		value = Integer.parseInt(money.trim());
	}

	private void validate(String money) {
		if (money == null || money.isEmpty()) {
			throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE);
		}

		Matcher matcher = PATTERN.matcher(money.trim());

		if (!matcher.find()) {
			throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE);
		}
	}

	public int pay(int price) {
		return value / price;
	}

}
