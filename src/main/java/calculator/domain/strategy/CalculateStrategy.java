package calculator.domain.strategy;

import calculator.domain.Operand;
import calculator.domain.Operator;

@FunctionalInterface
public interface CalculateStrategy {
  int calculate(Operand firstOperand, Operator operator, Operand secondOperand);
}
