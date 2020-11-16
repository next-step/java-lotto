package lotto.domain;

import lotto.domain.model.LottoNumber;
import lotto.exception.LottoGameException;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.constants.Message.BONUS_NUMBER_IS_NOT_UNIQUE;

public class LottoGameCondition {

  private final LottoGame prizeLottoGame;
  private final LottoNumber bonusNumber;

  public LottoGameCondition(LottoGame prizeLottoGame, LottoNumber bonusNumber) {
    validateBonusNumber(prizeLottoGame, bonusNumber);
    this.prizeLottoGame = prizeLottoGame;
    this.bonusNumber = bonusNumber;
  }

  public List<PrizeGrade> prizeResult(List<LottoGame> lastWeekWinGame) {
    return lastWeekWinGame.stream()
        .map(this::confirmPrize)
        .collect(Collectors.toList());
  }

  private void validateBonusNumber(LottoGame prizeLottoGame, LottoNumber bonusNumber) {
    if (prizeLottoGame.contains(bonusNumber)) {
      throw new LottoGameException(BONUS_NUMBER_IS_NOT_UNIQUE);
    }
  }

  private PrizeGrade confirmPrize(LottoGame lottoGame) {
    return PrizeGrade.of(matchCount(lottoGame), containsBonusNumber(lottoGame));
  }

  private int matchCount(LottoGame lottoGame) {
    return (int) lottoGame.getLottoNumbers()
        .stream()
        .filter(prizeLottoGame::contains)
        .count();
  }

  private boolean containsBonusNumber(LottoGame lottoGame) {
    return lottoGame.getLottoNumbers()
        .stream()
        .anyMatch(bonusNumber::equals);
  }
}
