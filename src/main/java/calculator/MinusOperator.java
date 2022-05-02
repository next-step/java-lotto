package calculator;

public class MinusOperator implements Operator {

  public MinusOperator() {
  }

  @Override
  public Operand calculate(Operand op1, Operand op2) {
    return op1.minus(op2);
  }
}
