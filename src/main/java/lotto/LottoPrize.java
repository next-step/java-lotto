package lotto;

import java.util.Arrays;

public enum LottoPrize {
  NONE(0, 0, false),
  THREE(3, 5000, false),
  FOUR(4, 5_0000, false),
  FIVE(5, 150_0000, false),
  FIVE_AND_BONUS(5, 3000_0000, true),
  SIX(6, 20_0000_0000, false);

  private static final String MESSAGE_FOR_PRIZE = "%s개 일치 (%s)";
  private static final String MESSAGE_FOR_PRIZE_WITH_BONUS = "%s개 일치, 보너스 볼 일치(%s)";

  private final int matchedCount;
  private final int prize;
  private final boolean hasBonus;


  LottoPrize(int matched, int prize, boolean hasBonus) {
    this.matchedCount = matched;
    this.prize = prize;
    this.hasBonus = hasBonus;
  }

  public int getRevenue(int matchedLottoCount) {
    return prize * matchedLottoCount;
  }

  public String buildPrizeMessage() {
    if (hasBonus) {
      return String.format(MESSAGE_FOR_PRIZE_WITH_BONUS, matchedCount, prize);
    }
    return String.format(MESSAGE_FOR_PRIZE, matchedCount, prize);
  }

  private boolean is(int matchedCount, boolean hasBonus) {
    return this.matchedCount == matchedCount && this.hasBonus == hasBonus;
  }

  public static LottoPrize valueOf(int matchedCount, boolean hasPrize) {
    return Arrays.stream(LottoPrize.values())
        .filter(lottoPrize -> lottoPrize.is(matchedCount, hasPrize))
        .findFirst()
        .orElse(LottoPrize.NONE);
  }
}
