package calculator;

import java.util.regex.Pattern;

public class OperatorFactory {

  private static Pattern OPERATOR_PATTERN = Pattern.compile("[+\\-*/]");

  public static final String PLUS_OPERATOR = "+";
  public static final String MINUS_OPERATOR = "-";
  public static final String TIMES_OPERATOR = "*";
  public static final String DIVIDE_OPERATOR = "/";

  private OperatorFactory() {
  }

  public static Operator from(final String operator) {
    if (!isOperator(operator)) {
      throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
    }

    if (PLUS_OPERATOR.equals(operator)) {
      return new PlusOperator();
    } else if (MINUS_OPERATOR.equals(operator)) {
      return new MinusOperator();
    } else if (TIMES_OPERATOR.equals(operator)) {
      return new TimesOperator();
    } else if (DIVIDE_OPERATOR.equals(operator)) {
      return new DivideOperator();
    }
    throw new IllegalStateException("정의되지 않은 연산자 입니다.");
  }

  private static boolean isOperator(final String operator) {
    return OPERATOR_PATTERN.matcher(operator).matches();
  }

}
