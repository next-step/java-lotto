package calculator.domain.strategy;

public class DivisionStrategy implements CalculateStrategy {
  @Override
  public int calculate(int firstOperand, int secondOperand) {
    return firstOperand / secondOperand;
  }
}
