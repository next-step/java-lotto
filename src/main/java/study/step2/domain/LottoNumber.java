package study.step2.domain;

import java.util.Objects;
import java.util.Set;

public class LottoNumber {

  private Set<Integer> lottoNumbers;

  public LottoNumber(Set<Integer> lottoNumbers) {
    this.lottoNumbers = lottoNumbers;
  }

  public Set<Integer> getLottoNumbers() {
    return lottoNumbers;
  }

  public boolean isContains(int lottoNumber) {
    return lottoNumbers.contains(lottoNumber);
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
    return Objects.equals(lottoNumbers, that.lottoNumbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottoNumbers);
  }

  @Override
  public String toString() {
    return lottoNumbers.toString();
  }

}
