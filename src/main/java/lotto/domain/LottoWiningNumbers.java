package lotto.domain;

import lotto.function.GenerateNumbers;

import java.util.Objects;

public class LottoWiningNumbers {
  private final LottoNumbers lottoWinningNumbers;

  private LottoWiningNumbers(LottoNumbers lottoWinningNumbers) {
    this.lottoWinningNumbers = lottoWinningNumbers;
  }

  public static LottoWiningNumbers generate(final GenerateNumbers generateNumbers) {
    return new LottoWiningNumbers(LottoNumbers.generateSixNumbers(generateNumbers));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoWiningNumbers that = (LottoWiningNumbers) o;
    return Objects.equals(lottoWinningNumbers, that.lottoWinningNumbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottoWinningNumbers);
  }

  @Override
  public String toString() {
    return String.valueOf(lottoWinningNumbers);
  }
}
