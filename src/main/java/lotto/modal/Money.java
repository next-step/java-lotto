package lotto.modal;

import java.util.Objects;

import lotto.util.StringValid;

public class Money {

	public static final int LOTTO_PRICE_MONEY = 1000;

	private final int userMoney;

	private Money() {
		throw new AssertionError();
	}

	public Money(String userInputMoney) {

		validationMoney(userInputMoney);
		this.userMoney = Integer.parseInt(userInputMoney);
	}

	private void validationMoney(String userInputMoney) throws IllegalArgumentException {

		if (StringValid.isEmptyStr(userInputMoney)) {
			throw new IllegalArgumentException("돈(금액)이 입력되지 않았습니다.");
		}

		if (StringValid.isNoNNumber(userInputMoney)) {
			throw new IllegalArgumentException("돈(금액) 형식을 잘못 입력하였습니다. 숫자만 입력해 주세요.");
		}

		if (Integer.parseInt(userInputMoney) < LOTTO_PRICE_MONEY) {
			throw new IllegalArgumentException("로또 구매 최소 금액은 " + LOTTO_PRICE_MONEY + "원 입니다.");
		}
	}

	public int getRepeatCount() {
		return this.userMoney / LOTTO_PRICE_MONEY;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Money money = (Money)o;
		return userMoney == money.userMoney;
	}

	@Override
	public int hashCode() {
		return Objects.hash(userMoney);
	}
}
