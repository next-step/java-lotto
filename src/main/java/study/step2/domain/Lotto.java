package study.step2.domain;

import java.util.Objects;
import java.util.Set;

public class Lotto {

  private Set<Integer> lottoNumbers;

  public Lotto() {
  }

  public Lotto(Set<Integer> lottoNumbers) {
    this.lottoNumbers = lottoNumbers;
  }

  public Set<Integer> getLottoNumbers() {
    return lottoNumbers;
  }

  public int matchCount(Set<Integer> lottoNumbers) {
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
