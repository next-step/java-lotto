package domain;

import java.util.Arrays;
import java.util.List;

public class ExpressionValidation {

  private static final String DELIMITER = " ";
  private static final String[] Operators = {"+", "-", "*", "/"};
  private static final List<String> OperatorList = Arrays.asList(Operators);

  private ExpressionValidation() {
    throw new IllegalStateException("유틸리티 클래스를 인스턴스화할 수 없습니다!");
  }

  public static void validateExpression(String expression) {
    if (expression == null || expression.equals(DELIMITER)) {
      throw new IllegalArgumentException("입력된 값이 없습니다");
    }
  }

  public static void validateDenominator(int denominator) {
    if (denominator <= 0) {
      throw new IllegalArgumentException("분모값은 1 이상이어야 합니다");
    }
  }

  public static void validateOperator(String operator) {
    if (isOperator(operator) == false) {
      throw new IllegalArgumentException("존재하지 않는 연산자입니다");
    }
  }

  public static boolean isOperator(final String operator) {
    return OperatorList.contains(operator);
  }
}
