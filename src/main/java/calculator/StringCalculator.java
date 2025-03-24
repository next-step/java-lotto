package calculator;

public class StringCalculator {


  public static double add(double firstNumber, double secondNumber) {
    return firstNumber + secondNumber;
  }

  public static double subtract(double firstNumber, double secondNumber) {
    return firstNumber - secondNumber;
  }

  public static double multiply(double firstNumber, double secondNumber) {
    return firstNumber * secondNumber;
  }

  public static int divide(double firstNumber, double secondNumber) {
    return (int)(firstNumber / secondNumber);
  }

  public static void isBlank(String text) {
    if (text == null || text.isBlank()) {
      throw new IllegalArgumentException();
    }
  }

  public static double calculate(String input) {
    isBlank(input);

    String[] value = input.split(" ");
    double result = Double.parseDouble(value[0]);

    for (int i = 1; i < value.length; i += 2) {
      String operator = value[i];
      double nextNumber = Double.parseDouble(value[i + 1]);

      result = operate(result, nextNumber, operator);
    }

    return result;
  }

  private static double operate(double firstNumber, double secondNumber, String operator) {
    switch (operator) {
      case "+":
        return add(firstNumber, secondNumber);
      case "-":
        return subtract(firstNumber, secondNumber);
      case "*":
        return multiply(firstNumber, secondNumber);
      case "/":
        return divide(firstNumber, secondNumber);
      default:
        throw new IllegalArgumentException();
    }
  }
}
