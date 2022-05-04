package calculator;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.BinaryOperator;

public enum ArithmeticOperator implements Operator {

  PLUS("+", Operand::plus),
  MINUS("-", Operand::minus),
  TIMES("*", Operand::times),
  DIVIDE("/", Operand::divide);

  private final String symbol;
  private final BinaryOperator<Operand> calculateOperator;

  ArithmeticOperator(String symbol, BinaryOperator<Operand> calculateOperator) {
    this.symbol = symbol;
    this.calculateOperator = calculateOperator;
  }

  public static ArithmeticOperator findBySymbol(final String symbol) {
    return Arrays.stream(ArithmeticOperator.values())
        .filter(operator -> Objects.equals(operator.symbol, symbol))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("정의되지 않은 연산자 입니다."));
  }

  public Operand calculate(Operand op1, Operand op2) {
    return calculateOperator.apply(op1, op2);
  }


}
