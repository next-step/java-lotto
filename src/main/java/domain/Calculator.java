package domain;

public class Calculator {

  private final String DELIMITER = " ";

  public int getResult(String expression) {
    ExpressionValidation.validateExpression(expression);
    String[] expressions = splitString(expression);
    int arrayLength = expressions.length;
    int result = Integer.parseInt(expressions[0]);
    result = calculate(expressions, arrayLength, result);
    return result;
  }

  private static int calculate(String[] expressions, int ARRAY_LENGTH, int result) {
    for (int i = 1; i < ARRAY_LENGTH; i += 2) {
      String operator = expressions[i];
      ExpressionValidation.validateOperator(operator);
      int number = Integer.parseInt(expressions[i + 1]);
      result = OperatorMapping.getOperator(operator).calculate(result, number);
    }
    return result;
  }

  private String[] splitString(String expression) {
    return expression.split(DELIMITER);
  }

}
