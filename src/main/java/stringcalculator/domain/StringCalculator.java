package stringcalculator.domain;

import stringcalculator.domain.operator.Operator;

public class StringCalculator {

  private Input input;
  private OperatorMap operatorMap;

  public StringCalculator(final String input) {
    this(new Input(input), new OperatorMap());
  }

  private StringCalculator(final Input input, final OperatorMap operatorMap) {
    this.input = input;
    this.operatorMap = operatorMap;
  }

  public int calculate() {
    return getResult(getExpression());
  }

  private String[] getExpression() {
    String[] expression = input.split();

    if (expression.length % 2 == 0) {
      throw new IllegalArgumentException("유효하지 않은 입력입니다.");
    }
    return expression;
  }

  private int getResult(String[] expression) {
    int result = getNumber(expression[0]);

    for (int i = 1; i < expression.length; i = i + 2) {
      result = getOperator(expression[i])
          .operate(result, getNumber(expression[i + 1]));
    }
    return result;
  }

  private int getNumber(String input) {
    return Number.convertNumber(input).getNumber();
  }

  private Operator getOperator(String input) {
    return operatorMap.convertOperator(input);
  }
}
