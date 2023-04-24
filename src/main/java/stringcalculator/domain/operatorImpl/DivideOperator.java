package stringcalculator.domain.operatorImpl;

import stringcalculator.domain.Operator;

public class DivideOperator implements Operator {

  @Override
  public int operate(int leftInt, int rightInt) {
    return leftInt / rightInt;
  }
}
