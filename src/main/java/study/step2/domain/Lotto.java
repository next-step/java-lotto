package study.step2.domain;

import java.util.Objects;

public class Lotto {

  private LottoNumber lottoNumber;

  public Lotto() {
  }

  public Lotto(LottoNumber lottoNumber) {
    this.lottoNumber = lottoNumber;
  }

  public LottoNumber getLottoNumbers() {
    return lottoNumber;
  }

  public int matchCount(LottoNumber winningLottoNumber) {
    return (int) lottoNumber.getLottoNumbers().stream()
        .filter(winningLottoNumber::isContains)
        .count();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Lotto lotto = (Lotto) o;
    return Objects.equals(lottoNumber, lotto.lottoNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottoNumber);
  }
}
