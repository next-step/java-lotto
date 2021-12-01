package calculator;

import calculator.controller.Calculator;
import calculator.view.InputView;
import calculator.view.ResultView;

public class Main {

  public static void main(String[] args) {
    Calculator calculator = Calculator.getInstance();
    InputView inputView = InputView.getInstance();
    ResultView resultView = ResultView.getInstance();

    String input = inputView.inputExpression();
    int result = calculator.calculate(input);

    resultView.printResult(result);
  }
}
