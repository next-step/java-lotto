package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoSet;

public class ResultView {
  public static void printLottoSet(LottoSet lottoSet) {
    System.out.println(lottoSet.size() + "개를 구매했습니다.");

    lottoSet.getLottos().stream()
        .map(Lotto::getNumbers)
        .forEach(numbers -> System.out.println(numbers));
  }

  public static void printLottoStatistics(LottoResult lottoResult) {
    System.out.println("당첨 통계");
    System.out.println("---------");
    System.out.println("3개 일치 (5000원)- 1개");
    System.out.println("4개 일치 (50000원)- 0개");
    System.out.println("5개 일치 (1500000원)- 0개");
    System.out.println("6개 일치 (2000000000원)- 0개");

    System.out.println("총 수익률은 0%입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
  }
}
