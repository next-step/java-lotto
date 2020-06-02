package lotto.view;

import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoNumbers;
import lotto.model.PrizeTier;

public class LottoView {

  public static void printPurchaseRequestMsg() {
    System.out.println("구입 금액을 입력해주세요");
  }

  public static void printPurchaseDoneMsg(int quantity) {
    System.out.println(quantity + "개를 구매했습니다.");
  }

  public static void printLottoNumbers(Lotto lotto) {
    StringBuilder sb = new StringBuilder();
    for (LottoNumbers numbers : lotto.getLottoList()) {
      sb.append(numbers.values()).append("\n");
    }
    System.out.println(sb);
  }

  public static void printWinningNumberRequestMsg() {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
  }

  public static void printStatisticsMsg() {
    System.out.println("\n당첨 통계");
    System.out.println("---------");
  }

  public static void printPrizeTierCnt(Map<PrizeTier, Integer> prizeTierCntMap) {
    prizeTierCntMap.remove(PrizeTier.MATCH_ZERO);

    for (PrizeTier prizeTier : prizeTierCntMap.keySet()) {
      System.out.printf("%d개 일치 (%d원) - %d개\n",
          prizeTier.getMatchCnt(),
          prizeTier.getPrize(),
          prizeTierCntMap.get(prizeTier));
    }
  }

  public static void printProfitRate(double profit) {
    if (profit < 1) {
      System.out.println("총 수익률은 " + profit + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
    if (profit == 1) {
      System.out.println("총 수익률은 " + profit + "입니다.(기준이 1이기 때문에 결과적으로 본전이라는 의미임)");
    }
    if (1 < profit) {
      System.out.println("총 수익률은 " + profit + "입니다.(기준이 1이기 때문에 결과적으로 이득이라는 의미임)");
    }
  }
}
