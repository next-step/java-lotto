package lotto.domain;

public class LottoWiningNumbers {
  private final LottoNumbers lottoWinningNumbers;

  private LottoWiningNumbers(LottoNumbers lottoWinningNumbers) {
    this.lottoWinningNumbers = lottoWinningNumbers;
  }

  public static LottoWiningNumbers generate() {
    return new LottoWiningNumbers(LottoNumbers.generateSixNumbers());
  }

}
