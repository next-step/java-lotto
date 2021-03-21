package stringCalculator.controller;

import stringCalculator.domain.StringCalculator;
import stringCalculator.view.InputView;
import stringCalculator.view.ResultView;

public class StringCalculatorMain {

  public static void main(String[] args) {
    InputView inputView = new InputView();
    String input = inputView.input();

    StringCalculator stringCalculator = new StringCalculator();
    int calculate = stringCalculator.calculate(input);

    ResultView resultView = new ResultView();
    resultView.printCalculateResult(calculate);


  }

}
