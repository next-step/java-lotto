package calculator;

public class PlusOperator implements Operator {

  public PlusOperator() {
  }

  @Override
  public Operand calculate(Operand op1, Operand op2) {
    return op1.plus(op2);
  }
}
