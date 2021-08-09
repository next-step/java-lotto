package lotto.utils;

public class LottoCountCalculator {

	private static final int PRICE_PER_LOTTO = 1000;

	private LottoCountCalculator() {
	}

	public static int calculateLottoCount(int money) {
		return money / PRICE_PER_LOTTO;
	}

	public static int calculateLottoMoney(int lottoCount) {
		return lottoCount * PRICE_PER_LOTTO;
	}

}
