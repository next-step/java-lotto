package lotto.constants;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum PrizeGrade {
  FIRST_CLASS(6, 2_000_000_000, 4),
  SECOND_CLASS(5, 1_500_000, 3),
  THIRD_CLASS(4, 50_000, 2),
  FOURTH_CLASS(3, 5_000, 1),
  FAIL(-1, 0, Integer.MAX_VALUE);

  private final int matchCount;
  private final long prizeMoney;
  private final int printOrder;

  private static final Map<Integer, PrizeGrade> valuesMap = Arrays.stream(PrizeGrade.values())
      .collect(Collectors.toMap(prizeGrade -> prizeGrade.matchCount, Function.identity()));

  public static PrizeGrade of(int matchCount) {
    return Optional.ofNullable(valuesMap.get(matchCount)).orElse(FAIL);
  }

  PrizeGrade(int matchCount, long prizeMoney, int printOrder) {
    this.matchCount = matchCount;
    this.prizeMoney = prizeMoney;
    this.printOrder = printOrder;
  }

  public long getPrizeMoney() {
    return prizeMoney;
  }

  public int getMatchCount() {
    return matchCount;
  }

  public int getPrintOrder() {
    return printOrder;
  }
}
