package lotto.domain;

import java.util.Arrays;
import java.util.Objects;

public enum LottoRank {
  TOP(2000000000, 6),
  SECOND(1500000, 5),
  THIRD(50000, 4),
  FOURTH(5000, 3),
  NONE(0, 0);

  private final long cashPrize;
  private final int matchCount;

  LottoRank(long cashPrize, int matchCount) {
    this.cashPrize = cashPrize;
    this.matchCount = matchCount;
  }

  public static LottoRank findByMatchCount(final int matchCount) {
    return Arrays.stream(LottoRank.values())
        .filter(lottoRank -> Objects.equals(lottoRank.getMatchCount(), matchCount))
        .findFirst()
        .orElse(NONE);
  }

  public long getCashPrize() {
    return cashPrize;
  }

  public int getMatchCount() {
    return matchCount;
  }

  @Override
  public String toString() {
    return matchCount + "개 일치 (" + cashPrize + "원)";
  }
}
