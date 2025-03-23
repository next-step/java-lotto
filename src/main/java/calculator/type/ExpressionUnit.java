package calculator.type;

import java.util.Objects;

public class ExpressionUnit {

  private final OperatorType operatorType;
  private final int rightOperand;

  public static ExpressionUnit valueOf(OperatorType operatorType, int rightOperand) {
    return new ExpressionUnit(operatorType, rightOperand);
  }

  private ExpressionUnit(OperatorType operatorType, int rightOperand) {
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
    ExpressionUnit that = (ExpressionUnit) o;
    return rightOperand == that.rightOperand && operatorType == that.operatorType;
  }

  @Override
  public int hashCode() {
    return Objects.hash(operatorType, rightOperand);
  }
}
