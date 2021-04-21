package lotto.domain;

import calculator.util.StringUtil;
import lotto.function.GenerateNumbers;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumbers {
  private static final int SIZE = 6;
  private static final String ERROR_DIGITS_EXCEED_FORMAT = "로또는 %d자리 숫자로 생성해야 됩니다.";

  private final List<LottoNumber> values;

  private LottoNumbers(List<LottoNumber> values) {
    this.values = Collections.unmodifiableList(values);
  }

  public static LottoNumbers generateSixNumbers(final GenerateNumbers generateNumbers) {
    List<LottoNumber> lottoNumbers = generateNumbers.get();
    if (lottoNumbers.size() != SIZE) {
      throw new IllegalArgumentException(String.format(ERROR_DIGITS_EXCEED_FORMAT, SIZE));
    }
    return new LottoNumbers(lottoNumbers);
  }

  public static LottoNumbers generateSixNumbersFromStringNumbers(final String generateNumbers) {
    return generateSixNumbers(() -> StringUtil.splitToList(generateNumbers)
            .stream()
            .map(StringUtil::splitToList)
            .flatMap(List::stream)
            .map(StringUtil::trim)
            .map(Integer::parseInt)
            .map(LottoNumber::generate)
            .collect(Collectors.toList()));
  }

  public int size() {
    return values.size();
  }

  public int matchLottoNumber(final LottoNumbers other) {
    return (int) values.stream()
            .filter(other::contains)
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
