package lotto.util;

public class LottoProfitCalculator {
    private static final int TICKET_PRICE = 1000;
    private static final double SECOND_DECIMAL_POINT = 100.0;
   
    private double convertProfit;

    public LottoProfitCalculator(final double convertProfit, final int lottoTicketSize) {
    this.convertProfit =
        Math.round(convertProfit / (lottoTicketSize * TICKET_PRICE) * SECOND_DECIMAL_POINT)
            / SECOND_DECIMAL_POINT;
  }

  public double getConvertProfit() {
    return convertProfit;
  }
}
