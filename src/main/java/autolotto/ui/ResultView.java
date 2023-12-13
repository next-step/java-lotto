package autolotto.ui;

import autolotto.domain.Lotto;
import autolotto.domain.Rank;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ResultView {
    public static void printLottoNumber(List<Lotto> lottoTickets, int manualLottoCount,int ticketsCount) {
        System.out.printf("수동으로 %d 장, 자동으로 %d 개를 구매했습니다.\n", manualLottoCount, (ticketsCount- manualLottoCount));
        lottoTickets.forEach(System.out::println);
    }

    public static void printStatistics(Map<Rank, Integer> rankCount, double profit) {
        System.out.println("\n당첨 통계\n---------");
        Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.NO_MATCH)
                .forEach(rank -> printWinCount(rankCount, rank));
        System.out.printf("총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 %s 라는 의미임)\n", profit, isLossProfit(profit));
    }

    private static void printWinCount(Map<Rank, Integer> rankCount, Rank rank) {
        int count = rankCount.getOrDefault(rank, 0);
        System.out.println(rank.getDescription() + "- " + count + "개");
    }

    private static String isLossProfit(double profit) {
        if (profit > 1) {
            return "이익";
        }
        return "손해";
    }
}
