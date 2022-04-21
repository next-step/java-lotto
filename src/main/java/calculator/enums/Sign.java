package calculator.enums;

import calculator.strategy.CalculateStrategy;
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

  public static Sign search(String sign) {
    if(sign.equals("+")) return Sign.PLUS;
    if(sign.equals("-")) return Sign.MINAS;
    if(sign.equals("*")) return Sign.MULTIPLE;
    return Sign.DIVISION;
  }

  public int apply(int front, int rear) {
    return strategy.apply(front, rear);
  }
}
