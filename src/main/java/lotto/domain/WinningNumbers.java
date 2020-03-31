package lotto.domain;

import java.util.Set;

public class WinningNumbers {

  private LottoGame criterion;
  private LottoNo bonus;

  public WinningNumbers(Set<Integer> lottoNumbers, int bonus) {
    throwIfInvalid(lottoNumbers, bonus);

    this.criterion = new LottoGame(lottoNumbers);
    this.bonus = new LottoNo(bonus);
  }

  private static void throwIfInvalid(Set<Integer> lottoNumbers, int bonus) {
    if (lottoNumbers.contains(bonus)) {
      throw new IllegalArgumentException("LottoGame should not conain bonus number.");
    }
  }

  public Rank getRank(LottoGame lottoGame) {
    int matchCount = lottoGame.getMatchCount(criterion);
    boolean bonusMatched = lottoGame.getLottoNos().contains(bonus);

    return Rank.valueOf(matchCount, bonusMatched);
  }
}
