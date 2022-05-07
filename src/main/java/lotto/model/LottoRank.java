package lotto.model;

import java.util.Arrays;

public enum LottoRank {

  FIRST(6, 2000000000),
  BONUS_SECOND(5, 30000000),
  SECOND(5, 1500000),
  THIRD(4, 50000),
  FOURTH(3, 5000),
  NON_MATCH(0, 0);

  private final int numberOfMatch;
  private final int reward;

  LottoRank(int numberOfMatch, int reward) {
    this.numberOfMatch = numberOfMatch;
    this.reward = reward;
  }

  public static LottoRank findRank(int numberOfMatch, boolean matchOfBonusLottoNumber) {
    if (matchOfBonusLottoNumber) {
      return BONUS_SECOND;
    }

    return Arrays.stream(values())
        .filter(lottoRank -> matchRank(lottoRank, numberOfMatch))
        .findFirst()
        .orElse(NON_MATCH);
  }

  private static boolean matchRank(LottoRank lottoRank, int numberOfMatch) {
    return lottoRank != BONUS_SECOND && lottoRank.numberOfMatch == numberOfMatch;
  }

  public int getNumberOfMatch() {
    return numberOfMatch;
  }

  public int getReward() {
    return reward;
  }
}
