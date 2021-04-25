package study.step2.domain;

import java.util.List;
import java.util.Objects;

public class Lotto {

  private List<Integer> lottoNumbers;

  public Lotto() {
  }

  public Lotto(List<Integer> lottoNumbers) {
    this.lottoNumbers = lottoNumbers;
  }

  public List<Integer> getLottoNumbers() {
    return lottoNumbers;
  }

  public int matchCount(List<Integer> lottoNumbers) {
    return (int) this.lottoNumbers.stream()
        .filter(lottoNumbers::contains)
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
    return Objects.equals(lottoNumbers, lotto.lottoNumbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottoNumbers);
  }

}
