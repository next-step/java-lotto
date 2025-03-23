package calculator.type;

import java.util.Objects;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    IntermediateUnitExpression that = (IntermediateUnitExpression) o;
    return rightOperand == that.rightOperand && operatorType == that.operatorType;
  }

  @Override
  public int hashCode() {
    return Objects.hash(operatorType, rightOperand);
  }
}
