package lotto.domain;

import java.util.Objects;

public class LottoNumber {
  private final int number;

  public static final int MIN_NUMBER = 1;
  public static final int MAX_NUMBER = 45;

  public LottoNumber(int number) {
    if (number < MIN_NUMBER || number > MAX_NUMBER) {
      throw new IllegalArgumentException("로또 번호는 " + MIN_NUMBER + "부터 " + MAX_NUMBER + "까지의 숫자여야 합니다.");
    }
    this.number = number;
  }

  public int getNumber() {
    return number;
  }

  @Override
  public String toString() {
    return String.valueOf(number);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LottoNumber that = (LottoNumber) o;
    return number == that.number;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }
}
