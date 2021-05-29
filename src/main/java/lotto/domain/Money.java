package lotto.domain;

import static lotto.domain.LottoMachine.*;
import static lotto.util.ValidationUtils.*;

import java.util.Objects;
import java.util.Optional;

public class Money {

	private static final String INVALID_NUMBER_MESSAGE = "숫자만 입력할 수 있습니다.";
	private static final String NOT_ENOUGH_MONEY_MESSAGE = String.format("로또는 한 장에 %s 원입니다.", PRICE);

	private final int value;

	public Money(String money) {
		value = validNumber(validString(money));
	}

	private Integer validNumber(String validString) {
		return Optional.ofNullable(validString)
			.map(Integer::parseInt)
			.filter(number -> number / PRICE > 0)
			.orElseThrow(() -> new IllegalArgumentException(NOT_ENOUGH_MONEY_MESSAGE));
	}

	private String validString(String money) {
		return Optional.ofNullable(money)
			.filter(str -> NUMBER_PATTERN.matcher(str)
				.find())
			.orElseThrow(() -> new IllegalArgumentException(INVALID_NUMBER_MESSAGE));
	}

	public int countOfLottoTickets(int price) {
		return value / price;
	}

	public boolean isCapableBuying(int count) {
		return value >= count * PRICE;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Money money = (Money)o;

		return value == money.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
}
