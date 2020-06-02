package lotto.model;

public class ProfitRateCalculator {

  private final static int DECIMAL_PLACE_TWO = 100;

  public static double calculateByTwoDecimalPlaces(long income, long expense) {
    return (double)
        ((long) (((double) income / (double) expense) * DECIMAL_PLACE_TWO)) / DECIMAL_PLACE_TWO;
  }
}
