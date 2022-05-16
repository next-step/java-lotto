package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber {

  public static final int MIN_LOTTO_NUMBER = 1;
  public static final int MAX_LOTTO_NUMBER = 45;
  private static final Map<Integer, LottoNumber> cachedLottoNumbers = new HashMap<>();

  private int number;

  static {
    IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
        .forEach(number -> cachedLottoNumbers.put(number, new LottoNumber(number)));
  }

  private LottoNumber(int number) {
    this.number = number;
  }

  public static LottoNumber from(String number) {
    return from(Integer.parseInt(number));
  }

  public static LottoNumber from(int number) {
    LottoNumber lottoNumber = cachedLottoNumbers.get(number);
    if (lottoNumber == null) {
      throw new IllegalArgumentException("로또번호가 1보다 작거나 45보다 클 수 없습니다.");
    }
    return lottoNumber;
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
