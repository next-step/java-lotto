package lotto.views;

import java.util.Arrays;
import java.util.Map;

import lotto.LottoWinningStats;
import lotto.enums.Ranks;
import lotto.numbers.LottoBundle;

public class OutputView {
    public static void printNumbers(LottoBundle lottoBundle) {
        System.out.println(lottoBundle.toString());
    }

    public static void printWinningStatsResult(LottoWinningStats lottoWinningStats, int purchaseAmount) {
        Map<Ranks, Integer> rankingMap = lottoWinningStats.getRanks();
        printWinningStats(rankingMap);
        System.out.println("총 수익률은 " + lottoWinningStats.getYield(purchaseAmount) + "입니다.");
    }

    public static void printWinningStats(Map<Ranks, Integer> rankingMap) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        Arrays.stream(Ranks.values()).forEach(rank -> {
            int count = rankingMap.getOrDefault(rank,0);
            printEachStatsByRank(count, rank);
        });
    }

    private static void printEachStatsByRank(int count, Ranks rank) {
        if(rank == Ranks.MISS) {
            return;
        }
        if(rank == Ranks.SECOND) {
            System.out.println(rank.getCountsOfSameNumbers() + "개 일치, 보너스볼 일치(" + rank.getRewards() + ")원-" + count + "개");
            return;
        }
        System.out.println(rank.getCountsOfSameNumbers() + "개 일치 (" + rank.getRewards() + ")원-" + count + "개");

    }
}
