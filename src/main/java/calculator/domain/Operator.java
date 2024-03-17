package calculator.domain;

import java.util.List;
import java.util.Objects;

public class Operator {

  public static final String THIS_OPERATOR_IS_NOT_SUPPORTED = "%s(은)는 지원하지 않는 연산자 입니다. 입력 값을 다시 확인해주세요.";

  public static final List<String> OPERATORS = List.of("+", "-", "/", "*");
  private final String operator;

  public Operator(String operator) {
    this.operator = operator;
  }

  public static boolean isOperator( String value) {
    if (!OPERATORS.contains(value)) {
      throw new IllegalArgumentException(String.format(THIS_OPERATOR_IS_NOT_SUPPORTED, value));
    }

    return Boolean.TRUE;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Operator operator1 = (Operator) o;
    return Objects.equals(operator, operator1.operator);
  }

  @Override
  public int hashCode() {
    return Objects.hash(operator);
  }
}
