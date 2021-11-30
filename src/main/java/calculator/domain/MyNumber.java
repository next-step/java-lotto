package calculator.domain;

public class MyNumber {

  private final int value;

  public MyNumber(int value) {
    if (isNegativeNumber(value)) {
      throw new RuntimeException();
    }

    this.value = value;
  }

  public static MyNumber parse(String number) {
    try {
      return new MyNumber(Integer.parseInt(number));
    } catch (RuntimeException e) {
      throw new RuntimeException();
    }
  }

  public int getValue() {
    return value;
  }

  private boolean isNegativeNumber(int number) {
    return number < 0;
  }
}
