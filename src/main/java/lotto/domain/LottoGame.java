package lotto.domain;

import lotto.domain.strategy.NumberGenerator;
import lotto.exception.InvalidLottoGameException;

public class LottoGame {

  public static final int NUMBER_COUNT = 6;
  public static final int GAME_PRICE = 1000;
  private final LottoNumbers lottoNumbers;

  private LottoGame(LottoNumbers lottoNumbers) {
    this.lottoNumbers = lottoNumbers;
  }

  public static LottoGame from(String lottoNumbers) {
    checkNumberLength(lottoNumbers);
    return new LottoGame(LottoNumbers.from(lottoNumbers));
  }

  public static LottoGame from(NumberGenerator numberGenerator) {
    return new LottoGame(LottoNumbers.from(numberGenerator.generate()));
  }

  public LottoReword draw(LottoNumbers winNumbers, LottoNumber bonusNumber) {
    int matchCount = lottoNumbers.getMatchNumbers(winNumbers).getNumberSize();
    boolean isBonusMatch = winNumbers.isBonusMatch(bonusNumber);
    return LottoReword.getReword(matchCount, isBonusMatch);
  }

  public LottoNumbers getLottoNumbers() {
    return lottoNumbers;
  }

  private static void checkNumberLength(String lottoNumbers) {
    int numberLength = lottoNumbers.split(LottoNumbers.LOTTO_NUMBER_DELIMITER).length;
    if (numberLength != NUMBER_COUNT) {
      throw new InvalidLottoGameException(NUMBER_COUNT);
    }
  }
}
