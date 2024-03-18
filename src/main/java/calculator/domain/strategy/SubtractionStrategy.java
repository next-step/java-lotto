package calculator.domain.strategy;

public class SubtractionStrategy implements CalculateStrategy {
  @Override
  public int calculate(int firstOperand, int secondOperand) {
    return firstOperand - secondOperand;
  }
}
