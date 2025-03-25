package lotto.view;

import lotto.LottoReport;
import lotto.Lottos;

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
}
