package lotto.utils;

public class TicketCalculation {

	private static final int THOUSAND_UNIT = 1000;

	private TicketCalculation() {
	}

	public static int getLottoTicketNumber(int money) {
		return money / THOUSAND_UNIT;
	}
}
