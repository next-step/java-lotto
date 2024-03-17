package calculator.domain.strategy;

import calculator.domain.Operand;
import calculator.domain.Operator;
import calculator.domain.type.StringOperator;

public class AdditionStrategy implements CalculateStrategy {
  @Override
  public int calculate(Operand firstOperand, Operator operator, Operand secondOperand) {
    if (new Operator(StringOperator.ADDITION.getOperator()).equals(operator)) {
      return firstOperand.toNumber() + secondOperand.toNumber();
    }

    return 0;
  }
}
