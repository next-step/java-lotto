package lotto.domain;

import java.util.Arrays;

public enum LottoRanking {

  NONE(0, 0L, false),
  FIFTH(3, 5_000L, false),
  FOURTH(4, 50_000L, false),
  THIRD(5, 1_500_000L, false),
  SECOND(5, 30_000_000L, true),
  FIRST(6, 2_000_000_000L, false);

  private static final int MATCH_COUNT_SHOULD_CONSIDER_BONUS_NUMBER_MATCHED = 5;

  private final int matchCount;
  private final long winningAmount;
  private final boolean bonusNumberMatched;

  LottoRanking(int matchCount, long winningAmount, boolean bonusNumberMatched) {
    this.matchCount = matchCount;
    this.winningAmount = winningAmount;
    this.bonusNumberMatched = bonusNumberMatched;
  }

  public static LottoRanking confirm(int matchCount, boolean isBonusNumberMatched) {
    return Arrays.stream(values())
                .filter(lottoRanking -> lottoRanking.matchCount == matchCount)
                .filter(lottoRanking -> isSecondRanking(lottoRanking, isBonusNumberMatched))
                .findFirst()
                .orElse(NONE);
  }

  private static boolean isSecondRanking(LottoRanking lottoRanking, boolean isBonusNumberMatched) {
    return lottoRanking.matchCount != MATCH_COUNT_SHOULD_CONSIDER_BONUS_NUMBER_MATCHED || (lottoRanking.bonusNumberMatched == isBonusNumberMatched);
  }

  public int getMatchCount() {
    return matchCount;
  }
  public long getWinningAmount() {
    return winningAmount;
  }

  public boolean isBonusNumberMatched() {
    return bonusNumberMatched;
  }
}
