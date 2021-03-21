package stringCalculator;

import stringCalculator.controller.StringCalculatorController;

public class StringCalculatorApplication {

  public static void main(String[] args) {
    StringCalculatorController stringCalculatorController = new StringCalculatorController();
    stringCalculatorController.calculate();
  }

}
