package calculator.domain;

import calculator.domain.type.StringOperator;

import java.util.Objects;

public class Operator {

  private final StringOperator operator;

  public Operator(StringOperator operator) {
    this.operator = operator;
  }

  public static Operator of(String input) {
    return new Operator(StringOperator.convert(input));
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
