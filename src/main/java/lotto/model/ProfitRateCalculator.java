package lotto.model;

public class ProfitRateCalculator {
  private final static int DECIMAL_PLACE_TWO = 100;

  public static double calculateByTwoDeicimalPlaces(int income, int expense) {
    return (double)(DECIMAL_PLACE_TWO * income / expense) / DECIMAL_PLACE_TWO;
  }
}
