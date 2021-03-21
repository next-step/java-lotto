package stringcalculator;

public final class StringCalculator {

  private StringCalculator() {}

  public static int sum(String input) {
    Expression expression = new Expression(input);
    NonNegativeIntegers nonNegativeIntegers = new NonNegativeIntegers(expression.numbers());
    return nonNegativeIntegers.sum().toInt();
  }
}
