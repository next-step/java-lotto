package caculator.domain;

import java.util.Map;

public enum Operator {
  PLUS() {
    @Override
    public Number operate(Number op1, Number op2) {
      return new Number(op1.value() + op2.value());
    }
  },
  MINUS() {
    @Override
    public Number operate(Number op1, Number op2) {
      return new Number(op1.value() - op2.value());
    }
  },
  MULTIPLY() {
    @Override
    public Number operate(Number op1, Number op2) {
      return new Number(op1.value() * op2.value());
    }
  },
  DIVIDE() {
    @Override
    public Number operate(Number op1, Number op2) {
      return new Number(op1.value() / op2.value());
    }
  };

  private final static Map<String, Operator> operatorMap = Map.of("+", PLUS, "_", MINUS, "*", MULTIPLY, "/", DIVIDE);

  public static Operator of(String symbol) {
    return operatorMap.get(symbol);
  }

  abstract public Number operate(Number op1, Number op2);
}
