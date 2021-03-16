package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
  FIRST(6, 2_000_000_000),
  SECOND(5, 1_500_000),
  THIRD(4, 50_000),
  FOURTH(3, 5_000),
  ZERO(0, 0);

  private int matchingCount;
  private int matchingPrice;
  private static final String INVALID_NUMBER = "유효하지 않은 값입니다.";
  private static final int MIN_VALUE = 0;
  private static final int MAX_VALUE = 6;

  LottoRank(int matchingCount, int matchingPrice) {
    this.matchingCount = matchingCount;
    this.matchingPrice = matchingPrice;
  }

  public int getMatchingCount() {
    return matchingCount;
  }

  public int getMatchingPrice() {
    return matchingPrice;
  }

  public static LottoRank findByMatchingCount(int matchingCount) {
    validateNumber(matchingCount);
    return Arrays.stream(values())
        .filter(r -> r.match(matchingCount))
        .findFirst()
        .orElse(ZERO);
  }

  public static void validateNumber(int matchingCount) {
    if (matchingCount < MIN_VALUE || matchingCount > MAX_VALUE) {
      throw new IllegalArgumentException(INVALID_NUMBER);
    }
  }

  private boolean match(int matchingCount) {
    return this.matchingCount == matchingCount;
  }

  public static boolean isZero(LottoRank rank) {
    return rank.match(MIN_VALUE);
  }
}
