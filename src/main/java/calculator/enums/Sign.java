package calculator.enums;

import calculator.strategy.CalculateStrategy;
import java.util.Arrays;
import java.util.function.Function;

public enum Sign {
  PLUS("+", Integer::sum),
  MINAS("-", (a, b) -> a - b),
  MULTIPLE("*", (a, b) -> a * b),
  DIVISION("/", (a, b) -> a / b);

  private String value;
  private CalculateStrategy strategy;

  Sign(String value, CalculateStrategy strategy) {
    this.value = value;
    this.strategy = strategy;
  }

  public static Sign search(String value) {
    return Arrays.stream(values())
        .filter(sign -> sign.value.equals(value))
        .findFirst().orElseThrow(() -> new IllegalArgumentException("잘못된 부호를 넣었습니다. 다시 확인해주세요."));
  }

  public int apply(int front, int rear) {
    return strategy.apply(front, rear);
  }
}
