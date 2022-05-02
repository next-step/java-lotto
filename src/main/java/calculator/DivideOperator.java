package calculator;

public class DivideOperator implements Operator {

  public DivideOperator() {
  }

  @Override
  public Operand calculate(Operand op1, Operand op2) {
    return op1.divide(op2);
  }
}
