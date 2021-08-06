package lotto.utils;

public class LottoCountCalculator {

	private static final int THOUSAND_UNIT = 1000;

	private LottoCountCalculator() {
	}

	public static int calculateLottoCount(int money) {
		return money / THOUSAND_UNIT;
	}

	public static int calculateLottoMoney(int lottoCount) {
		return lottoCount * THOUSAND_UNIT;
	}
}
