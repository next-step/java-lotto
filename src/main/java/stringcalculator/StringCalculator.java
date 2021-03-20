package stringcalculator;

public class StringCalculator {

  public static final String DELIMITER = ",";

  private StringCalculator() {}

  public static int sum(String expression) {
    if (expression == null || expression.isEmpty()) {
      return 0;
    }

    String[] numbers = expression.split(DELIMITER);
    return sum(numbers);
  }

  private static int sum(String[] numbers) {
    int sum = 0;
    for (String number : numbers) {
      sum += Integer.parseInt(number);
    }
    return sum;
  }
}
