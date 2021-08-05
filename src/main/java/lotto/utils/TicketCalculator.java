package lotto.utils;

public class TicketCalculator {

	private static final int THOUSAND_UNIT = 1000;

	private TicketCalculator() {
	}

	public static int calculatorTicketCount(int money) {
		return money / THOUSAND_UNIT;
	}
}
