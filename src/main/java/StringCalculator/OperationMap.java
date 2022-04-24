package StringCalculator;

import static util.Validator.validateArgument;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;

public class OperationMap {

  private static final String ERROR_MESSAGE_FOR_INVALID_INPUT_OPERATOR = "잘못된 연산자입니다.";
  private static final String ADDICTION = "+";
  private static final String SUBTRACTION = "-";
  private static final String MULTIPLICATION = "*";
  private static final String DIVISION = "/";

  private OperationMap() {}

  private static final Map<String, IntBinaryOperator> operationMap = new HashMap<>();
  static {
    operationMap.put(ADDICTION, Calculation::addict);
    operationMap.put(SUBTRACTION, Calculation::subtract);
    operationMap.put(MULTIPLICATION, Calculation::multiply);
    operationMap.put(DIVISION, Calculation::divide);;
  }

  public static int operatorBy(String operator, int a, int b) {
    validate(operator);
    return operationMap.get(operator).applyAsInt(a, b);
  }

  private static void validate(String operator) {
    validateArgument(
        operator,
        (arg) -> operationMap.containsKey(operator),
        ERROR_MESSAGE_FOR_INVALID_INPUT_OPERATOR
    );
  }
}
