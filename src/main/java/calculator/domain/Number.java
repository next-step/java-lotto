package calculator.domain;

public class Number {

  private int value;

  public Number(String value) {
    this(Integer.parseInt(value));
  }

  public Number(int value) {
    this.value = value;
  }

  public Number apply(Operator operator, Number other) {
    return new Number(operator.apply(this.value, other.value));
  }

  public int getValue() {
    return this.value;
  }

}
