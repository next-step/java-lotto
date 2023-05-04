package study.stringcalculator.factory;

import study.stringcalculator.domain.Expression;
import study.stringcalculator.domain.InputValue;

public class ExpressionFactory {

  private ExpressionFactory() {
  }

  public static Expression create(final InputValue inputValue) {
    String[] expression = inputValue.split();
    return new Expression(expression);
  }
}
