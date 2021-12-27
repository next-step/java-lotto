package lotto.domain;

public class Money {

  private final long value;

  public Money(long value) {
    validate(value);
    this.value = value;
  }

  public long getValue() {
    return value;
  }

  private void validate(long value) {
    if (value < 0) {
      throw new IllegalArgumentException("Money must be be more than 0.");
    }
  }
}
