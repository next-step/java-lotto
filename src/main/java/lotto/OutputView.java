package lotto;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    public static void printLottoes(List<List<LottoNumber>> lottoes) {
        System.out.printf("%d개를 구매했습니다.\n", lottoes.size());
        System.out.println(lottoes);
    }

    public static void printStatistics(Statistics statistics) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        List<Map.Entry<WinningPrize, Integer>> winningStats = statistics.getWinningStats()
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.comparingInt(WinningPrize::getCount)))
                .collect(Collectors.toList());
        for (Map.Entry<WinningPrize, Integer> winningStat : winningStats) {
            System.out.printf("%d개 일치 (%d원)- %d개\n", winningStat.getKey().getCount(), winningStat.getKey().getPrizeMoney().getMoney(), winningStat.getValue());
        }
        System.out.printf("총 수익률은 %f입니다.", statistics.getEarningRate());
    }
}
