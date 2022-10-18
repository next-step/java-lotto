package step2.model;

import step2.exception.LackOfMoneyException;

public class Payment {

	private static final int LOTTO_PRICE = 1000;

	public int lottoAmount(int cash) {
		if (cash < LOTTO_PRICE) {
			throw new LackOfMoneyException("금액이 부족합니다");
		}
		return cash / LOTTO_PRICE;
	}
}
