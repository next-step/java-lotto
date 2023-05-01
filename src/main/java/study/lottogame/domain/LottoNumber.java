package study.lottogame.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

  public static final int MAX_LOTTO_NUMBER = 45;

  private int lottoNumber;

  public LottoNumber(int lottoNumber) {
    if (lottoNumber <= 0 || lottoNumber > MAX_LOTTO_NUMBER) {
      throw new IllegalArgumentException("유효한 입력이 아닙니다.");
    }

    this.lottoNumber = lottoNumber;
  }

  @Override
  public int compareTo(LottoNumber o) {
    return lottoNumber - o.lottoNumber;
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
    return lottoNumber == that.lottoNumber;
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottoNumber);
  }

  @Override
  public String toString() {
    return "" + lottoNumber;
  }
}
