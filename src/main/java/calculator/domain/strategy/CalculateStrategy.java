package calculator.domain.strategy;

import calculator.domain.Operator;

@FunctionalInterface
public interface CalculateStrategy {
  int calculate(int firstOperand, Operator operator, int secondOperand);
}
