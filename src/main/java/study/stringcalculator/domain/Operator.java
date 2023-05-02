package study.stringcalculator.domain;

public enum Operator {

  ADD("+", (left, right) -> left + right),
  SUBTRACT("-", (left, right) -> left - right),
  MULTIPLY("*", (left, right) -> left * right),
  DIVIDE("/", (left, right) -> left / right);

  private final String operator;
  private final OperatorInterface operatorLambda;

  Operator(String operator, OperatorInterface operatorLambda) {
    this.operator = operator;
    this.operatorLambda = operatorLambda;
  }

  public int operate(int left, int right) {
    return operatorLambda.operate(left, right);
  }

  public String getOperator() {
    return operator;
  }

  public static Operator getOperator(String value) {
    switch (value) {
      case "+":
        return Operator.ADD;
      case "-":
        return Operator.SUBTRACT;
      case "*":
        return Operator.MULTIPLY;
      case "/":
        return Operator.DIVIDE;
      default:
        throw new IllegalArgumentException("유효하지 않은 입력입니다.");
    }
  }
}
