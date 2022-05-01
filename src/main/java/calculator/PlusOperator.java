package calculator;

public class PlusOperator implements Operator {

  public PlusOperator() {
  }

  @Override
  public int calculate(int op1, int op2) {
    return op1 + op2;
  }
}
