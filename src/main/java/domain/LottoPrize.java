package domain;

import java.util.Arrays;

public enum LottoPrize {
  FIRST(6, 2_000_000_000),
  SECOND(5, 1_500_000),
  THIRD(4, 50_000),
  FOURTH(3, 5_000),
  NONE(0, 0);

  private final int matchCount;
  private final int prize;

  LottoPrize(int matchCount, int prize) {
    this.matchCount = matchCount;
    this.prize = prize;
  }

  public static LottoPrize find(long matchCount) {
    LottoPrize lottoNumber = Arrays.stream(LottoPrize.values())
            .filter(lottoResult -> lottoResult.matchCount == matchCount)
            .findAny()
            .orElse(LottoPrize.NONE);
    return lottoNumber;
  }

  public int getPrize() {
    return prize;
  }

  public int getMatchCount() {
    return matchCount;
  }

}
