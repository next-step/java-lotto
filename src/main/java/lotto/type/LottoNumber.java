package lotto.type;


import lotto.strategy.LottoCreateStrategy;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
  public static final int LOTTO_MAX_NUM = 45;
  public static final int LOTTO_MIN_NUM = 1;

  private final int value;

  public LottoNumber(int value) {
    if (value > LOTTO_MAX_NUM || value < LOTTO_MIN_NUM) {
      throw new IllegalArgumentException("유효하지 않은 보너스 숫자입니다.");
    }
    this.value = value;
  }

  public static LottoNumber byStrategy(LottoCreateStrategy lottoCreateStrategy) {
    return new LottoNumber(lottoCreateStrategy.pick(LOTTO_MIN_NUM, LOTTO_MAX_NUM));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoNumber that = (LottoNumber) o;
    return value == that.value;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }

  @Override
  public int compareTo(LottoNumber that) {
    return Integer.compare(this.value, that.value);
  }

  @Override
  public String toString() {
    return Integer.toString(value);
  }
}
