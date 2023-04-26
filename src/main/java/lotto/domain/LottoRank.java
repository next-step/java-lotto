package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoRank {
  FIRST(6, 2_000_000_000),
  SECOND(5, 30_000_000),
  THIRD(5, 1_500_000),
  FOURTH(4, 50_000),
  FIFTH(3, 5_000),
  NOT_MATCHED(0, 0);

  private static final int NOT_MATCHED_COUNT = 0;
  private static final int SECOND_OR_THIRD_COUNT = 5;

  private final int matchedCount;
  private final int prizeMoney;

  LottoRank(final int matchedCount, final int prizeMoney) {
    this.matchedCount = matchedCount;
    this.prizeMoney = prizeMoney;
  }

  public static List<LottoRank> lottoMatchedNumberList() {
    return Arrays.stream(values())
            .filter(lottoRank -> lottoRank.matchedCount != NOT_MATCHED_COUNT)
            .sorted()
            .collect(Collectors.toList());
  }

  public static LottoRank valueOfMatchedCount(int count, boolean matchBonus) {
    if (isSecondRank(count, matchBonus)) {
      return SECOND;
    }

    if (isThirdRank(count, matchBonus)) {
      return THIRD;
    }

    return Arrays.stream(values())
            .filter(lottoRank -> lottoRank.matchedCount == count)
            .findFirst()
            .orElse(NOT_MATCHED);
  }

  private static boolean isSecondRank(int count, boolean matchBonus) {
    return matchBonus && count == SECOND_OR_THIRD_COUNT;
  }

  private static boolean isThirdRank(int count, boolean matchBonus) {
    return !matchBonus && count == SECOND_OR_THIRD_COUNT;
  }

  public static int prizeMoney(LottoRank lottoRank) {
    return lottoRank.prizeMoney;
  }

  public int matchedCount() {
    return matchedCount;
  }

  public boolean equalsPrizeMoney(LottoRank otherLottoRank) {
    return this.prizeMoney == otherLottoRank.prizeMoney;
  }
}
