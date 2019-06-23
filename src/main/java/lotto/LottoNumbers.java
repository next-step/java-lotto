package lotto;

import java.util.List;
import java.util.Objects;

public class LottoNumbers {

  List<LottoNumber> lottoNumbers;

  public LottoNumbers(List<LottoNumber> lottoNumbers) {
    this.lottoNumbers = lottoNumbers;
  }

  public Object getSize() {
    return lottoNumbers.size();
  }

  public List<LottoNumber> getValues() {
    return lottoNumbers;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LottoNumbers that = (LottoNumbers) o;
    return Objects.equals(lottoNumbers, that.lottoNumbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottoNumbers);
  }

  @Override
  public String toString() {
    return "LottoNumbers{" +
        "lottoNumbers=" + lottoNumbers +
        '}';
  }
}
