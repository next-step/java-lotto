package step2.view;

import step2.domain.*;

import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    public static void lottoCount(Lottos lottos) {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos.getLottos()) {
            String formatted = lotto.getNumbers().stream()
                    .map(LottoNum::toString)
                    .sorted()
                    .collect(Collectors.joining(", ", "[", "]"));
            System.out.println(formatted);
        }
    }

    public static void strategy(Statistics statistics, int totalMoneySpent) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        Map<Rank, Integer> counts = statistics.winningCounts();

        for (Rank rank : Rank.values()) {
            if (!rank.isWinning()) continue;

            int matchCount = rank.matchedCount();
            int reward = rank.reward();
            int count = counts.getOrDefault(rank, 0);

            System.out.printf("%d개 일치 (%d원)- %d개%n", matchCount, reward, count);
        }

        double profit = statistics.profitRate(totalMoneySpent);
        System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)%n",
                profit,
                profit >= 1.0 ? "이익" : "손해"
        );
    }
}
