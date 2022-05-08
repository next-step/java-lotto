package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoRank {
  TOP(2000000000, 6),
  SECOND(30000000, 5),
  THIRD(1500000, 5),
  FOURTH(50000, 4),
  FIFTH(5000, 3),
  NONE(0, 0);

  private static final List<LottoRank> cachedLottoRank;

  static {
    cachedLottoRank = Arrays.stream(LottoRank.values())
        .collect(Collectors.toList());
  }

  private final long cashPrize;
  private final long matchCount;

  LottoRank(long cashPrize, long matchCount) {
    this.cashPrize = cashPrize;
    this.matchCount = matchCount;
  }

  public static LottoRank of(final long matchCount, final boolean matchedBonus) {
    LottoRank lottoRank = getLottoRank(matchCount);
    if (lottoRank.isSecond() && !matchedBonus) {
      return THIRD;
    }
    return  lottoRank;
  }

  private static LottoRank getLottoRank(long matchCount) {
    return cachedLottoRank.stream()
        .filter(rank -> rank.isMatched(matchCount))
        .findFirst()
        .orElse(NONE);
  }

  private boolean isMatched(long matchCount) {
    return this.matchCount == matchCount;
  }

  private static LottoRank decideSecond(boolean bonus) {
    if (bonus) {
      return SECOND;
    }
    return THIRD;
  }

  public boolean isTop() {
    return this == TOP;
  }

  public boolean isSecond() {
    return this == SECOND;
  }

  public boolean isThird() {
    return this == THIRD;
  }

  public boolean isFourth() {
    return this == FOURTH;
  }

  public boolean isFifth() {
    return this == FIFTH;
  }

  public boolean isNone() {
    return this == NONE;
  }

  public boolean isRewarded() {
    return this != NONE;
  }

  public long getCashPrize() {
    return cashPrize;
  }

  @Override
  public String toString() {
    if (isSecond()) {
      return matchCount + "개 일치, 보너스 볼 일치(" + cashPrize + "원)";
    }
    return matchCount + "개 일치 (" + cashPrize + "원)";
  }
}
