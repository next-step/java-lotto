package lotto.domain;

public class WinningConditions {

  private static final String BONUS_NUMBER_SHOULD_NOT_CONTAINED_WINNING_NUMBERS = "보너스 번호는 당첨 번호에 포함되지 않은 번호여야 합니다.";

  private final LottoGame winningGame;
  private final LottoNumber bonusNumber;

  private WinningConditions(LottoGame winningGame, LottoNumber bonusNumber) {
    this.winningGame = winningGame;
    this.bonusNumber = bonusNumber;
  }

  public static WinningConditions of(LottoGame winningGame, int bonusNumber) {
    LottoNumber bonusLottoNumber = new LottoNumber(bonusNumber);
    if(winningGame.matchBonusNumber(bonusLottoNumber)) {
      throw new IllegalArgumentException(BONUS_NUMBER_SHOULD_NOT_CONTAINED_WINNING_NUMBERS);
    }
    return new WinningConditions(winningGame, bonusLottoNumber);
  }

  public LottoRanking matchConditions(LottoGame lottoGame) {
    int matchCount = lottoGame.matchWinningNumbers(winningGame);
    boolean bonusNumberMatched = lottoGame.matchBonusNumber(bonusNumber);
    return LottoRanking.confirm(matchCount, bonusNumberMatched);
  }
}
