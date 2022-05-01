package calculator;

public class DivideOperator implements Operator {

  public DivideOperator() {
  }

  @Override
  public int calculate(int op1, int op2) {
    return op1 / op2;
  }
}
