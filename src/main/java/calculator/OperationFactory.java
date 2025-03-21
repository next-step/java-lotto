package calculator;

import java.util.Map;

public class OperationFactory {
  private static final Map<String, Operation> operations = Map.of(
      "+", new Addition(),
      "-", new Subtraction(),
      "*", new Multiplication(),
      "/", new Division()
  );

  public static Operation getOperation(String operator) {
    if (!operations.containsKey(operator)) {
      throw new IllegalArgumentException("올바른 연산자가 아닙니다: " + operator);
    }
    return operations.get(operator);
  }

}
