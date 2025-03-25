package lotto;

import java.util.Arrays;

public enum LottoPrize {
  THREE_MATCHES(3, 5000),
  FOUR_MATCHES(4, 50000),
  FIVE_MATCHES(5, 1500000),
  SIX_MATCHES(6, 2000000000);

  private final int matchCount;
  private final int prizeMoney;

  LottoPrize(int matchCount, int prizeMoney) {
    this.matchCount = matchCount;
    this.prizeMoney = prizeMoney;
  }

  public static LottoPrize fromMatchCount(int count) {
    return Arrays.stream(values())
            .filter(prize -> prize.matchCount == count)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("일치하는 LottoPrize가 없습니다."));
  }

  public String getPrizeAndCountStatus(int count) {
    return String.format("%d개 일치 (%d원)- %d개", matchCount, prizeMoney, count);
  }

  public int getTotalPrizeMoney(int count) {
    return count * prizeMoney;
  }
}
