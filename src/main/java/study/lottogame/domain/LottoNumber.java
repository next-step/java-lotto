package study.lottogame.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

  public static final int MAX_LOTTO_NUMBER = 45;
  public static final int MIN_LOTTO_NUMBER = 1;

  private static class LottoNumberCache {

    static final Map<Integer, LottoNumber> cacheMap = new HashMap<>();

    static {
      for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
        cacheMap.put(i, new LottoNumber(i));
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
      throw new IllegalArgumentException(
          "로또번호는 " + MIN_LOTTO_NUMBER + "~" + MAX_LOTTO_NUMBER + "범위로 입력 가능합니다.");
    }

    return LottoNumberCache.cacheMap.get(lottoNumber);
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
