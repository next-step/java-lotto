package lotto.domain.result;

import java.util.Arrays;

public enum WinningRank {
  SIX_MATCH(6, 2000000000L),
  FIVE_MATCH(5, 1500000L),
  FOUR_MATCH(4, 50000),
  THREE_MATCH(3, 5000);

  private final int matchCount;
  private final long price;

  WinningRank(int matchCount, long price) {
    this.matchCount = matchCount;
    this.price = price;
  }

  public int getMatchCount() {
    return matchCount;
  }

  public long getPrice() {
    return price;
  }

  public static WinningRank fromMatchCount(int matchCount) {
    return Arrays.stream(WinningRank.values())
        .filter(rank -> rank.getMatchCount() == matchCount)
        .findFirst()
        .orElse(null);
  }
}
