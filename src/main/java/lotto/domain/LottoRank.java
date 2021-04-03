package lotto.domain;

import java.util.List;
import lotto.util.LottoRankPredicates;

public enum LottoRank {

  NONE(Integer.MIN_VALUE, 0),
  FIFTH(3, 5000),
  FOURTH(4, 50000),
  THIRD(5, 1500000),
  SECOND(5, 30000000),
  FIRST(6, 2000000000);

  private final int matchCount;
  private final Money winnerMoney;

  LottoRank(int matchCount, int winnerMoney) {
    this.matchCount = matchCount;
    this.winnerMoney = new Money(winnerMoney);
  }

  public boolean isCorrectMatchCount(int matchCount) {
    return this.matchCount == matchCount;
  }

  public Money getMatchedLottoWinningMoney(int value) {
    return winnerMoney.multiple(value);
  }

  public static LottoRank findRank(String winnerRank) {
    return LottoRankPredicates.filterLottoRankByName(winnerRank);
  }

  public static LottoRank valueOf(int matchCount, boolean bonusBall) {
    return LottoRankPredicates.filter(matchCount, bonusBall);
  }

  public static LottoRank matches(List<Number> winningNumbers, List<Number> holdingLottoNumbers, Number bonusBall) {
    int matchCount =  Math.toIntExact(winningNumbers.stream()
        .filter(holdingLottoNumbers::contains)
        .count());
    boolean hasBonusBall = holdingLottoNumbers.contains(bonusBall);
    return LottoRank.valueOf(matchCount, hasBonusBall);
  }

  public static boolean isNone(LottoRank lottoRank) {
    return lottoRank == LottoRank.NONE;
  }
}
