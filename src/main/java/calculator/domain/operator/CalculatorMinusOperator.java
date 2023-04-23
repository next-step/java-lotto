package calculator.domain.operator;

import calculator.domain.CalculatorValue;

public class CalculatorMinusOperator implements CalculatorOperateService {

  @Override
  public CalculatorOperator getOperator() {
    return CalculatorOperator.MINUS;
  }

  @Override
  public CalculatorValue operate(CalculatorValue leftTerm, CalculatorValue rightTerm) {
    return new CalculatorValue(leftTerm.getValue() - rightTerm.getValue());
  }
}
