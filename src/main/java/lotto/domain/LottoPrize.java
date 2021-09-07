package lotto.domain;

import java.util.Arrays;
import lotto.exception.InvalidMatchCntException;

public enum LottoPrize {
  FIRST(6, 2_000_000_000),
  SECOND(5, 30_000_000),
  THIRD(5, 1_500_000),
  FOURTH(4, 50_000),
  FIFTH(3, 5_000),
  NOTHING(0, 0);

  private static final LottoPrize[] VALUES_EXCEPT_NOTHING = initValuesExceptNothing();
  private final int matchCnt;
  private final long prizeMoney;

  LottoPrize(int matchCnt, int prizeMoney) {
    this.matchCnt = matchCnt;
    this.prizeMoney = prizeMoney;
  }

  public static LottoPrize of(int matchCnt, boolean matchBonus) {
    if (matchCnt >= 0 && matchCnt < FIFTH.matchCnt){
      return NOTHING;
    }
    if (matchCnt == SECOND.matchCnt) {
      return matchBonus ? SECOND : THIRD;
    }
    return Arrays.stream(VALUES_EXCEPT_NOTHING)
        .filter(prize -> prize.matchCnt == matchCnt)
        .findFirst()
        .orElseThrow(InvalidMatchCntException::new);
  }

  public static LottoPrize[] valuesExceptNothing() {
    return VALUES_EXCEPT_NOTHING;
  }

  public long prizeMoney() {
    return prizeMoney;
  }

  public int matchCnt() {
    return matchCnt;
  }

  private static LottoPrize[] initValuesExceptNothing() {
    return Arrays.stream(values())
        .filter(lottoPrize -> lottoPrize != LottoPrize.NOTHING)
        .toArray(LottoPrize[]::new);
  }
}
