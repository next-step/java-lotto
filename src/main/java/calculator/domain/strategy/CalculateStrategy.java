package calculator.domain.strategy;

@FunctionalInterface
public interface CalculateStrategy {
  int calculate(int firstOperand, int secondOperand);
}
