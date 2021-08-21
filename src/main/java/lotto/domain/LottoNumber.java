package lotto.domain;

import java.util.Objects;

public class LottoNumber {

  private static final int MIN = 1;
  private static final int MAX = 45;
  private final int number;

  public LottoNumber(int number) {
    checkNumber(number);
    this.number = number;
  }

  private void checkNumber(int number) {
    if (number < MIN || number > MAX) {
      throw new IllegalArgumentException(
          "생성 가능한 로또 번호는 " + MIN + "부터 " + MAX + "까지입니다.");
    }
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
