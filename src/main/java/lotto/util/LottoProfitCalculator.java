package lotto.util;

public class LottoProfitCalculator {

  private double convertProfit;

  public LottoProfitCalculator(final double convertProfit, final int lottoTicketSize) {
    final int TICKET_PRICE = 1000;
    final double SECOND_DECIMAL_POINT = 100.0;
    this.convertProfit =
        Math.round(convertProfit / (lottoTicketSize * TICKET_PRICE) * SECOND_DECIMAL_POINT)
            / SECOND_DECIMAL_POINT;
  }

  public double getConvertProfit() {
    return convertProfit;
  }
}
