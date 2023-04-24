package stringcalculator.factory;

import stringcalculator.domain.Expression;

public class ExpressionFactory {

  public Expression create(final String[] expression) {
    return new Expression(expression);
  }
}
