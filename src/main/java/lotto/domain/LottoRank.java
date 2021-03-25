package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import jdk.nashorn.internal.ir.CallNode.EvalArgs;

public enum LottoRank {
  FIRST(6, 2_000_000_000, false),
  SECOND(5, 30_000_000, true),
  THIRD(5, 1_500_000, false),
  FOURTH(4, 50_000, false),
  FIFTH(3, 5_000, false),
  ZERO(0, 0, false);

  private final int count;
  private final int price;
  private final boolean isBonus;
  private static final String INVALID_NUMBER = "유효하지 않은 값입니다.";
  private static final int MIN_VALUE = 0;
  private static final int MAX_VALUE = 6;

  LottoRank(final int count,final int price,final boolean isBonus) {
    this.count = count;
    this.price = price;
    this.isBonus = isBonus;
  }

  public int getCount() {
    return count;
  }

  public int getPrice() {
    return price;
  }

  public static LottoRank findByCount(int count, boolean bonus) {
    validateNumber(count);
    return findLottoRank(count, bonus);
  }

  public static LottoRank findLottoRank(int count, boolean bonus) {
    return Arrays.stream(values())
        .filter(r -> r.matchCount(count))
        .filter(m -> m.matchBonus(bonus))
        .findFirst()
        .orElse(ZERO);
  }

  public static void validateNumber(int matchingCount) {
    if (matchingCount < MIN_VALUE || matchingCount > MAX_VALUE) {
      throw new IllegalArgumentException(INVALID_NUMBER);
    }
  }

  private boolean matchCount(int count) {
    return this.count == count;
  }

  private boolean matchBonus(boolean bonus) {
    return this.isBonus == bonus;
  }

  public static boolean isZero(LottoRank rank) {
    return rank.matchCount(MIN_VALUE);
  }
}
