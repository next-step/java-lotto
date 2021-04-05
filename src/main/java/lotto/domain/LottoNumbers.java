package lotto.domain;

import lotto.function.GenerateNumbers;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoNumbers {
  private final List<LottoNumber> lottoNumbers;

  private LottoNumbers(List<LottoNumber> lottoNumbers) {
    this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
  }

  public static LottoNumbers generateSixNumbers(final GenerateNumbers generateNumbers) {
    return new LottoNumbers(generateNumbers.get());
  }

  public int size() {
    return lottoNumbers.size();
  }

  public List<LottoNumber> getLottoNumbers() {
    return lottoNumbers;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoNumbers that = (LottoNumbers) o;
    return Objects.equals(lottoNumbers, that.lottoNumbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottoNumbers);
  }

  @Override
  public String toString() {
    return String.valueOf(lottoNumbers);
  }
}
