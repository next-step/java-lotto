package study.stringcalculator.domain;

public class Expression {

  private String[] expression;

  public Expression(final String[] expression) {
    if (expression.length % 2 == 0) {
      throw new IllegalArgumentException("유효하지 않은 입력입니다.");
    }

    this.expression = expression;
  }

  public int calculate() {
    int result = Integer.parseInt(expression[0]);

    for (int i = 1; i < expression.length; i = i + 2) {
      Operator operator = Operator.convertOperator(expression[i]);
      result = operator.operate(result, Integer.parseInt(expression[i + 1]));
    }

    return result;
  }
}
