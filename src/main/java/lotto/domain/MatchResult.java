package lotto.domain;

public class MatchResult {

  private final int matchCount;
  private final boolean hasBonusMatch;

  private MatchResult(int matchCount, boolean hasBonusMatch) {
    this.matchCount = matchCount;
    this.hasBonusMatch = hasBonusMatch;
  }

  public static MatchResult of(int matchCount, boolean hasBonusMatch) {
    return new MatchResult(matchCount, hasBonusMatch);
  }

  public PrizeRank toPrizeRank() {
    if (matchCount == 6) {
      return PrizeRank.FIRST;
    }
    if (matchCount == 5 && hasBonusMatch) {
      return PrizeRank.SECOND;
    }
    if (matchCount == 5) {
      return PrizeRank.THIRD;
    }
    if (matchCount == 4) {
      return PrizeRank.FOURTH;
    }
    if (matchCount == 3) {
      return PrizeRank.FIFTH;
    }
    return PrizeRank.MISS;
  }
} 