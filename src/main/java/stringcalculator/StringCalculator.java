package stringcalculator;

import java.util.List;
import stringcalculator.exception.IllegalNumberException;

public class StringCalculator {

  private static final String BASIC_SPLIT_REGEX = " ";
  private static final String NUMBER_RANGE_REGEX = "^-?\\d+$";
  private static final int INDIVISIBLE_NUMBER_ZERO = 0;

  public int calculate(String expression) {
    validateNullOrEmptyValue(expression);

    List<String> elements = splitCalculation(expression);

    int operand1 = convertToInt(elements.get(0));
    for (int i = 1; i < elements.size(); i += 2) {
      String operator = elements.get(i);
      int operand2 = convertToInt(elements.get(i + 1));

      operand1 = Operator.findOperator(operator)
          .calc(operand1, operand2);
    }
    return operand1;
  }

  public void validateNullOrEmptyValue(String expression) {
    if (expression == null || expression.isEmpty()) {
      throw new NullPointerException();
    }
  }

  private List<String> splitCalculation(String expression) {
    return List.of(expression.split(BASIC_SPLIT_REGEX));
  }

  private int convertToInt(String value) {
    validateOperand(value);
    return Integer.parseInt(value);
  }

  public void validateOperand(String value) {
    if (!value.matches(NUMBER_RANGE_REGEX)) {
      throw new IllegalNumberException(value);
    }
  }
}
