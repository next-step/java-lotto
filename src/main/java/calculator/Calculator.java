package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Calculator {

  public static final String BLANK_DELIMITER = " ";

  public static int calculate(String input) {
    if (isEmpty(input)) {
      throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
    }

    String[] strings = input.split(BLANK_DELIMITER);
    List<Operator> operators = new ArrayList<>();
    List<Integer> operands = new ArrayList<>();
    for (int i = 0; i < strings.length; i++) {
      if (i % 2 == 0) {
        operands.add(Integer.parseInt(strings[i]));
      } else {
        operators.add(OperatorFactory.from(strings[i]));
      }
    }

    return calculate(operators, operands.listIterator());
  }

  private static int calculate(List<Operator> operators, ListIterator<Integer> operands) {
    int result = operands.next();
    for (Operator operator : operators) {
      result = operator.calculate(result, operands.next());
    }
    return result;
  }

  private static boolean isEmpty(String input) {
    return input == null || input.isBlank();
  }

}
