package calculator.operator;

public class DivideOperator implements Operator {
  @Override
  public int calculate(int left, int right) {
    return left / right;
  }
}
