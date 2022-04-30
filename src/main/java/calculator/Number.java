package calculator;

public final class Number {

  private final int number;

  public static Number from(String value) {
    return new Number(Integer.parseInt(value));
  }

  private Number(int number) {
    this.number = number;
  }
}
