package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

  private static final int MIN_NUMBER = 1;
  private static final int MAX_NUMBER = 45;
  private static final Map<Integer, LottoNumber> CACHE = new HashMap<>();
  private static final String INVALID_NUMBER_MESSAGE = "1과 45 사이의 자연수만 입력할 수 있습니다.";

  private final int value;

  static {
    for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
      CACHE.put(i, new LottoNumber(i));
    }
  }

  private LottoNumber(int value) {
    validate(value);
    this.value = value;
  }

  public static LottoNumber of(int value) {
    validate(value);
    return CACHE.get(value);
  }

  private static void validate(int value) {
    if (value < MIN_NUMBER || value > MAX_NUMBER) {
      throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE);
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
    return value == that.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public int compareTo(LottoNumber o) {
    return Integer.compare(value, o.value);
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }
}
