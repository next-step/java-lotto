package lotto.view;

import calculator.view.OutputView;
import lotto.domain.LottoRank;
import lotto.domain.LottoTicket;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static lotto.domain.LottoRank.LAST;

public class LottoOutputView extends OutputView {

    public void printTickets(List<LottoTicket> tickets) {
        System.out.println(String.format("%d개를 구매했습니다.", tickets.size()));
        for (LottoTicket ticket : tickets) {
            System.out.println(ticket.getNumbers());
        }
        System.out.println();
    }

    public void printStatistic(Map<LottoRank, Integer> stats) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LAST)
                .sorted(Comparator.reverseOrder())
                .forEach(rank -> printRank(rank, stats.getOrDefault(rank, 0)));
    }

    private static void printRank(LottoRank rank, int count) {
        if (rank.getBonusCount() != 0) {
            System.out.println(String.format("%d개 일치, 보너스 볼 일치(%d원)- %d개", rank.getMatchCount(), rank.getPrize(), count));
            return;
        }

        System.out.println(String.format("%d개 일치 (%d원)- %d개", rank.getMatchCount(), rank.getPrize(), count));
    }

    public void printIncomeRatio(double ratio) {
        System.out.println(String.format("총 수익률은 %.2f입니다.", ratio));
    }

}
