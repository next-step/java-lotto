package lotto.domain;

import lotto.domain.strategy.NumberGenerator;
import lotto.exception.InvalidLottoGameException;

public class LottoGame {

  private static final int NUMBER_COUNT = 6;
  private final LottoNumbers lottoNumbers;

  public LottoGame(String lottoNumbers) {
    checkNumberLength(lottoNumbers);
    this.lottoNumbers = new LottoNumbers(lottoNumbers);
  }

  private void checkNumberLength(String lottoNumbers) {
    int numberLength = lottoNumbers.split(LottoNumbers.LOTTO_NUMBER_DELIMITER).length;
    if (numberLength != NUMBER_COUNT) {
      throw new InvalidLottoGameException(NUMBER_COUNT);
    }
  }

  public LottoGame(NumberGenerator numberGenerator) {
    this.lottoNumbers = new LottoNumbers(NUMBER_COUNT, numberGenerator);
  }

  public LottoDrawResult draw(LottoNumbers winNumbers) {
    int matchCount = lottoNumbers.getMatchNumbers(winNumbers).getNumberSize();
    return new LottoDrawResult(matchCount, LottoReword.getWinMoney(matchCount));
  }

}
