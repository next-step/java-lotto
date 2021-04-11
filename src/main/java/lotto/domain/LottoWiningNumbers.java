package lotto.domain;

import calculator.util.StringUtil;
import lotto.function.GenerateNumbers;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoWiningNumbers {
  private final LottoNumbers value;

  private LottoWiningNumbers(LottoNumbers value) {
    this.value = value;
  }

  public static LottoWiningNumbers generate(final GenerateNumbers generateNumbers) {
    return new LottoWiningNumbers(LottoNumbers.generateSixNumbers(generateNumbers));
  }

  public static LottoWiningNumbers generate(final String winningNumbersString) {
    final List<LottoNumber> lottoWiningNumbers = StringUtil.splitToList(winningNumbersString)
            .stream()
            .map(StringUtil::trim)
            .map(Integer::parseInt)
            .map(LottoNumber::generate)
            .collect(Collectors.toList());
    return generate(() -> lottoWiningNumbers);
  }

  public int matchLottoNumber(final LottoNumbers lottoNumbers) {
    return value.matchLottoNumber(lottoNumbers);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoWiningNumbers that = (LottoWiningNumbers) o;
    return Objects.equals(value, that.value);
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
