package domain;

import java.util.Arrays;

public enum LottoPrize {
  FIRST(6, 2_000_000_000),
  SECOND(5, 1_500_000),
  THIRD(4, 50_000),
  FOURTH(3, 5_000),
  NONE(0, 0);

  public final int matchCount;
  public final int prize;

  LottoPrize(int matchCount, int prize) {
    this.matchCount = matchCount;
    this.prize = prize;
  }

  public static LottoPrize find(long matchCount) {
    return Arrays.stream(values())
            .filter(lottoResult -> lottoResult.matchCount == matchCount)
            .findAny()
            .orElse(NONE);
  }

}
