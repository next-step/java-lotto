package lotto.util;

public class LottoProfitCalculator {

	private static final int TICKET_PRICE = 1000;
	private static final double SECOND_DECIMAL_POINT = 100.0;

	public static double getConvertProfit(final double convertProfit, final int lottoTicketSize) {
		return Math.round(convertProfit / (lottoTicketSize * TICKET_PRICE) * SECOND_DECIMAL_POINT)
			/ SECOND_DECIMAL_POINT;
	}
}
