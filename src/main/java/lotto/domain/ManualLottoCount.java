package lotto.domain;

import static lotto.util.ValidationUtils.*;

public class ManualLottoCount {

	private static final String INVALID_LOTTO_COUNT_MESSAGE = "로또 개수는 숫자만 입력할 수 있습니다.";
	private static final String NOT_ENOUGH_MONEY_MESSAGE = "수동 로또를 구매할 금액이 부족합니다.";

	private final int count;

	public ManualLottoCount(String countString, Money money) {
		validate(countString);
		this.count = validateCount(countString, money);
	}

	private void validate(String countString) {
		if (!validateNumber(countString)) {
			throw new IllegalArgumentException(INVALID_LOTTO_COUNT_MESSAGE);
		}
	}

	private int validateCount(String countString, Money money) {
		int tempCount = Integer.parseInt(countString);

		validateEnoughMoney(money, tempCount);

		return tempCount;
	}

	private void validateEnoughMoney(Money money, int tempCount) {
		if (!money.isEnough(tempCount)) {
			throw new IllegalArgumentException(NOT_ENOUGH_MONEY_MESSAGE);
		}
	}

	public int count() {
		return count;
	}
}
