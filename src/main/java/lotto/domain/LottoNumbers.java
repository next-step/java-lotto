package lotto.domain;

import lotto.function.GenerateNumbers;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumbers {
  private final List<LottoNumber> lottoNumbers;

  private LottoNumbers(List<LottoNumber> lottoNumbers) {
    this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
  }

  public static LottoNumbers generateSixNumbers(final GenerateNumbers generateNumbers) {
    List<LottoNumber> lottoNumbers = generateNumbers.get();
    if (lottoNumbers.size() != 6) {
      throw new IllegalArgumentException("로또는 6자리 숫자로 생성해야 됩니다.");
    }
    return new LottoNumbers(lottoNumbers);
  }

  public int size() {
    return lottoNumbers.size();
  }

  public int matchLottoNumber(final LottoNumbers otherNumber) {
    return lottoNumbers.stream()
            .filter(lottoNumber -> otherNumber.lottoNumbers.contains(lottoNumber))
            .collect(Collectors.toList())
            .size();
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
