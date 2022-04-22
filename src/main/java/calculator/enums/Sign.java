package calculator.enums;

import calculator.strategy.CalculateStrategy;
import java.util.Arrays;
import java.util.function.Function;

public enum Sign {
  PLUS("+", Integer::sum),
  MINAS("-", (a, b) -> a - b),
  MULTIPLE("*", (a, b) -> a * b),
  DIVISION("/", (a, b) -> a / b);

  private final String key;
  private final CalculateStrategy strategy;

  Sign(String key, CalculateStrategy strategy) {
    this.key = key;
    this.strategy = strategy;
  }

  public static Sign search(String value) {
    return Arrays.stream(values())
        .filter(sign -> sign.key.equals(value))
        .findFirst().orElseThrow(() -> new IllegalArgumentException("잘못된 부호를 넣었습니다. 다시 확인해주세요."));
  }

  public int execute(int front, int rear) {
    return strategy.apply(front, rear);
  }
}
