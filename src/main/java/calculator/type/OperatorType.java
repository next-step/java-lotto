package calculator.type;

import java.util.HashMap;
import java.util.Map;

public enum OperatorType {
  ADD("+", (left, right) -> left + right) ,
  SUBTRACT("-", (left, right) -> left - right),
  MULTIPLY("*", (left, right) -> left * right),
  DIVIDE("/", (left, right) -> left / right);

  private static final Map<String, OperatorType> SYMBOL_TO_OPERATOR_MAP = new HashMap<>();

  private final String symbol;
  private final Operator operator;

  OperatorType(String symbol, Operator operator) {
    this.symbol = symbol;
    this.operator = operator;
  }

  static {
    for (OperatorType type : OperatorType.values()) {
      SYMBOL_TO_OPERATOR_MAP.put(type.symbol, type);
    }
  }

  public static OperatorType fromSymbol(String symbol) {
    OperatorType operatorType = SYMBOL_TO_OPERATOR_MAP.get(symbol);
    if (operatorType == null) {
      throw new IllegalArgumentException("Invalid operator symbol: " + symbol);
    }
    return operatorType;
  }

  public int execute(int left, int right) {
    return operator.calculate(left, right);
  }
}
