package lotto.domain.entity;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

  private static final String NOT_VALID_LOTTO_NUMBER_ERROR = "유효한 로또 번호가 아닙니다.";
  private static final int LOTTO_MAX_NUMBER = 45;

  private final int number;

  public LottoNumber (int number) {
    if (number > LOTTO_MAX_NUMBER) {
      throw new IllegalArgumentException(NOT_VALID_LOTTO_NUMBER_ERROR);
    }
    this.number = number;
  }

  public int getNumber() {
    return number;
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

  @Override
  public int compareTo(LottoNumber o) {
    return Integer.compare(o.getNumber(), this.number);
  }
}
