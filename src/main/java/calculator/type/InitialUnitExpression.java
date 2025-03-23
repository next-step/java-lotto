package calculator.type;

public class InitialUnitExpression {
  private final int leftOperand;
  private final OperatorType operatorType;
  private final int rightOperand;

  public static InitialUnitExpression valueOf(int leftOperand, OperatorType operatorType, int rightOperand) {
    return new InitialUnitExpression(leftOperand, operatorType, rightOperand);
  }

  private InitialUnitExpression(int leftOperand, OperatorType operatorType, int rightOperand) {
    this.leftOperand = leftOperand;
    this.operatorType = operatorType;
    this.rightOperand = rightOperand;
  }

  public int run() {
    return operatorType.execute(leftOperand, rightOperand);
  }
}
