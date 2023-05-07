package lotto3.domain;

import java.util.Objects;

public class LottoNumber {

  private static final int LOTTO_NUMBER_START = 1;
  private static final int LOTTO_NUMBER_END = 45;
  private final int number;

  public LottoNumber(int number) {
    validateIsBetweenOneAndFortyFive(number);
    this.number = number;
  }

  private void validateIsBetweenOneAndFortyFive(int number) {
    if (!isBetweenOneAndFortyFive(number)) {
      throw new IllegalArgumentException("로또 번호는 1부터 45까지의 숫자만 가능합니다.");
    }
  }

  private boolean isBetweenOneAndFortyFive(int number) {
    return number >= LOTTO_NUMBER_START && number <= LOTTO_NUMBER_END;
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


}
