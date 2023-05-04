package study.lottogame.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

  public static final int MAX_LOTTO_NUMBER = 45;
  public static final int MIN_LOTTO_NUMBER = 1;

  private static class LottoNumberCache {

    static final LottoNumber[] cache = new LottoNumber[MAX_LOTTO_NUMBER - MIN_LOTTO_NUMBER + 1];

    static {
      int value = MIN_LOTTO_NUMBER;
      for (int i = 0; i < cache.length; i++) {
        cache[i] = new LottoNumber(value++);
      }
    }

    private LottoNumberCache() {
    }
  }

  private int lottoNumber;

  private LottoNumber(int lottoNumber) {
    this.lottoNumber = lottoNumber;
  }

  public static LottoNumber valueOf(final int lottoNumber) {
    if (lottoNumber < MIN_LOTTO_NUMBER || lottoNumber > MAX_LOTTO_NUMBER) {
      throw new IllegalArgumentException("유효한 입력이 아닙니다.");
    }

    return LottoNumberCache.cache[lottoNumber - MIN_LOTTO_NUMBER];
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
