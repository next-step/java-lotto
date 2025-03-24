package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.result.LottoResult;
import lotto.domain.LottoSet;
import lotto.domain.result.WinningRank;

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

    for (WinningRank rank : WinningRank.values()) {
      int count = lottoResult.getMatchCount().getOrDefault(rank, 0);
      System.out.printf("%d개 일치 (%d원) - %d개\n", rank.getMatchCount(), rank.getPrice(), count);
    }

    System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)\n", lottoResult.getProfitRate() * 100);
  }
}
