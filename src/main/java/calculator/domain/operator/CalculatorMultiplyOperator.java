package calculator.domain.operator;

import calculator.domain.CalculatorValue;

public class CalculatorMultiplyOperator implements CalculatorOperateService {

  @Override
  public CalculatorOperator getOperator() {
    return CalculatorOperator.MULTIPLY;
  }

  @Override
  public CalculatorValue operate(CalculatorValue leftTerm, CalculatorValue rightTerm) {
    return new CalculatorValue(leftTerm.getValue() * rightTerm.getValue());
  }
}
