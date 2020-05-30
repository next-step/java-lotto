package stringaddcalculator;

public class StringAddCalculator {

  public static int splitAndSum(String s) {
    if (StringAddCalculatorUtils.isNullOrEmpty(s)) {
      return 0;
    }

    return new PlusCalculator().calculate(StringAddCalculatorUtils.splitNumbers(s));
  }
}
