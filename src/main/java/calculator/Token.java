package calculator;

import calculator.operation.Addition;
import calculator.operation.Division;
import calculator.operation.Multiplication;
import calculator.operation.Operation;
import calculator.operation.Subtraction;
import java.util.HashMap;
import java.util.Map;

public class Token {

  public static final String OPERAND_PATTERN = "[0-9]+";
  public static final String OPERATOR_PATTERN = "[+\\-*/]";
  private static final Map<String, Operation> OPERATIONS_MAP = new HashMap<>();

  static {
    OPERATIONS_MAP.put("+", new Addition());
    OPERATIONS_MAP.put("-", new Subtraction());
    OPERATIONS_MAP.put("*", new Multiplication());
    OPERATIONS_MAP.put("/", new Division());
  }

  private final String value;

  public Token(String value) {
    this.value = value;
  }

  public boolean isOperand() {
    return value.matches(OPERAND_PATTERN);
  }

  public boolean isOperator() {
    return value.matches(OPERATOR_PATTERN);
  }

  public int asOperand() {
    if (!isOperand()) {
      throw new IllegalArgumentException("피연산자가 숫자가 아닙니다!");
    }
    return Integer.parseInt(value);
  }

  public Operation asOperator() {
    if (!isOperator()) {
      throw new IllegalArgumentException("유효한 연산자가 아닙니다!");
    }
    return OPERATIONS_MAP.get(value);
  }

}
