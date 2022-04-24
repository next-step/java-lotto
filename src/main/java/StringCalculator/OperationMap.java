package StringCalculator;

import static util.Validator.validateArgument;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class OperationMap {

  public static final String ERROR_MESSAGE_FOR_INVALID_INPUT_OPERATOR = "잘못된 연산자입니다.";
  public static final String ADDICTION = "+";
  public static final String SUBTRACTION = "-";
  public static final String MULTIPLICATION = "*";
  public static final String DIVISION = "/";

  private OperationMap() {}

  private static final Map<String, BinaryOperator<Integer>> operationMap = new HashMap<>();
  static {
    operationMap.put(ADDICTION, Calculation::addict);
    operationMap.put(SUBTRACTION, Calculation::subtract);
    operationMap.put(MULTIPLICATION, Calculation::multiply);
    operationMap.put(DIVISION, Calculation::divide);;
  }

  public static int operatorBy(String operator, int a, int b) {
    validate(operator);
    return operationMap.get(operator).apply(a, b);
  }

  private static void validate(String operator) {
    validateArgument(
        operator,
        (arg) -> operationMap.containsKey(operator),
        ERROR_MESSAGE_FOR_INVALID_INPUT_OPERATOR
    );
  }
}
