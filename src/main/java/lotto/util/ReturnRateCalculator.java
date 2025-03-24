package lotto.util;

public class ReturnRateCalculator {

  public static double calculate(double initialInvestment, double profit) {
    return (int) (profit / initialInvestment * 100) / 100.0;
  }

}
