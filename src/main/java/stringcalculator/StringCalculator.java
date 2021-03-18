package stringcalculator;

public class StringCalculator {

  private StringCalculator() {}

  public static int sum(String expression) {
    if (expression == null || expression.isEmpty()) {
      return 0;
    }
    return Integer.parseInt(expression);
  }
}
