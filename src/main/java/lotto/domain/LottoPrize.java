package lotto.domain;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public enum LottoPrize {
  THREE_MATCHES(3, 5_000),
  FOUR_MATCHES(4, 50_000),
  FIVE_MATCHES(5, 1_500_000),
  SIX_MATCHES(6, 2_000_000_000);

  private final int matchCount;
  private final int prizeMoney;

  LottoPrize(int matchCount, int prizeMoney) {
    this.matchCount = matchCount;
    this.prizeMoney = prizeMoney;
  }

  public static LottoPrize getPrizeFromMatchCount(int count) {
    return Arrays.stream(values())
            .filter(prize -> prize.matchCount == count)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("일치하는 LottoPrize가 없습니다."));
  }

  public static Set<Integer> getAllMatchCounts() {
    return Arrays.stream(values())
            .map(prize -> prize.matchCount)
            .collect(Collectors.toSet());
  }

  public int getMatchCount() {
    return matchCount;
  }

  public int getPrizeMoney() {
    return prizeMoney;
  }
}
