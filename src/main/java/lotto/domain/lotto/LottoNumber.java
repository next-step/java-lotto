package lotto.domain.lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber {

  private static final Map<Integer, LottoNumber> CACHE = new HashMap<>();

  static {
    for (int i = 1; i <= 45; i++) {
      CACHE.put(i, new LottoNumber(i));
    }
  }

  private final int value;

  private LottoNumber(int value) {
    this.value = value;
  }

  public static LottoNumber of(int value) {
    validate(value);
    return CACHE.get(value);
  }

  private static void validate(int value) {
    if (value < 1 || value > 45) {
      throw new IllegalArgumentException("로또 넘버는 1이상 45이하의 수입니다");
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LottoNumber that = (LottoNumber) o;
    return value == that.value;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }

  @Override
  public String toString() {
    return Integer.toString(value);
  }
}