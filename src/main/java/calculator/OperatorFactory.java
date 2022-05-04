package calculator;

import java.util.regex.Pattern;

public class OperatorFactory {

  private static final Pattern OPERATOR_PATTERN = Pattern.compile("[+\\-*/]");

  private OperatorFactory() {
  }

  public static Operator from(final String symbol) {
    if (!isOperator(symbol)) {
      throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
    }

    return ArithmeticOperator.findBySymbol(symbol);
  }

  private static boolean isOperator(final String operator) {
    return OPERATOR_PATTERN.matcher(operator).matches();
  }

}
