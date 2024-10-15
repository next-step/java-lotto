package calculator;

import calculator.validator.InputValidator;

public class Calculator {

  public static int calculate(String input) {
    InputValidator.validateInput(input);

    String[] tokens = input.split(" ");
    return performCalculations(tokens);
  }

  private static int performCalculations(String[] tokens) {
    int result = parseNumber(tokens[0]);

    for (int i = 1; i < tokens.length; i += 2) {
      String operator = tokens[i];
      int nextNumber = parseNumber(tokens[i + 1]);
      result = operation(result, operator, nextNumber);
    }

    return result;
  }

  private static int operation(int result, String operator, int nextNumber) {
    switch (operator) {
      case "+":
        return result + nextNumber;
      case "-":
        return result - nextNumber;
      case "*":
        return result * nextNumber;
      case "/":
        return result / nextNumber;
      default:
        throw new IllegalArgumentException("유효하지 않은 연산자입니다!");
    }
  }

  private static int parseNumber(String token) {
    try {
      return Integer.parseInt(token);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("피연산자가 숫자가 아닙니다!");
    }
  }

}
