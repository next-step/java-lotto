package calculator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class Calculator {

  public static final String BLANK_DELIMITER = " ";

  private static final Pattern NUMERIC_PATTERN = Pattern.compile("\\d+");

  public static int calculate(String input) {
    if (isEmpty(input)) {
      throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
    }

    String[] inputs = input.split(BLANK_DELIMITER);
    return calculate(getOperators(inputs), getOperands(inputs).iterator());
  }

  private static boolean isEmpty(String input) {
    return input == null || input.isBlank();
  }

  private static List<Operator> getOperators(String[] inputs) {
    List<Operator> operators = new ArrayList<>();
    for (String input : inputs) {
      if (!NUMERIC_PATTERN.matcher(input).matches()) {
        operators.add(OperatorFactory.from(input));
      }
    }
    return operators;
  }

  private static List<Integer> getOperands(String[] inputs) {
    List<Integer> operands = new ArrayList<>();
    for (String input : inputs) {
      if (NUMERIC_PATTERN.matcher(input).matches()) {
        operands.add(Integer.parseInt(input));
      }
    }
    return operands;
  }

  private static int calculate(List<Operator> operators, Iterator<Integer> operands) {
    int result = operands.next();
    for (Operator operator : operators) {
      result = operator.calculate(result, operands.next());
    }
    return result;
  }

}
