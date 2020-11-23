package lotto.views;

import lotto.Rank;

public class StatisticsExporter {

  private static final String REWARD_PER_MATCH_MESSAGE = "개 일치 (";
  private static final String BONUS_REWARD_PER_MATCH_MESSAGE = "개 일치, 보너스 볼 일치 (";
  private static final String NUM_HIT_MESSAGE = "개";

  private final ROLottoResult result;

  public StatisticsExporter(ROLottoResult lottoResult) {
    this.result = lottoResult;
  }

  private static void printRewards(int numHit, int amounts, int count) {
    System.out.println(
        numHit + REWARD_PER_MATCH_MESSAGE + amounts + ")- " + count + NUM_HIT_MESSAGE
    );
  }

  private static void printRewardsWithBonus(int numHit, int amounts, int count) {
    System.out.println(
        numHit + BONUS_REWARD_PER_MATCH_MESSAGE + amounts + ")- " + count + NUM_HIT_MESSAGE
    );
  }

  public void printWhole() {
    for (int i = 0; i < this.result.getNumRanks(); i++) {
      printMessage(result.getRank(i));
    }
  }

  private void printMessage(Rank rank) {
    if (rank == Rank.SECOND) {
      printRewardsWithBonus(rank.getNumHit(), rank.getWinningReward(), this.result.getCount(rank));
    }

    if (rank != Rank.SECOND) {
      printRewards(rank.getNumHit(), rank.getWinningReward(), this.result.getCount(rank));
    }
  }
}
