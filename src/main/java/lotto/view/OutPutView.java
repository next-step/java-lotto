package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;

public class OutPutView {
  private static final String ORDINARY_FORMAT = "%s개 일치 (%s원)- %s개";
  private static final String BONUS_FORMAT = "%s개 일치, 보너스 볼 일치(%s원)- %s개";

  public static void printProfitRate(double profitRate) {
    System.out.printf("총 수익률은 %.3f입니다.", profitRate);
  }

  public static void printResult(LottoResult result) {
    System.out.println("당첨 통계");
    System.out.println("---------");
    List<String> list = result.resultStatus( isBonus -> {
      if (isBonus) {
        return BONUS_FORMAT;
      }
      return ORDINARY_FORMAT;
    });
    for (String each : list) {
      System.out.println(each);
    }
  }
  public static void printAutoAndManualRate(Lottos auto, Lottos manual) {
    String format = String.format("수동으로 %s장, 자동으로 %s개를 구매했습니다.", auto.size(), manual.size());
    System.out.println(format);
  }
  public static void printLotto(Lottos lottos) {
    String delimiter = ",";
    List<String> stringStatus = lottos.toStringStatus();
    stringStatus.stream()
        .map(lottoString -> lottoString.replaceAll(",", delimiter))
        .forEach(each -> {
          System.out.print('[');
          System.out.print(each);
          System.out.print(']');
          System.out.println();
        });
  }
}
