package calculator.domain;

import calculator.exception.InvalidOperatorException;
import java.util.Arrays;

public enum OperatorStrategy implements Operator {
  PLUS("+") {
    @Override
    public Number operate(Number number1, Number number2) {
      return number1.plus(number2);
    }
  },
  MINUS("-") {
    @Override
    public Number operate(Number number1, Number number2) {
      return number1.minus(number2);
    }
  },
  MULTIPLY("*") {
    @Override
    public Number operate(Number number1, Number number2) {
      return number1.multiply(number2);
    }
  },
  DIVIDE("/") {
    @Override
    public Number operate(Number number1, Number number2) {
      return number1.divide(number2);
    }
  };

  private final String operator;

  private OperatorStrategy(String operator) {
    this.operator = operator;
  }

  public static OperatorStrategy getStrategy(String operator) {
    return Arrays.stream(values())
        .filter(operatorEnum -> operatorEnum.operator.equals(operator))
        .findAny().orElseThrow(() -> new InvalidOperatorException("잘못된 연산자입니다. 연산자 : " + operator));
  }
}
