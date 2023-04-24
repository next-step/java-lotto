package stringcalculator.domain.operator;

public class AddOperator implements Operator {

  @Override
  public int operate(int left, int right) {
    return left + right;
  }
}
