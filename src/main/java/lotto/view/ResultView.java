package lotto.view;

import lotto.domain.LotteryTicket;
import lotto.domain.WinningRanking;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;

/**
 * Created by yusik on 2019/11/05.
 */
public class ResultView {

    private final PrintStream out;

    public ResultView(PrintStream out) {
        this.out = out;
    }

    public void showTickets(List<LotteryTicket> tickets) {
        out.println(tickets.size() + "개를 구매했습니다.");
        for (LotteryTicket ticket : tickets) {
            out.println(ticket.getNumbers());
        }
    }

    public void showStatistics(Map<WinningRanking, Integer> winningTickets) {
        System.out.println(winningTickets);
        out.println("당첨 통계\n---------");
        for (WinningRanking ranking : WinningRanking.values()) {
            out.printf(
                    "%d개 일치 (%d원)- %d개\n",
                    ranking.getMatchingCount(),
                    ranking.getReward(),
                    winningTickets.getOrDefault(ranking, 0));
        }
    }

    public void showRevenueRate(int amount, Map<WinningRanking, Integer> winningTickets) {
        double totalReward = winningTickets.keySet().stream()
                .mapToDouble(winningRanking -> winningRanking.getReward() * winningTickets.get(winningRanking))
                .sum();
        out.printf("총 수익률은 %.2f입니다.\n", totalReward / amount);
    }
}
