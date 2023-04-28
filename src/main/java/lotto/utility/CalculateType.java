package lotto.utility;

import java.util.Arrays;

public enum CalculateType {
  PLUS("+") {
    public double compute(Double x, Double y) {return x + y;}
  },
  MINUS("-") {
    public double compute(Double x, Double y) {return x - y;}
  },
  MULTIPLY("*") {
    public double compute(Double x, Double y) {return x * y;}
  },
  DIVIDE("/") {
    public double compute(Double x, Double y) {return x / y;}
  };

  private final String operator;
  CalculateType(String operator) {
    this.operator = operator;
  }

  public abstract double compute(Double x, Double y);

  public static CalculateType valueOfOperator(String operator) {
    return Arrays.stream(values())
        .filter(value -> value.operator.equals(operator))
        .findAny()
        .orElse(null);
  }
}
