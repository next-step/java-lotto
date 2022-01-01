package lotto.domain;

public class Money {

  private static final int MIN_VALUE = 0;
  private static final String WRONG_VALUE_EXCEPTION = "Money must be be more than 0.";
  private final long value;

  public Money(long value) {
    validateAndThrow(value);
    this.value = value;
  }

  public long value() {
    return value;
  }

  private void validateAndThrow(long value) {
    if (value < MIN_VALUE) {
      throw new IllegalArgumentException(WRONG_VALUE_EXCEPTION);
    }
  }
}
