package stringCalculator;

public class Number {
  final int value;

  public Number(int value) {
    this.value = value;
  }
  public Number(String value) {
    this(Integer.parseInt(value));
  }

}
