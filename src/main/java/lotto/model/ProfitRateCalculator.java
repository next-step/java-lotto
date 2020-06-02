package lotto.model;

public class ProfitRateCalculator {

  private final static int DECIMAL_PLACE_TWO = 100;

  public static double calculateByTwoDecimalPlaces(Money income, Money expense) {
    return (double)
        ((long) (((double) income.getValue() / (double) expense.getValue()) * DECIMAL_PLACE_TWO))
        / DECIMAL_PLACE_TWO;
  }
}
