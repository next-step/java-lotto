package StringCalculator;

import static util.Validator.validateArgument;

import java.util.Arrays;
import java.util.Map;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;

public enum Operation {

  ADDICTION("+", Calculation::addict),
  SUBTRACTION("-", Calculation::subtract),
  MULTIPLICATION("*", Calculation::multiply),
  DIVISION("/", Calculation::divide);

  private static final String ERROR_MESSAGE_FOR_INVALID_INPUT_OPERATOR = "잘못된 연산자입니다.";
  private static final Map<String, IntBinaryOperator> operationMap = Arrays.stream(
          Operation.values())
      .collect(Collectors.toMap(operation -> operation.operator,
          operation -> operation.calculation));

  private final String operator;
  private final IntBinaryOperator calculation;


  Operation(String operator, IntBinaryOperator calculation) {
    this.operator = operator;
    this.calculation = calculation;
  }

  public static int calculateBy(String operator, int a, int b) {
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
