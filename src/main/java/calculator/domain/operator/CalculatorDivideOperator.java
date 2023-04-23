package calculator.domain.operator;

import calculator.domain.CalculatorValue;

public class CalculatorDivideOperator implements CalculatorOperateService {

  @Override
  public CalculatorOperator getOperator() {
    return CalculatorOperator.DIVIDE;
  }

  @Override
  public CalculatorValue operate(CalculatorValue leftTerm, CalculatorValue rightTerm) {
    if (rightTerm.getValue() == 0) {
      throw new UnsupportedOperationException("0으로 나누기를 할 수 없습니다.");
    }

    return new CalculatorValue(leftTerm.getValue() / rightTerm.getValue());
  }
}
