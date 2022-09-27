package lotto.view;

import lotto.domain.type.MatchType;

public class ResultView {

    public static void printLottoResult(LottoResult result) {
        System.out.println(result.quantity() + "개를 구매했습니다.");
        result.lottos().forEach(System.out::println);
        System.out.println();
    }

    public static void printLottoStatistics(LottoStatistics lottoStatistics) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (MatchType matchType : MatchType.values()) {
            System.out.printf("%d개 일치 (%d)- %d개%n", matchType.matchCount(), matchType.reward(), lottoStatistics.getMatchCount(matchType));
        }

        System.out.printf("총 수익률은 %s 입니다.%n", lottoStatistics.benefit());
    }
}
