package lotto.utility;

import java.util.Arrays;

@FunctionalInterface
public interface Operation {
  double compute(Double x, Double y);

  enum BasicOperation implements Operation {
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
    BasicOperation(String operator) {
      this.operator = operator;
    }

    public static BasicOperation valueOfOperator(String operator) {
      return Arrays.stream(values())
          .filter(value -> value.operator.equals(operator))
          .findAny()
          .orElse(null);
    }
  }
}
