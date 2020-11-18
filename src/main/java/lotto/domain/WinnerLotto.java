package lotto.domain;

import lotto.domain.model.LottoNumber;
import lotto.exception.LottoGameException;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.constants.Message.BONUS_NUMBER_IS_NOT_UNIQUE;

public class WinnerLotto {

  private final Lotto prizeLotto;
  private final LottoNumber bonusNumber;

  public WinnerLotto(Lotto prizeLotto, LottoNumber bonusNumber) {
    validateBonusNumber(prizeLotto, bonusNumber);
    this.prizeLotto = prizeLotto;
    this.bonusNumber = bonusNumber;
  }

  public List<PrizeGrade> prizeResult(List<Lotto> lastWeekWinGame) {
    return lastWeekWinGame.stream()
        .map(this::confirmPrize)
        .collect(Collectors.toList());
  }

  private void validateBonusNumber(Lotto prizeLotto, LottoNumber bonusNumber) {
    if (prizeLotto.contains(bonusNumber)) {
      throw new LottoGameException(BONUS_NUMBER_IS_NOT_UNIQUE);
    }
  }

  private PrizeGrade confirmPrize(Lotto lotto) {
    return PrizeGrade.of(matchCount(lotto), containsBonusNumber(lotto));
  }

  private int matchCount(Lotto lotto) {
    return (int) lotto.getLottoNumbers()
        .stream()
        .filter(prizeLotto::contains)
        .count();
  }

  private boolean containsBonusNumber(Lotto lotto) {
    return lotto.getLottoNumbers()
        .stream()
        .anyMatch(bonusNumber::equals);
  }
}
