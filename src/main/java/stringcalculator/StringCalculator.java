package stringcalculator;

public class StringCalculator {

  public static final String DELIMITER = ",";

  private StringCalculator() {}

  public static int sum(String expression) {
    if (expression == null || expression.isEmpty()) {
      return 0;
    }

    Numbers numbers = new Numbers(expression.split(DELIMITER));
    return numbers.sum();
  }
}
