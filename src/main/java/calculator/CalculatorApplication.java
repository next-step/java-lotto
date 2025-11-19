package calculator;

import calculator.domain.Calculator;
import calculator.ui.InputView;
import calculator.ui.OutputView;

public class CalculatorApplication {

  public static void main(String[] args) {
    Calculator calculator = new Calculator();
    try {
      String expression = InputView.readExpression();
      int result = calculator.calculate(expression);
      OutputView.printResult(result);
    } catch (IllegalArgumentException e) {
      OutputView.printError(e.getMessage());
    }
  }
}
