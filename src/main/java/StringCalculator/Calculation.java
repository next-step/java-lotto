package StringCalculator;

import static util.Validator.validateArgument;

public class CalculationOperator {

  public static final String ERROR_MESSAGE_WHEN_TRY_TO_DIVIDE_BY_ZERO = "0으로 나눌 수 없습니다.";

  private CalculationOperator() {}

  public static int addict(int a, int b) {
    return a + b;
  }

  public static int subtract(int a, int b) {
    return a - b;
  }

  public static int multiply(int a, int b) {
    return a * b;
  }

  public static int divide(int a, int b) {
    validateArgument(
        b,
        (arg) -> b != 0,
        ERROR_MESSAGE_WHEN_TRY_TO_DIVIDE_BY_ZERO
    );

    return a / b;
  }
}
