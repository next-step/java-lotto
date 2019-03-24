package lotto.view;

import lotto.domain.LottoList;
import lotto.domain.Rank;
import lotto.domain.WinningResults;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class ConsoleOutput {

    public static void printLottoCount(int manualLottoCount, final int autoLottoCount) {
        System.out.println(String.format("수동으로 %d개, 자동으로 %d개를 구매했습니다.", manualLottoCount, autoLottoCount));
    }

    public static void printLottos(LottoList lottos) {

        lottos.forEach(System.out::println);

        System.out.println();
    }

    public static void printWinningStatistics(WinningResults winningResults) {

        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        Set<Rank> reversedKeyRanks = new TreeSet<>(Collections.reverseOrder());
        reversedKeyRanks.addAll(winningResults.keySet());

        for (Rank rank : reversedKeyRanks) {
            if (!rank.isInTop5()) {
                continue;
            }

            String output = String.format(
                rank + " - %d개",
                winningResults.get(rank).getMatchCount());

            System.out.println(output);
        }

        System.out.println();
    }

    public static void printEarningsRate(double earningsRate) {
        System.out.printf("총 수익률은 %.2f입니다", earningsRate);

        if (earningsRate < 1.0) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }
}
