package calculator;

public class Operand {

  private final Integer value;

  public static Operand valueOf(String value) {
    return new Operand(value);
  }

  public static Operand valueOf(Integer value) {
    return new Operand(value);
  }

  private Operand(String value) {
    this(Integer.parseInt(value));
  }

  private Operand(Integer value) {
    this.value = value;
  }

  public Operand plus(Operand operand) {
    return new Operand(this.value + operand.getValue());
  }

  public Operand minus(Operand operand) {
    return new Operand(this.value - operand.getValue());
  }

  public Operand times(Operand operand) {
    return new Operand(this.value * operand.getValue());
  }

  public Operand divide(Operand operand) {
    return new Operand(this.value / operand.getValue());
  }

  public Integer getValue() {
    return value;
  }
}
