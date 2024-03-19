package caculator.domain;

import java.util.Map;
import java.util.function.BiFunction;

public enum Operator {
  PLUS("+", (op1, op2) -> new Number(op1.value() + op2.value())),
  MINUS("-", (op1, op2) -> new Number(op1.value() - op2.value())),
  MULTIPLY("*", (op1, op2) -> new Number(op1.value() * op2.value())),
  DIVIDE("/", (op1, op2) -> new Number(op1.value() / op2.value()));

  private final String symbol;
  private final BiFunction<Number, Number, Number> operator;

  Operator(String symbol, BiFunction<Number, Number, Number> operator) {
    this.symbol = symbol;
    this.operator = operator;
  }
  private final static Map<String, Operator> operatorMap = Map.of("+", PLUS, "-", MINUS, "*", MULTIPLY, "/", DIVIDE);

  public static Operator of(String symbol) {
    return operatorMap.get(symbol);
  }

  public Number operate(Number op1, Number op2) {
    return this.operator.apply(op1, op2);
  }
}
