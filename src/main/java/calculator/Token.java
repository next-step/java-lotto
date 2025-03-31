package calculator;

import java.util.Arrays;

public class Token {

  private static final String[] OPERATORS = {"*", "/", "+", "-"};

  private final String value;

  private Token(String value) {
    this.value = value;
  }

  public static Token from(String value) {
    return new Token(value);
  }

  public boolean isOperator() {
    return Arrays.asList(OPERATORS).contains(value);
  }

  public boolean isNumeric() {
    try {
      Integer.parseInt(value);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  public boolean isNotValid() {
    return !isNumeric() && !isOperator();
  }

  public String getValue() {
    return value;
  }

  public int toInt() {
    return Integer.parseInt(value);
  }
} 