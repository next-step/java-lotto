package lotto.view;

import calculator.view.OutputView;
import lotto.domain.LottoRank;
import lotto.domain.LottoTicket;

import java.util.List;
import java.util.Map;

import static lotto.domain.LottoRank.*;

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

        String statisticMessage = "%d개 일치 (%d원)- %d개";
        System.out.println(String.format(statisticMessage, FOURTH.getMatchCount(), FOURTH.getPrize(), stats.get(FOURTH)));
        System.out.println(String.format(statisticMessage, THIRD.getMatchCount(), THIRD.getPrize(), stats.get(THIRD)));
        System.out.println(String.format(statisticMessage, SECOND.getMatchCount(), SECOND.getPrize(), stats.get(SECOND)));
        System.out.println(String.format(statisticMessage, FIRST.getMatchCount(), FIRST.getPrize(), stats.get(FIRST)));
    }

    public void printIncomeRatio(double ratio) {
        System.out.println(String.format("총 수익률은 %.2f입니다.", ratio));
    }

}
