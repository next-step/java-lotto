package study.stringcalculator.domain;

public enum Operator {

  ADD("+", (left, right) -> left + right),
  SUBTRACT("-", (left, right) -> left - right),
  MULTIPLY("*", (left, right) -> left * right),
  DIVIDE("/", (left, right) -> left / right);

  private final String operator;
  private final OperatorInterface operatorLambda;

  private Operator(String operator, OperatorInterface operatorLambda) {
    this.operator = operator;
    this.operatorLambda = operatorLambda;
  }

  public int operate(int left, int right) {
    return operatorLambda.operate(left, right);
  }

  public String getOperator() {
    return operator;
  }

  public static Operator convertOperator(String value) {
    for (Operator operator : Operator.values()) {
      if (operator.getOperator().equals(value)) {
        return operator;
      }
    }

    throw new IllegalArgumentException("유효하지 않은 입력입니다.");
  }
}
