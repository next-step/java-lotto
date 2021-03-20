package stringcalculator;

public class StringCalculator {

  private StringCalculator() {}

  public static int sum(String input) {
    Expression expression = new Expression(input);
    Numbers numbers = new Numbers(expression.numbers());
    return numbers.sum();
  }
}
