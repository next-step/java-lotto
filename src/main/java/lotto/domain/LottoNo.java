package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LottoNo implements Comparable<LottoNo> {

  public static final int MIN_NUMBER = 1;
  public static final int MAX_NUMBER = 45;
  private static final Map<Integer, LottoNo> CACHE = new HashMap<>();

  static {
    for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
      CACHE.put(i, new LottoNo(i));
    }
  }

  private final int number;

  private LottoNo(int number) {
    this.number = number;
  }

  public static Optional<LottoNo> of(int number) {
    if (number < MIN_NUMBER || number > MAX_NUMBER) {
      return Optional.empty();
    }
    return Optional.of(CACHE.get(number));
  }

  public static LottoNo from(int number) {
    return of(number)
        .orElseThrow(() -> new IllegalArgumentException(
            String.format("%d는 로또 번호가 될 수 없습니다. 로또 번호는 %d부터 %d 사이의 숫자여야 합니다.", number, MIN_NUMBER, MAX_NUMBER)));
  }

  public int getNumber() {
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
    LottoNo lottoNo = (LottoNo) o;
    return number == lottoNo.number;
  }

  @Override
  public int hashCode() {
    return number;
  }

  @Override
  public int compareTo(LottoNo other) {
    return Integer.compare(this.number, other.number);
  }
} 