package stringCalculator;

import java.util.stream.Stream;

public enum Operator {
  PLUS("+") {
    @Override
    public Number calculate(Number number1, Number number2) {
      return new Number(number1.value() + number2.value());
    }
  },
  MINUS("-") {
    @Override
    public Number calculate(Number number1, Number number2) {
      return new Number(number1.value() - number2.value());
    }
  },
  DIVISION("/") {
    @Override
    public Number calculate(Number number1, Number number2) {
      return new Number(number1.value() / number2.value());
    }
  },
  MULTIPLICATION("*") {
    @Override
    public Number calculate(Number number1, Number number2) {
      return new Number(number1.value() * number2.value());
    }
  };

  private final String operator;

  abstract Number calculate(Number number1, Number number2);

  Operator(String operator) {
    this.operator = operator;
  }

  public static Operator from(String operator) {
    return Stream.of(values())
        .filter(op -> op.operator.equals(operator))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 연산자입니다."));
  }
}
