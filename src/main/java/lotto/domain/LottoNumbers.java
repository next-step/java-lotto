package lotto.domain;

import lotto.function.GenerateNumbers;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoNumbers {
  private static final int LOTTO_NUMBER_TOTAL_COUNT = 6;
  private static final String EXCEPTION_MESSAGE = "로또는 6자리 숫자로 생성해야 됩니다.";

  private final List<LottoNumber> values;

  private LottoNumbers(List<LottoNumber> values) {
    this.values = Collections.unmodifiableList(values);
  }

  public static LottoNumbers generateSixNumbers(final GenerateNumbers generateNumbers) {
    List<LottoNumber> lottoNumbers = generateNumbers.get();
    if (lottoNumbers.size() != LOTTO_NUMBER_TOTAL_COUNT) {
      throw new IllegalArgumentException(EXCEPTION_MESSAGE);
    }
    return new LottoNumbers(lottoNumbers);
  }

  public int size() {
    return values.size();
  }

  public int matchLottoNumber(final LottoNumbers otherNumbers) {
    return (int) values.stream()
            .filter(otherNumbers::contains)
            .count();
  }

  public boolean contains(LottoNumber lottoNumber) {
    return values.contains(lottoNumber);
  }

  public List<LottoNumber> getValues() {
    return values;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoNumbers that = (LottoNumbers) o;
    return Objects.equals(values, that.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(values);
  }

  @Override
  public String toString() {
    return String.valueOf(values);
  }
}
