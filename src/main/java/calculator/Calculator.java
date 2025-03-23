package calculator;

public class Calculator {
  public static int calculate(String input) {
    String[] values = input.split(" ");
    int left = Integer.parseInt(values[0]);
    int right = Integer.parseInt(values[2]);
    String operator = values[1];

    return calculate(left, right, operator);
  }

  private static int calculate(int left, int right, String operator) {
    switch(operator) {
      case "+":
        return left + right;
      case "-":
        return left - right;
      case "*":
        return left * right;
      case "/":
        return left / right;
      default:
        throw new IllegalArgumentException("잘못된 연산자입니다.");
    }
  }
}
