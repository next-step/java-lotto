package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

  public static final String BLANK_DELIMITER = " ";
  public static final String PLUS_OPERATOR = "+";
  public static final String MINUS_OPERATOR = "-";
  public static final String TIMES_OPERATOR = "*";
  public static final String DIVIDE_OPERATOR = "/";

  public static int calculate(String input) {
    if (isEmpty(input)) {
      throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
    }

    String[] strings = input.split(BLANK_DELIMITER);
    List<String> operators = new ArrayList<>();
    List<Integer> operands = new ArrayList<>();
    for (int i = 0; i < strings.length; i++) {
      if (i % 2 == 0) {
        operands.add(Integer.parseInt(strings[i]));
      } else {
        operators.add(strings[i]);
      }
    }

    return calculate(operators, operands);
  }

  private static int calculate(List<String> operators, List<Integer> operands) {
    int result = operands.get(0);
    for (int i = 0; i < operators.size(); i++) {
      if (PLUS_OPERATOR.equals(operators.get(i))) {
        result = plus(result, operands.get(i + 1));
      } else if (MINUS_OPERATOR.equals(operators.get(i))) {
        result = minus(result, operands.get(i + 1));
      } else if (TIMES_OPERATOR.equals(operators.get(i))) {
        result = times(result, operands.get(i + 1));
      } else if (DIVIDE_OPERATOR.equals(operators.get(i))) {
        result = divide(result, operands.get(i + 1));
      }
    }
    return result;
  }

  private static boolean isEmpty(String input) {
    return input == null || input.isBlank();
  }

  private static int plus(int a, int b) {
    return a + b;
  }

  private static int minus(int a, int b) {
    return a - b;
  }

  private static int times(int a, int b) {
    return a * b;
  }

  private static int divide(int a, int b) {
    return a / b;
  }

}
