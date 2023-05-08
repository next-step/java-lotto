package lotto.utility;

import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.function.Function;

//
public enum RewardTable {
  fourthRank(3, "3개 일치", (times) -> times * 5000),
  thirdRank(4, "4개 일치", (times) -> times * 50000),
  secondRank(5, "5개 일치", (times) -> times * 1500000),
  bonusRank(15, "5개 일치, 보너스 볼 일치", (times) -> times * 30000000),
  firstRank(6, "6개 일치", (times) -> times * 2000000000),
  ;

  public static final int MINIMUM_MATCH_NUMBER = 3;

  private final int matchNumber;

  private final String matchInfo;

  private Function<Integer, Integer> calcReward;

  RewardTable(int matchNumber, String matchInfo, Function<Integer, Integer> rankCondition) {
    this.matchNumber = matchNumber;
    this.matchInfo = matchInfo;
    this.calcReward = rankCondition;
  }

  public int calculateReward(int times) {
    return this.calcReward.apply(times);
  }

  public int amountOfReward() {
    return this.calcReward.apply(1);
  }

  public int getMatchNumber() {
    return matchNumber;
  }

  public String getMatchInfo() {
    return matchInfo;
  }

  public static int bonusRankSeparator(boolean isMatchBonusNumber, int matchNumber) {
    if (isMatchBonusNumber && matchNumber == 5) {
      return bonusRank.getMatchNumber();
    }

    return matchNumber;
  }

  public static RewardTable rewardTableInfo(int matchNumber) {
    return Arrays.stream(values())
        .filter(rank -> rank.matchNumber == matchNumber)
        .findAny()
        .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 등수입니다"));
  }

}
