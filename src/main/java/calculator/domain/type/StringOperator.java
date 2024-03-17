package calculator.domain.type;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public enum StringOperator {
  ADDITION("+"),
  SUBTRACTION("-"),
  DIVISION("/"),
  MULTIPLICATION("*");

  private final String operator;

  StringOperator(String operator) {
    this.operator = operator;
  }

  public static List<String> allOperators() {
    return Arrays.stream(StringOperator.values()).map(it -> it.operator).collect(Collectors.toList());
  }

  public static Optional<StringOperator> convert(String value) {
    return Arrays.stream(StringOperator.values())
        .filter(it -> it.operator.equals(value))
        .findFirst();
  }

  public String getOperator() {
    return operator;
  }
}
