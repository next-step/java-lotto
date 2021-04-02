package lotto.domain;

import java.util.Arrays;
import java.util.List;

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

  public int calculateWinningMoney(Integer value) {
    return winnerMoney.multiple(value);
  }

  public static LottoRank findRank(String winnerRank) {
    return LottoRankPredicates.filterLottoRankWithString(winnerRank);
  }

  public static LottoRank valueOf(int matchCount, boolean bonusBall) {
    if(isThirdOrSecond(matchCount)) {
      return LottoRankPredicates.filterLottoRankIsSecondOrThird(bonusBall);
    }
    return LottoRankPredicates.filterLottRankIsDefault(matchCount);
  }

  private static boolean isThirdOrSecond(int matchCount) {
    return matchCount == LottoRank.THIRD.matchCount;
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
