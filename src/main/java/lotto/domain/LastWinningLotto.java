package lotto.domain;

import java.util.List;

public class LastWinningLotto {

  private final Lotto lotto;
  private final LottoNumber bonusBall;

  public LastWinningLotto(final Lotto lotto, final LottoNumber bonusBall) {
    this.lotto = lotto;
    this.bonusBall = bonusBall;
  }

  public static LastWinningLotto of(List<Integer> numbers, int bonusBall) {
    return new LastWinningLotto(Lotto.of(numbers), new LottoNumber(bonusBall));
  }

  public LottoRank match(Lotto thisWeekLotto) {
    int matchCount = lotto.containsCount(thisWeekLotto);
    boolean matchBonusBall = thisWeekLotto.contains(bonusBall);
    return LottoRank.findByCount(matchCount, matchBonusBall);
  }
}
