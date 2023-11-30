package lotto.view;

import java.util.Collection;
import java.util.List;
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
    for (int i = 3; i < 7; i++) {
      System.out.printf("%s개 일치 (5000원)- %s개", i, result.findMatchResultCount(LottoResultType.valueOf(i)));
      System.out.println();
    }
  }

  public static void printLotto(Lottos lottos) {
    printSize(lottos.size());
    List<String> stringStatus = lottos.toStringStatus();
    stringStatus.forEach(each -> {
              System.out.print('[');
              System.out.print(each);
              System.out.print(']');
              System.out.println();
            });
  }

  public static void printSize(int size) {
    System.out.printf("%s개를 구매했습니다.\n",size);
  }
}
