package calculator.operator;

public class SubtractOperator implements Operator {
  @Override
  public int calculate(int left, int right) {
    return left - right;
  }
}
