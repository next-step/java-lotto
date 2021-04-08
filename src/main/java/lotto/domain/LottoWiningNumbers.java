package lotto.domain;

import calculator.util.StringUtil;
import lotto.function.GenerateNumbers;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoWiningNumbers {
  private final LottoNumbers list;

  private LottoWiningNumbers(LottoNumbers list) {
    this.list = list;
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
    return list.matchLottoNumber(lottoNumbers);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoWiningNumbers that = (LottoWiningNumbers) o;
    return Objects.equals(list, that.list);
  }

  @Override
  public int hashCode() {
    return Objects.hash(list);
  }

  @Override
  public String toString() {
    return String.valueOf(list);
  }
}
