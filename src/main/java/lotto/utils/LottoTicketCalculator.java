package lotto.utils;

public class LottoTicketCalculator {

	private static final int THOUSAND_UNIT = 1000;

	private LottoTicketCalculator() {
	}

	public static int calculatorLottoTicketCount(int money) {
		return money / THOUSAND_UNIT;
	}
}
