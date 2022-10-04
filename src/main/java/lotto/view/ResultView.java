package lotto.view;

import lotto.domain.type.Rank;

public class ResultView {

    public static void printLottoResult(LottoResult result) {
        System.out.println(result.quantity() + "개를 구매했습니다.");
        result.lottoInfos().forEach(System.out::println);
        System.out.println();
    }

    public static void printLottoStatistics(LottoStatisticsResult result) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");

        for (Rank rank : Rank.winningMoneyValues()) {
            System.out.printf("%d개 일치 (%d)- %d개%n", rank.count(), rank.winningMoney(), result.getMatchCount(rank));
        }

        System.out.printf("총 수익률은 %s 입니다.%n", result.profit());
    }
}
