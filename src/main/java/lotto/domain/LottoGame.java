package lotto.domain;

import lotto.domain.strategy.NumberGenerator;

public class LottoGame {

  public static final int GAME_PRICE = 1000;
  private final LottoNumbers lottoNumbers;

  private LottoGame(LottoNumbers lottoNumbers) {
    this.lottoNumbers = lottoNumbers;
  }

  public static LottoGame from(String lottoNumbers) {
    return new LottoGame(LottoNumbers.from(lottoNumbers));
  }

  public static LottoGame from(NumberGenerator numberGenerator) {
    return new LottoGame(LottoNumbers.from(numberGenerator.generate()));
  }

  public LottoReword draw(LottoNumbers winNumbers, LottoNumber bonusNumber) {
    int matchCount = lottoNumbers.getMatchNumbers(winNumbers);
    boolean isBonusMatch = winNumbers.isBonusMatch(bonusNumber);
    return LottoReword.getReword(matchCount, isBonusMatch);
  }

  public LottoNumbers getLottoNumbers() {
    return lottoNumbers;
  }
}
