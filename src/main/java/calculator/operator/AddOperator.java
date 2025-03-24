package calculator.operator;

public class AddOperator implements Operator {
  @Override
  public int calculate(int left, int right) {
    return left + right;
  }
}
