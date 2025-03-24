package calculator.type;

import calculator.operator.*;

public enum OperatorType {
  ADD(new AddOperator()),
  SUBTRACT(new SubtractOperator()),
  MULTIPLY(new MultiplyOperator()),
  DIVIDE(new DivideOperator());

  private final Operator operator;

  OperatorType(Operator operator) {
    this.operator = operator;
  }

  public static OperatorType fromSymbol(String symbol) {
    switch (symbol) {
      case "+":
        return ADD;
      case "-":
        return SUBTRACT;
      case "*":
        return MULTIPLY;
      case "/":
        return DIVIDE;
      default:
        throw new IllegalArgumentException("Invalid operator symbol: " + symbol);
    }
  }

  public int execute(int left, int right) {
    return operator.calculate(left, right);
  }
}
