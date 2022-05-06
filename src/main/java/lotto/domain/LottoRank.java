package lotto.domain;

import static java.util.stream.Collectors.toMap;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public enum LottoRank {
  TOP(2000000000, 6),
  SECOND(1500000, 5),
  THIRD(50000, 4),
  FOURTH(5000, 3),
  NONE(0, 0);

  private static final Map<Long, LottoRank> cachedLottoRank;

  static {
    cachedLottoRank = Arrays.stream(LottoRank.values())
        .collect(toMap(LottoRank::getMatchCount, Function.identity()));
  }

  private final long cashPrize;
  private final long matchCount;

  LottoRank(long cashPrize, long matchCount) {
    this.cashPrize = cashPrize;
    this.matchCount = matchCount;
  }

  public static LottoRank findByMatchCount(final long matchCount) {
    return Optional.ofNullable(cachedLottoRank.get(matchCount))
        .orElse(NONE);
  }

  public boolean isRewarded() {
    return this != NONE;
  }

  public long getCashPrize() {
    return cashPrize;
  }

  public long getMatchCount() {
    return matchCount;
  }

  @Override
  public String toString() {
    return matchCount + "개 일치 (" + cashPrize + "원)";
  }
}
