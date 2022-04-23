package calculator;

import calculator.controller.CalculatorController;
import calculator.view.InputView;

public class CalculatorApplication {

  public static void main(String[] args) {
    InputView.printRequest();
    CalculatorController.run(InputView.getInput());
  }
}
