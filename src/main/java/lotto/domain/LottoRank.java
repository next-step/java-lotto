package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public enum LottoRank {
  FIRST(6, 2_000_000_000),
  SECOND(5, 1_500_000),
  THIRD(4, 50_000),
  FOURTH(3, 5_000),
  NOTMATCHED(0, 0);

  private static final int UNDER_RANK = 2;
  private static final Map<Integer, LottoRank> BY_MATCHEDCOUNT = new HashMap<>();

  static {
    for (LottoRank lottoRank : values()) {
      BY_MATCHEDCOUNT.put(lottoRank.matchedCount, lottoRank);
    }
  }

  private final int matchedCount;
  private final int prizeMoney;

  LottoRank(final int matchedCount, final int prizeMoney) {
    this.matchedCount = matchedCount;
    this.prizeMoney = prizeMoney;
  }

  public static List<Integer> lottoMatchedNumberList() {
    return BY_MATCHEDCOUNT.keySet().stream()
            .filter(v -> v != 0)
            .sorted()
            .collect(Collectors.toList());
  }

  public static LottoRank valueOfMatchedCount(int count) {
    if (count <= UNDER_RANK) {
      return BY_MATCHEDCOUNT.get(0);
    }

    return BY_MATCHEDCOUNT.get(count);
  }

  public static int prizeMoney(LottoRank lottoRank) {
    return lottoRank.prizeMoney;
  }

  public boolean equalsMatchedCount(int matchedCount) {
    return this.matchedCount == matchedCount;
  }
}
