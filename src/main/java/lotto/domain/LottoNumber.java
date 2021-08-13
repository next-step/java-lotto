package lotto.domain;

import java.util.Objects;
import lotto.message.Message;

public class LottoNumber {

  public static final int LIMIT_MAX_NUMBER = 45;

  public static final int LIMIT_MIN_NUMBER = 0;

  private final int number;

  public LottoNumber(final int number) {
    isWrongNumber(number);
    this.number = number;
  }

  private void isWrongNumber(final int number) {
    if(number > LIMIT_MAX_NUMBER || number < LIMIT_MIN_NUMBER){
      throw new IllegalArgumentException(Message.MSG_ERROR_LIMIT_LOTTO_NUMBER);
    }
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final LottoNumber that = (LottoNumber) o;
    return number == that.number;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }

  @Override
  public String toString() {
    return String.valueOf(number);
  }
}
