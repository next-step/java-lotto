package calculator.domain.strategy;

import calculator.domain.Operator;
import calculator.domain.type.StringOperator;

public class AdditionStrategy implements CalculateStrategy {
  @Override
  public int calculate(int firstOperand, Operator operator, int secondOperand) {
    if (new Operator(StringOperator.ADDITION.getOperator()).equals(operator)) {
      return firstOperand + secondOperand;
    }

    return firstOperand;
  }
}
