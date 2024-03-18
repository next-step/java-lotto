package calculator.domain.strategy;

public class MultiplicationStrategy implements CalculateStrategy {
  @Override
  public int calculate(int firstOperand, int secondOperand) {
    return firstOperand * secondOperand;
  }
}
