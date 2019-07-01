package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber {

  private static final int LOTTO_NUMBER_MIN = 1;
  private static final int LOTTO_NUMBER_MAX = 45;
  private static final Map<Integer, LottoNumber> cache = new HashMap<>();

  private final int number;

  static {
    for (int i = LOTTO_NUMBER_MIN; i < LOTTO_NUMBER_MAX + 1; i++) {
      cache.put(i, new LottoNumber(i));
    }
  }

  private LottoNumber(int number) {
    this.number = number;
  }

  public static LottoNumber of(int number) {
    LottoNumber lottoNumber = cache.get(number);
    if (lottoNumber == null) {
      throw new IllegalArgumentException("로또 번호가 범위내의 숫자가 아닙니다.");
    }
    return lottoNumber;
  }

  public static LottoNumber of(String text) {
    return of(Integer.parseInt(text));
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

  @Override
  public String toString() {
    return String.valueOf(number);
  }
}
