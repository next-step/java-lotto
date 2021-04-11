package lotto.domain;

import java.util.Arrays;

public enum LottoRank implements LottoRankFilter {

  NONE(Integer.MIN_VALUE, 0),
  FIFTH(3, 5000),
  FOURTH(4, 50000),
  THIRD(5, 1500000) {
    @Override
    public boolean filter(boolean bonusBall, Money winnerMoney) {
      return !bonusBall && isCorrectWinnerMoney(winnerMoney);
    }
  },
  SECOND(5, 30000000) {
    @Override
    public boolean filter(boolean bonusBall, Money winnerMoney) {
      return bonusBall && isCorrectWinnerMoney(winnerMoney);
    }
  },
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

  public boolean isCorrectWinnerMoney(Money winnerMoney) {
    return this.winnerMoney == winnerMoney;
  }

  @Override
  public boolean filter(boolean bonusBall, Money winnerMoney) {
    return isCorrectMatchCount(matchCount);
  }

  public static LottoRank valueOf(int matchCount, boolean bonusBall) {
    return Arrays.stream(LottoRank.values())
        .filter(rank -> rank.isCorrectMatchCount(matchCount))
        .filter(rank -> rank.filter(bonusBall, rank.winnerMoney))
        .findAny()
        .orElse(LottoRank.NONE);
  }

  public static boolean isNotNone(LottoRank lottoRank) {
    return lottoRank != LottoRank.NONE;
  }

  public static Money matchRankWinnerMoney(LottoRank found) {
    LottoRank rank = findRank(found);
    return rank.winnerMoney;
  }

  private static LottoRank findRank(LottoRank found) {
    return Arrays.stream(LottoRank.values())
        .filter(rank -> rank.equals(found))
        .findAny()
        .orElse(LottoRank.NONE);
  }
}
