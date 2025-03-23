package calculator;

import java.util.List;

public class Calculator {
  public static int calculate(String input) {
    validate(input);
    String[] tokens = input.split(" ");
    ParsedExpression parsedExpression = ExpressionParser.parse(tokens);
    return evaluate(parsedExpression.getNumbers(), parsedExpression.getOperators());
  }

  private static void validate(String input) {
    if (input == null) {
      throw new IllegalArgumentException("입력값이 null입니다.");
    }
    if (input.isEmpty()) {
      throw new IllegalArgumentException("입력값이 빈 문자열입니다.");
    }
  }

  private static int evaluate(List<Integer> numbers, List<String> operators) {
    int result = numbers.get(0);
    for (int i = 0; i < operators.size(); i++) {
      result = calculate(result, numbers.get(i + 1), operators.get(i));
    }
    return result;
  }

  private static int calculate(int left, int right, String operator) {
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
        throw new IllegalArgumentException("잘못된 연산자입니다.");
    }
  }
}
