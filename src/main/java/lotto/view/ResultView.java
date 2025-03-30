package lotto.view;

import lotto.domain.LottoReport;
import lotto.domain.prize.LottoPrize;
import lotto.domain.Lottos;

public class ResultView {
  public static void printLottos(Lottos lottos) {
    lottos.printAllLottos();
  }

  public static void printStatistics(LottoReport lottoReport) {
    System.out.println("당첨 통계");
    System.out.println("---------");
    System.out.println(lottoReport.createCountReport());
    System.out.println(lottoReport.createMoneyReport());
  }

  public static void printLottoCount(Lottos lottos) {
    String lottoCountStatus = String.format("수동으로 %d장, 자동으로 %d장 구매했습니다.", lottos.getManualLottoCount(), lottos.getAutoLottoCount());
    System.out.println(lottoCountStatus);
  }

  public static String getPrizeAndCountStatus(LottoPrize prize, int count) {
    return String.format("%s- %d개", getPrizeDisplayText(prize), count);
  }

  private static String getPrizeDisplayText(LottoPrize lottoPrize) {
    if (lottoPrize.getIsBonus()) {
      return String.format("%d개 일치, 보너스 볼 일치(%d원)", lottoPrize.getMatchCount(), lottoPrize.getPrizeMoney());
    }
    return String.format("%d개 일치 (%d원)", lottoPrize.getMatchCount(), lottoPrize.getPrizeMoney());
  }
}
