package stringcalculator;

import java.util.List;

public class StringCalculator {

  private static final String BASIC_SPLIT_REGEX = " ";

  public Operand calculate(String expression) {
    validateNullOrEmptyValue(expression);

    List<String> elements = splitCalculation(expression);

    Operand operand1 = new Operand(elements.get(0));
    for (int i = 1; i < elements.size(); i += 2) {
      String operator = elements.get(i);
      Operand operand2 = new Operand(elements.get(i + 1));

      int operationResult = Operator.findOperator(operator)
          .calc(operand1.getValue(), operand2.getValue());
      operand1.applyCalculationResult(operationResult);
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
}
