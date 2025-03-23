package calculator.domain;

import java.util.List;

public class OperandAndOperatorGroup {

  private final List<Operand> operands;
  private final List<Operator> operators;

  public OperandAndOperatorGroup(List<Operand> operands, List<Operator> operators) {
    this.operands = operands;
    this.operators = operators;
    validate();
  }

  public List<Operand> getOperands() {
    return operands;
  }

  public List<Operator> getOperators() {
    return operators;
  }

  private void validate() {
    if (operands.size() - operators.size() != 1) {
      throw new IllegalArgumentException("숫자와 연산자의 개수가 맞지 않습니다.");
    }
  }
}
