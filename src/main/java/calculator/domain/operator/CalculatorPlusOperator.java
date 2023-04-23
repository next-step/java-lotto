package calculator.domain.operator;

import calculator.domain.CalculatorValue;

public class CalculatorPlusOperator implements CalculatorOperateService {

  @Override
  public CalculatorOperator getOperator() {
    return CalculatorOperator.PLUS;
  }

  @Override
  public CalculatorValue operate(CalculatorValue leftTerm, CalculatorValue rightTerm) {
    return new CalculatorValue(leftTerm.getValue() + rightTerm.getValue());
  }
}
