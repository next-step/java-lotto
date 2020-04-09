package lotto.domain;

import java.util.Set;
import lotto.domain.model.LottoBall;
import lotto.domain.model.Rank;

public class WinningLottoGame {

  private LottoGame criterion;
  private LottoBall bonus;

  public WinningLottoGame(Set<Integer> lottoNumbers, int bonus) {
    throwIfInvalid(lottoNumbers, bonus);

    this.criterion = new LottoGame(lottoNumbers);
    this.bonus = new LottoBall(bonus);
  }

  private static void throwIfInvalid(Set<Integer> lottoNumbers, int bonus) {
    if (lottoNumbers.contains(bonus)) {
      throw new IllegalArgumentException("보너스 번호는 당첨번호에 속할 수 없습니다.");
    }
  }

  public Rank calculateRank(LottoGame lottoGame) {
    int matchCount = lottoGame.getMatchCount(criterion);
    boolean bonusMatched = lottoGame.contains(bonus);

    return Rank.valueOf(matchCount, bonusMatched);
  }
}
