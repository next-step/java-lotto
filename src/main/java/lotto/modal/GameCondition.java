package lotto.modal;

import java.math.BigDecimal;
import java.util.Objects;

import lotto.util.StringValid;

public class GameCondition {

	private static final int LOTTO_PRICE_MONEY = 1000;

	private final int userMoney;
	private final int count;

	public GameCondition(String money) {
		this(money, "0");
	}

	public GameCondition(String money, String count) {
		this.userMoney = setCheckMoney(money);
		this.count = setCheckCount(count);
	}

	public int getCount() {
		return this.count;
	}

	public int getRepeatCount() {
		return this.userMoney / LOTTO_PRICE_MONEY;
	}

	public int getRandomCount() {
		return this.getRepeatCount() - this.count;
	}

	public BigDecimal getYield(long totalPrize) {
		BigDecimal money = new BigDecimal(this.userMoney);
		return new BigDecimal(totalPrize).divide(money, 2, BigDecimal.ROUND_HALF_UP);
	}

	private int setCheckCount(String count) {
		if (StringValid.isEmptyStr(count)) {
			throw new IllegalArgumentException("수동 반복 횟수가 입력되지 않았습니다.");
		}

		if (StringValid.isNoNNumber(count)) {
			throw new IllegalArgumentException("수동 반복 횟수을 잘못 입력하였습니다. 숫자만 입력해 주세요.");
		}
		int result = Integer.parseInt(count);

		if (result * LOTTO_PRICE_MONEY > this.userMoney) {
			throw new IllegalArgumentException("금액이 부족합니다.");
		}
		return result;
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
		GameCondition that = (GameCondition)o;
		return userMoney == that.userMoney && count == that.count;
	}

	@Override
	public int hashCode() {
		return Objects.hash(userMoney, count);
	}
}
