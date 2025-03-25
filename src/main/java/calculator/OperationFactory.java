package calculator;

import java.util.Map;

public class OperationFactory {
  private static final String ADDITION = "+";
  private static final String SUBTRACTION = "-";
  private static final String MULTIPLICATION = "*";
  private static final String DIVISION = "/";

  private static final Map<String, Operation> operations = Map.of(
      ADDITION, (a, b) -> a + b,
      SUBTRACTION, (a, b) -> a - b,
      MULTIPLICATION, (a, b) -> a * b,
      DIVISION, (a, b) -> {
        if (b == 0) {
          throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return a / b;
      }
  );

  public static Operation getOperation(String operator) {
    if (!operations.containsKey(operator)) {
      throw new IllegalArgumentException("올바른 연산자가 아닙니다: " + operator);
    }
    return operations.get(operator);
  }

}
