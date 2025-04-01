package lotto;

import java.util.Arrays;

public enum LottoRank {
  FIRST(6, 2_000_000_000),
  SECOND(5, 1_500_000),
  THIRD(4, 50_000),
  FOURTH(3, 5_000),
  MISS(0, 0);

  private final int matchedCount; // 매칭 숫자 개수
  private final int winningAmount; // 당첨 금액

  LottoRank(int matchedCount, int winningAmount) {
    this.matchedCount = matchedCount;
    this.winningAmount = winningAmount;
  }

  public static LottoRank valueOfMatchedCount(int matchedCount) {
    return Arrays.stream(values())
        .filter(rank -> rank.matchedCount == matchedCount)
        .findFirst()
        .orElse(MISS); // 매칭되지 않으면 MISS 리턴
  }

  public int getWinningAmount() {
    return winningAmount;
  }

  public int getMatchedCount() {
    return matchedCount;
  }
}
