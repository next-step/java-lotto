package lotto.view;

import lotto.domain.LottoResult;
import lotto.enums.LottoResultType;
import lotto.domain.Lottos;

public class OutPutView {

  public static void printProfitRate(double profitRate) {
    System.out.printf("총 수익률은 %.3f입니다.",profitRate);
  }

  public static void printResult(LottoResult result) {
    System.out.println("당첨 통계");
    System.out.println("---------");
    System.out.printf("3개 일치 (5000원)- %s개", result.findMatchResultCount(LottoResultType.THREE) +"\n");
    System.out.printf("4개 일치 (50000원)- %s개", result.findMatchResultCount(LottoResultType.FOUR) +"\n");
    System.out.printf("5개 일치 (1500000원)- %s개", result.findMatchResultCount(LottoResultType.FIVE) +"\n");
    System.out.printf("6개 일치 (2000000000원)- %s개", result.findMatchResultCount(LottoResultType.ALL) +"\n");
  }

  public static void printLotto(Lottos lottos) {
    printSize(lottos.size());
    String stringStatus = lottos.toStringStatus();
    System.out.println(stringStatus);
  }

  public static void printSize(int size) {
    System.out.printf("%s개를 구매했습니다.\n",size);
  }
}
