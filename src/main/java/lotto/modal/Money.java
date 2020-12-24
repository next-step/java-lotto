package lotto.modal;

import java.math.BigDecimal;
import java.util.Objects;

import lotto.util.StringValid;

public class Money {

	private static final int LOTTO_PRICE_MONEY = 1000;

	private final int userMoney;

	public Money(String money) {
		this.userMoney = setCheckMoney(money);
	}

	public int getBuyCount() {
		return userMoney / LOTTO_PRICE_MONEY;
	}

	public BigDecimal getYield(long totalPrize) {
		BigDecimal money = new BigDecimal(this.userMoney);
		return new BigDecimal(totalPrize).divide(money, 2, BigDecimal.ROUND_HALF_UP);
	}

	private int setCheckMoney(String userInputMoney) throws IllegalArgumentException {
		if (StringValid.isEmptyStr(userInputMoney)) {
			throw new IllegalArgumentException("돈(금액)이 입력되지 않았습니다.");
		}

		if (StringValid.isNoNNumber(userInputMoney)) {
			throw new IllegalArgumentException("돈(금액) 형식을 잘못 입력하였습니다. 숫자만 입력해 주세요.");
		}
		int result = Integer.parseInt(userInputMoney);

		if (result < LOTTO_PRICE_MONEY) {
			throw new IllegalArgumentException("로또 구매 최소 금액은 " + LOTTO_PRICE_MONEY + "원 입니다.");
		}
		return result;
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
