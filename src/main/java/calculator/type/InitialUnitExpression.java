package calculator.type;

import java.util.Objects;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    InitialUnitExpression that = (InitialUnitExpression) o;
    return leftOperand == that.leftOperand && rightOperand == that.rightOperand && operatorType == that.operatorType;
  }

  @Override
  public int hashCode() {
    return Objects.hash(leftOperand, operatorType, rightOperand);
  }
}
