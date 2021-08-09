package lotto.domain;

import lotto.exception.MoneyValidationException;

public class LottoCount {

	private static final int LOTTO_PRICE = 1000;

	private final int lottoCount;

	public LottoCount(int money) {
		if (money < LOTTO_PRICE) {
			throw new MoneyValidationException("로또 구매가 가능한 최소 금액은 " + LOTTO_PRICE + "원 이상입니다.");
		}

		lottoCount = money / LOTTO_PRICE;
	}

	public int getLottoCount() {
		return lottoCount;
	}
}
