package lottery.view;

import lottery.domain.LotteryRank;
import lottery.domain.LotteryTicket;
import lottery.domain.LotteryWinningStatistics;
import lottery.domain.TicketCount;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static void viewTicketCount(TicketCount boughtCount, TicketCount selectedCount) {
        TicketCount randomCount = boughtCount.subtract(selectedCount.amount);

        System.out.println("수동으로" + selectedCount.amount +
                "장, 자동으로" + randomCount.amount + "개를 구매했습니다.");
    }

    public static void viewTickets(List<LotteryTicket> tickets) {
        System.out.println(tickets
            .stream()
            .map(LotteryTicket::toString)
            .collect(Collectors.joining("\n")) + "\n");
    }

    public static void viewStatistics(LotteryWinningStatistics statistics) {
        System.out.println("탕첨통계");
        System.out.println("---------");

        Arrays.stream(LotteryRank.values())
                .filter(rank -> rank != LotteryRank.NONE)
                .sorted(Comparator.reverseOrder())
                .forEach(rank -> viewRank(statistics, rank));

        System.out.printf("총 수익률은 %.2f 입니다", statistics.revenueRate().rate);
    }

    private static void viewRank(LotteryWinningStatistics statistics, LotteryRank rank) {
        System.out.printf("%d개 일치%s(%d원)- %d개\n",
                rank.matchCount,
                rank == LotteryRank.SECOND ? ", 보너스 볼 일치" : " ",
                rank.winningMoney.amount,
                statistics.countRank(rank).amount);
    }
}
