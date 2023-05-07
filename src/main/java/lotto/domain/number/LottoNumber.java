package lotto.domain.number;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber {

  private final int number;

  private static final Map<Integer, LottoNumber> lottoNumberCacheMap = new HashMap<>();

  public LottoNumber(int number) {
    throwIfNotPositiveDigit(number);
    this.number = number;
  }

  public static LottoNumber of (int number) {
    LottoNumber lottoNumber = lottoNumberCacheMap.get(number);
    if (lottoNumber != null) {
      return lottoNumber;
    }

    LottoNumber newLottoNumber = new LottoNumber(number);
    lottoNumberCacheMap.put(number, newLottoNumber);
    return newLottoNumber;
  }

  private void throwIfNotPositiveDigit(int number) {
    if (number <= 0) {
      throw new IllegalArgumentException("로또 번호는 0 또는 음수 일 수 없습니다.");
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

  @Override
  public String toString() {
    return String.valueOf(number);
  }
}
