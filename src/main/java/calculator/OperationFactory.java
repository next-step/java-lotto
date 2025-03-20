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
    return operations.get(operator);
  }

}
