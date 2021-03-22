package stringCalculator.controller;

import stringCalculator.domain.StringCalculator;
import stringCalculator.view.InputView;
import stringCalculator.view.ResultView;

public class StringCalculatorController {

  public void calculate() {
    InputView inputView = new InputView();
    String input = inputView.input();

    StringCalculator stringCalculator = new StringCalculator();
    int calculate = stringCalculator.calculate(input);

    ResultView resultView = new ResultView();
    resultView.printCalculateResult(calculate);
  }
}
