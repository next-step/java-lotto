package lotto.domain;

public class Money {

  private final int value;

  public Money(int value) {
    validate(value);
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  private void validate(int value) {
    if (value < 0) {
      throw new IllegalArgumentException("Money must be be more than 0.");
    }
  }
}
