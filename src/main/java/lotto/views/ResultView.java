package lotto.views;

import java.util.List;

public class ResultView {

  private static final String PURCHASE_MANUAL_PREFIX = "수동으로 ";
  private static final String PURCHASE_MANUAL_SUFFIX = "장, ";
  private static final String PURCHASE_AUTO_PREFIX = "자동으로 ";
  private static final String PURCHASE_AUTO_SUFFIX = "장을 구매했습니다.";

  private static final String SCORING_OPENING_MESSAGE = "당첨 통계";
  private static final String SPLIT_LINE_MESSAGE = "----------------";

  private static final String REWARD_PER_MATCH_MESSAGE = "개 일치 (";
  private static final String BONUS_REWARD_PER_MATCH_MESSAGE = "개 일치, 보너스 볼 일치 (";
  private static final String NUM_HIT_MESSAGE = "개";

  private static final String INCOME_PREFIX = "총 수익률은 ";
  private static final String INCOME_SUFFIX = "입니다.";

  private ResultView() {
  }

  public static void printPublishStatus(DataExporter exporter) {
    System.out.print(
        PURCHASE_MANUAL_PREFIX + exporter.exportNumManualTicket() + PURCHASE_MANUAL_SUFFIX);
    System.out.println(
        PURCHASE_AUTO_PREFIX + exporter.exportNumAutoTicket() + PURCHASE_AUTO_SUFFIX);
  }

  public static void printLottoInfo(DataExporter exporter) {
    List<String> stringTickets = exporter.exportTickets();
    for (String ticket : stringTickets) {
      System.out.println(ticket);
    }
  }

  public static void printStatisticsOpening() {
    System.out.println(SCORING_OPENING_MESSAGE);
    System.out.println(SPLIT_LINE_MESSAGE);
  }

  public static void printRewards(DataExporter exporter) {
    List<ReportForm> reports = exporter.exportStatisticReport();
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
