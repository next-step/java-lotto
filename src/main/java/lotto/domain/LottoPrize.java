package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum LottoPrize {
  FIRST(6, false, 2_000_000_000),
  SECOND(5, true, 30_000_000),
  THIRD(5, false, 1_500_000),
  FOURTH(4, false, 50_000),
  FIFTH(3, false, 5_000),
  NOTHING(0, false, 0);

  private static final List<LottoPrize> LOTTO_PRIZE_LIST = Arrays.asList(LottoPrize.values());
  private final int matchCnt;
  private final boolean mustMatchBonus;
  private final long prizeMoney;

  LottoPrize(int matchCnt, boolean mustMatchBonus, int prizeMoney) {
    this.matchCnt = matchCnt;
    this.mustMatchBonus = mustMatchBonus;
    this.prizeMoney = prizeMoney;
  }

  public static LottoPrize of(int matchCnt, boolean matchBonus) {
    return LOTTO_PRIZE_LIST.stream()
        .filter(prize -> prize.matchCnt == matchCnt)
        .filter(prize -> prize.matchCnt != SECOND.matchCnt || prize.mustMatchBonus == matchBonus)
        .findAny().orElse(NOTHING);
  }

  public static LottoPrize[] valuesExceptNothing() {
    return LOTTO_PRIZE_LIST.stream()
        .filter(lottoPrize -> lottoPrize != LottoPrize.NOTHING)
        .toArray(LottoPrize[]::new);
  }

  public long prizeMoney() {
    return prizeMoney;
  }

  public int matchCnt() {
    return matchCnt;
  }
}
