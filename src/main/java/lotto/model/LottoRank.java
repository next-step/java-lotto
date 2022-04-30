package lotto.model;

import java.util.Arrays;
import java.util.function.Predicate;

public enum LottoRank {

  FIRST(6, 2000000000),
  SECOND(5, 1500000),
  THIRD(4, 50000),
  FOURTH(3,5000),
  NON_MATCH(0, 0);

  private int numberOfMatch;
  private int reward;

  LottoRank(int numberOfMatch, int reward) {
    this.numberOfMatch = numberOfMatch;
    this.reward = reward;
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

  public int getNumberOfMatch() {
    return numberOfMatch;
  }

  public int getReward() {
    return reward;
  }
}
