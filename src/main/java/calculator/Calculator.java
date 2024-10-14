package calculator;

import calculator.validator.InputValidator;

public class Calculator {

  public static void calculate(String input) {
    InputValidator.validateInput(input);
  }
}
