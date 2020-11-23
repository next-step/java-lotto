package lotto.views;

public class ResultView {

  private static final String NUM_LOTTO_MESSAGE = "개를 구매했습니다.";
  private static final String SCORING_OPENING_MESSAGE = "당첨 통계";
  private static final String SPLIT_LINE_MESSAGE = "----------------";


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
    exporter.printWhole();
  }

  public static void printIncome(double incomeRatio) {
    System.out.print(INCOME_PREFIX + incomeRatio + INCOME_SUFFIX);
  }

  public static void printDescription(String message) {
    System.out.println(message);
  }
}
