public class Calculator {

  public int calculate(String[] tokens) {
    int result = Integer.parseInt(tokens[0]);
    for (int i = 1; i < tokens.length; i += 2) {
      String operator = tokens[i];
      int operand = Integer.parseInt(tokens[i + 1]);
      result = calculate(result, operator, operand);
    }
    return result;
  }

  private int calculate(int left, String operator, int right) {
    switch (operator) {
      case "+":
        return left + right;
      case "-":
        return left - right;
      case "*":
        return left * right;
      case "/":
        return left / right;
      default:
        throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
    }
  }
} 