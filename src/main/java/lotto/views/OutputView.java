package lotto.views;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import lotto.LottoWinningStats;
import lotto.enums.Ranks;
import lotto.numbers.Lotto;

public class OutputView {
    public static void printNumbers(Lotto lotto) {
        for (List<Integer> targetNumbers : lotto.getNumbers()) {
            System.out.print("[");
            printEachNumber(targetNumbers);
            System.out.println("]");
        }
        System.out.println();
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
            System.out.println(rank.getCountsOfSameNumbers() + "개 일치 (" + rank.getRewards() + ")원-" + count + "개");
        });
    }

    private static void printEachNumber(List<Integer> targetNumbers) {
        for (int j = 0; j < targetNumbers.size(); j++) {
            System.out.print(targetNumbers.get(j));
            printComma(j, targetNumbers.size() - 1);
        }
    }

    private static void printComma(int index, int endIndex) {
        if (index < endIndex) {
            System.out.print(", ");
        }
    }
}
