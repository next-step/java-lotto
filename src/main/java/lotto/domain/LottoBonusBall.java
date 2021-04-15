package lotto.domain;

import java.util.Objects;

public class LottoBonusBall {
  private final LottoNumber value;

  private LottoBonusBall(LottoNumber value) {
    this.value = value;
  }

  public static LottoBonusBall valueOf(int number) {
    return new LottoBonusBall(LottoNumber.generate(number));
  }

  public boolean isMatch(LottoNumbers lottoNumbers) {
    return lottoNumbers.contains(value);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null) return false;

    if (o instanceof LottoBonusBall) {
      LottoBonusBall bonusBall = (LottoBonusBall) o;
      return Objects.equals(value, bonusBall.value);
    } else if (o instanceof LottoNumber) {
      LottoNumber lottoNumber = (LottoNumber) o;
      return o.equals(lottoNumber);
    }

    return this.getClass() == o.getClass();
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }
}
