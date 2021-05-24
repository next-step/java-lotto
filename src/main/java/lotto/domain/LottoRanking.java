package lotto.domain;

import java.util.Arrays;

public enum LottoRanking {

  NONE(0, 0L),
  FOURTH(3, 5_000L),
  THIRD(4, 50_000L),
  SECOND(5, 1_500_000L),
  FIRST(6, 2_000_000_000L);

  private final int matchCount;
  private final long winningAmount;

  LottoRanking(int matchCount, long winningAmount) {
    this.matchCount = matchCount;
    this.winningAmount = winningAmount;
  }

  public static LottoRanking confirm(int matchCount) {
    return Arrays.stream(values())
                .filter(lottoRanking -> lottoRanking.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
  }

  public int getMatchCount() {
    return matchCount;
  }
  public long getWinningAmount() {
    return winningAmount;
  }
}
