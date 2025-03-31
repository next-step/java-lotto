package calculator;

public enum Operator {
  PLUS("+") {
    @Override
    public int calculate(int left, int right) {
      return left + right;
    }
  },
  MINUS("-") {
    @Override
    public int calculate(int left, int right) {
      return left - right;
    }
  },
  MULTIPLY("*") {
    @Override
    public int calculate(int left, int right) {
      return left * right;
    }
  },
  DIVIDE("/") {
    @Override
    public int calculate(int left, int right) {
      return left / right;
    }
  };

  private final String symbol;

  Operator(String symbol) {
    this.symbol = symbol;
  }

  public static Operator fromSymbol(String symbol) {
    for (Operator operator : values()) {
      if (operator.symbol.equals(symbol)) {
        return operator;
      }
    }
    throw new IllegalArgumentException("지원하지 않는 연산자입니다: " + symbol);
  }

  public abstract int calculate(int left, int right);
} 