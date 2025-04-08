package lotto.domain;

import java.util.Objects;

public class LottoNumber {
  public static final int MIN_LOTTO_NUMBER = 1;
  public static final int MAX_LOTTO_NUMBER = 45;

  private final int number;

  public LottoNumber(int number) {
    validate(number);
    this.number = number;
  }

  private void validate(int number) {
    if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
      throw new IllegalArgumentException("로또 번호는 1부터 45 사이여야 합니다.");
    }
  }

  public int getNumber() {
    return number;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoNumber that = (LottoNumber) o;
    return number == that.number;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }
}
