package calculator;

import calculator.view.InputView;
import calculator.view.OutputView;

public class StringCalculatorExecutor {

  public static void main(String[] args) {
    OutputView.showResult(StringCalculator.run(InputView.showExpressionInput()));
  }
}
