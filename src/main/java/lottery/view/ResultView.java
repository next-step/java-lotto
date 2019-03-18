package lottery.view;

import lottery.domain.LotteryRank;
import lottery.domain.LotteryTicket;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
    public static void viewTickets(List<LotteryTicket> tickets) {
        System.out.println(tickets
            .stream()
            .map(LotteryTicket::toString)
            .collect(Collectors.joining("\n")) + "\n");
    }

    public static void viewStatistics(int totalPrice, List<LotteryRank> ranks) {
        final Map<LotteryRank, Integer> statistics = createStatistics(totalPrice, ranks);


        int totalWinningMoney = 0;
        for (Map.Entry<LotteryRank, Integer> entry : statistics.entrySet()) {
            totalWinningMoney += (entry.getKey().revenue * entry.getValue());
            System.out.println(entry.getKey().winningCount + "개 일치 (" + entry.getKey().revenue + ")- " + entry.getValue() + "개");
        }

        final double v = (double) totalWinningMoney / totalPrice;
        System.out.printf("총 수익률은 %.2f 입니다", Math.floor(v * 100) / 100);
    }

    private static Map<LotteryRank, Integer> createStatistics(int totalPrice, List<LotteryRank> ranks) {
        return Arrays.stream(LotteryRank.values())
                .filter(rank -> rank != LotteryRank.NONE)
                .collect(Collectors.toMap(
                        rank -> rank,
                        rank -> count(ranks, rank)
                ));
    }

    private static int count(List<LotteryRank> ranks, LotteryRank rank) {
        return (int) ranks.stream()
                .filter(r -> r == rank)
                .count();
    }
}
