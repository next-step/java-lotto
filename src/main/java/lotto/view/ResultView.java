package lotto.view;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.LottoNumber;
import lotto.domain.result.LottoResult;
import lotto.domain.LottoSet;
import lotto.domain.result.WinningRank;

public class ResultView {
  public static void printLottoSet(LottoSet lottoSet) {
    System.out.println(lottoSet.size() + "개를 구매했습니다.");

    lottoSet.getLottos().stream()
        .map(lotto -> "[" + lotto.getNumbers().stream()
            .map(LottoNumber::getNumber)
            .map(String::valueOf)
            .collect(Collectors.joining(", ")) + "]")  // 포맷팅 과정 바로 처리
        .forEach(System.out::println);
  }

  public static void printLottoStatistics(LottoResult lottoResult) {
    System.out.println("당첨 통계");
    System.out.println("---------");

    for (WinningRank rank : WinningRank.values()) {
      int count = lottoResult.getMatchCount().getOrDefault(rank, 0);
      System.out.printf("%d개 일치 (%d원) - %d개\n", rank.getMatchCount(), rank.getPrice(), count);
    }

    double profitRate = lottoResult.getProfitRate();
    String resultMessage = Stream.of(
            profitRate > 1 ? "이득" : null,
            profitRate < 1 ? "손해" : null,
            profitRate == 1 ? "본전" : null
        )
        .filter(Objects::nonNull)
        .findFirst()
        .orElse("알 수 없는 결과");

    System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s임)\n", profitRate, resultMessage);
  }
}
