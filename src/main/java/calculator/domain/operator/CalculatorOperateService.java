package calculator.domain.operator;

import calculator.domain.CalculatorValue;

public interface CalculatorOperateService {

  CalculatorOperator getOperator();

  CalculatorValue operate (CalculatorValue leftTerm, CalculatorValue rightTerm);
}
