package calculator.type;

public class IntermediateUnitExpression {
  private final OperatorType operatorType;
  private final int rightOperand;

  public static IntermediateUnitExpression valueOf(OperatorType operatorType, int rightOperand) {
    return new IntermediateUnitExpression(operatorType, rightOperand);
  }

  private IntermediateUnitExpression(OperatorType operatorType, int rightOperand) {
    this.operatorType = operatorType;
    this.rightOperand = rightOperand;
  }

  public int run(int leftOperand) {
    return operatorType.execute(leftOperand, rightOperand);
  }
}
