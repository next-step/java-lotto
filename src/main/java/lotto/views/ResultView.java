package lotto.views;

import java.util.List;

public class ResultView {

  private static final String NUM_LOTTO_MESSAGE = "개를 구매했습니다.";
  private static final String SCORING_OPENING_MESSAGE = "당첨 통계";
  private static final String SPLIT_LINE_MESSAGE = "----------------";

  private static final String REWARD_PER_MATCH_MESSAGE = "개 일치 (";
  private static final String BONUS_REWARD_PER_MATCH_MESSAGE = "개 일치, 보너스 볼 일치 (";
  private static final String NUM_HIT_MESSAGE = "개";

  private static final String INCOME_PREFIX = "총 수익률은 ";
  private static final String INCOME_SUFFIX = "입니다.";

  private ResultView() {
  }

  public static void printNumLotto(int numLotto) {
    System.out.print(numLotto);
    System.out.println(NUM_LOTTO_MESSAGE);
  }

  public static void printLottoInfo(TicketsExporter exporter) {
    for (int i = 0; i < exporter.getNumTicket(); i++) {
      System.out.println(exporter.getTicket(i));
    }
  }

  public static void printStatisticsOpening() {
    System.out.println(SCORING_OPENING_MESSAGE);
    System.out.println(SPLIT_LINE_MESSAGE);
  }

  public static void printRewards(StatisticsExporter exporter) {
    List<ReportForm> reports = exporter.publishReport();
    for (ReportForm report : reports) {
      System.out.print(report.getNumHit());
      distinguishWithBonusBallCondition(report.containsBonus());
      System.out.print(report.getReward());
      System.out.println(")- " + report.getNumHitCount() + NUM_HIT_MESSAGE);
    }
  }

  private static void distinguishWithBonusBallCondition(boolean withBonus) {
    if (withBonus) {
      System.out.print(BONUS_REWARD_PER_MATCH_MESSAGE);
    }
    if (!withBonus) {
      System.out.print(REWARD_PER_MATCH_MESSAGE);
    }
  }

  public static void printIncome(double incomeRatio) {
    System.out.print(INCOME_PREFIX + incomeRatio + INCOME_SUFFIX);
  }

  public static void printDescription(String message) {
    System.out.println(message);
  }
}
