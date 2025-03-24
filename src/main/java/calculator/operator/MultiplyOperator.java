package calculator.operator;

public class MultiplyOperator implements Operator {
  @Override
  public int calculate(int left, int right) {
    return left * right;
  }
}
