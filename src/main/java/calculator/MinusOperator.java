package calculator;

public class MinusOperator implements Operator {

  public MinusOperator() {
  }

  @Override
  public int calculate(int op1, int op2) {
    return op1 - op2;
  }
}
