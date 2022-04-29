package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

  public static int calculate(String input) {
    String[] strings = input.split(" ");
    List<String> operators = new ArrayList<>();
    List<Integer> operands = new ArrayList<>();
    for (int i = 0; i < strings.length; i++) {
      if (i % 2 == 0) {
        operands.add(Integer.parseInt(strings[i]));
      } else {
        operators.add(strings[i]);
      }
    }

    int result = operands.get(0);
    for (int i = 0; i < operators.size(); i++) {
      if ("+".equals(operators.get(i))) {
        result = plus(result, operands.get(i + 1));
      } else if ("-".equals(operators.get(i))) {
        result = minus(result, operands.get(i + 1));
      }
    }
    return result;
  }

  private static int plus(int a, int b) {
    return a + b;
  }

  private static int minus(int a, int b) {
    return a - b;
  }

}
