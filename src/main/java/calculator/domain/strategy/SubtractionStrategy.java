package calculator.domain.strategy;

import calculator.domain.Operator;
import calculator.domain.type.StringOperator;

public class SubtractionStrategy implements CalculateStrategy {
  @Override
  public int calculate(int firstOperand, Operator operator, int secondOperand) {
    if (new Operator(StringOperator.SUBTRACTION.getOperator()).equals(operator)) {
      return firstOperand - secondOperand;
    }

    return firstOperand;
  }
}
