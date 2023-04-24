package stringcalculator.domain.operator;

public class DivideOperator implements Operator {

  @Override
  public int operate(int left, int right) {
    return left / right;
  }
}
