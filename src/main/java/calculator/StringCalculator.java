package calculator;

import calculator.type.Expression;

public class StringCalculator {

  public static int run(String expression) {
    return Expression.valueOf(expression.trim()).run();
  }
}
