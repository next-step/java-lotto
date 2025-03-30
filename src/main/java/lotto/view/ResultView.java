package lotto.view;

import lotto.LottoReport;
import lotto.domain.LottoPrize;
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
    System.out.println(lottos.getCount() + "개를 구매했습니다.");
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
