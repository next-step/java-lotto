package stringcalculator.domain;

import stringcalculator.factory.OperatorFactory;
import stringcalculator.util.IntConverter;

public class Expression {

  private String[] expression;

  public Expression(final String[] expression) {
    if (expression.length % 2 == 0) {
      throw new IllegalArgumentException("유효하지 않은 입력입니다.");
    }

    this.expression = expression;
  }

  public int calculate(OperatorFactory operatorFactory) {
    int result = IntConverter.convert(expression[0]);

    for (int i = 1; i < expression.length; i = i + 2) {
      Operator operator = operatorFactory.create((expression[i]));
      result = operator.operate(result, IntConverter.convert(expression[i + 1]));
    }

    return result;
  }
}
