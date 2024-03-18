package calculator.domain.strategy;

public class AdditionStrategy implements CalculateStrategy {
  @Override
  public int calculate(int firstOperand, int secondOperand) {
    return firstOperand + secondOperand;
  }
}
