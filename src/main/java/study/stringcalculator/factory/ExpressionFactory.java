package study.stringcalculator.factory;

import study.stringcalculator.domain.Expression;

public class ExpressionFactory {

  private ExpressionFactory() {
  }

  public static Expression create(final String[] expression) {
    return new Expression(expression);
  }
}
