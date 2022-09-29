package lotto.view;

import lotto.domain.type.Match;

public class ResultView {

    public static void printLottoResult(LottoResult result) {
        System.out.println(result.quantity() + "개를 구매했습니다.");
        result.lottos().forEach(System.out::println);
        System.out.println();
    }

    public static void printLottoStatistics(LottoStatistics lottoStatistics) {
        System.out.println("%n당첨 통계");
        System.out.println("---------");

        for (Match match : Match.rewardValues()) {
            System.out.printf("%d개 일치 (%d)- %d개%n", match.count(), match.reward(), lottoStatistics.getMatchCount(match));
        }

        System.out.printf("총 수익률은 %s 입니다.%n", lottoStatistics.profit());
    }
}
