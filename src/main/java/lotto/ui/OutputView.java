package lotto.ui;

import lotto.dto.AnalysisSheet;
import lotto.dto.OrderedInfos;

public class OutputView {

  private static final String ORDERED_N_GAMES_FORMAT = "%d개를 구매했습니다.";
  private static final String PRIZE_ANALYSIS = "당첨 통계";
  private static final String SEPARATE_BAR = "---------";

  private OutputView() {}

  public static void displayOrderedGames(OrderedInfos orderedInfos) {
    System.out.println(String.format(ORDERED_N_GAMES_FORMAT, orderedInfos.orderedCount()));
    System.out.println(orderedInfos.toString());
  }


  public static void displayAnalysisSheet(AnalysisSheet analysisSheet) {
    System.out.println(PRIZE_ANALYSIS);
    System.out.println(SEPARATE_BAR);
    System.out.println(analysisSheet.toStringPrizeInfos());
    System.out.println(analysisSheet.toStringYieldAnalysis());

  }
}
