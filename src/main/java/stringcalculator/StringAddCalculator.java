package stringcalculator;

import stringcalculator.calculatorexception.NegativeNumberException;

public class StringAddCalculator {

  private static final int DEFAULT_RETURN_VALUE = 0;

  private StringAddCalculator() {
  }

  public static int splitAndSum(String rawInput) {

    int result = 0;

    if (isInvalidInput(rawInput)) {
      return DEFAULT_RETURN_VALUE;
    }

    Splitter splitter = new Splitter();
    String[] splitInputs = splitter.splitInput(rawInput);

    for (String splitInput : splitInputs) {
      result += castToInteger(splitInput);
    }

    return result;
  }

  private static boolean isInvalidInput(String input) {
    return input == null || input.isEmpty();
  }

  private static int castToInteger(String tokenizedInput) {
    int castedInput = Integer.parseInt(tokenizedInput);
    if (castedInput < 0) {
      throw new NegativeNumberException();
    }
    return castedInput;
  }
}
