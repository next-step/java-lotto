package calculator.domain;

public enum Operator {
  PLUS("+") {
    @Override
    public int apply(int a, int b) {
      return a + b;
    }
  },
  MINUS("-") {
    @Override
    public int apply(int a, int b) {
      return a - b;
    }
  },
  MULTIPLY("*") {
    @Override
    public int apply(int a, int b) {
      return a * b;
    }
  },
  DIVIDE("/") {
    @Override
    public int apply(int a, int b) {
      return a / b;
    }
  };

  private final String symbol;

  Operator(String symbol) {
    this.symbol = symbol;
  }

  public static Operator from(String symbol) {
    for (Operator operator : values()) {
      if (operator.symbol.equals(symbol)) {
        return operator;
      }
    }
    throw new IllegalArgumentException("유효하지 않은 연산자입니다: " + symbol);
  }

  public abstract int apply(int a, int b);

  @Override
  public String toString() {
    return this.symbol;
  }
}