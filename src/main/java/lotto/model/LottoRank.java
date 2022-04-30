package lotto.model;

import java.util.Arrays;
import java.util.function.Predicate;

public enum LottoRank {

  FIRST(6),
  SECOND(5),
  THIRD(4),
  FOURTH(3),
  NON_MATCH(0);

  private int numberOfMatch;

  LottoRank(int numberOfMatch) {
    this.numberOfMatch = numberOfMatch;
  }

  public static LottoRank findRank(int numberOfMatch) {
    return Arrays.stream(values())
        .filter(lottoRank -> matchRank(lottoRank, numberOfMatch))
        .findFirst()
        .orElse(NON_MATCH);
  }

  private static boolean matchRank(LottoRank lottoRank, int numberOfMatch) {
    return lottoRank.numberOfMatch == numberOfMatch;
  }
}
