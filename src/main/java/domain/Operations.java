package domain;

import java.util.Map;
import java.util.function.BiFunction;

public class Operations {

  private final Map<String, BiFunction<Integer, Integer, Integer>> operations;

  public Operations() {
    this.operations = initOperations();
  }

  private Map<String, BiFunction<Integer, Integer, Integer>> initOperations() {
    return Map.of(
        "+", (a, b) -> a + b,
        "-", (a, b) -> a - b,
        "*", (a, b) -> a * b,
        "/", (a, b) -> a / b
    );
  }

  public int calculate(int result, Integer number, String operator) {
    BiFunction<Integer, Integer, Integer> operation = operations.get(
        operator);
    if (operation == null) {
      throw new IllegalArgumentException("지원하지 않는 연산자가 있습니다.");
    }
    return operation.apply(result, number);
  }
}
