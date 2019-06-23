package lotto;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

  public static final int BOUNDARY_LOTTO_NUMBER = 45;

  private int number;

  public LottoNumber(int number) {
    if (number < 0 || number > BOUNDARY_LOTTO_NUMBER) {
      throw new IllegalArgumentException("로또 번호는 1 ~ 45 여야 합니다.");
    }
    this.number = number;
  }

  public int getValue() {
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
  public String toString() {
    return "LottoNumber{" +
        "number=" + number +
        '}';
  }


  @Override
  public int compareTo(LottoNumber o) {
    return this.getValue() - o.getValue();
  }
}
