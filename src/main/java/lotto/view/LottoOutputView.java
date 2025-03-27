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
        for(LottoTicket ticket : tickets) {
            System.out.println(ticket.getNumbers());
        }
        System.out.println();
    }

    public void printStatistic(Map<LottoRank, Integer> stats) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(String.format("%d개 일치 (%d원)- %d개", FOURTH.getMatchNumberCount(), FOURTH.getWinningAmount(), stats.get(FOURTH)));
        System.out.println(String.format("%d개 일치 (%d원)- %d개", THIRD.getMatchNumberCount(), THIRD.getWinningAmount(), stats.get(THIRD)));
        System.out.println(String.format("%d개 일치 (%d원)- %d개", SECOND.getMatchNumberCount(), SECOND.getWinningAmount(), stats.get(SECOND)));
        System.out.println(String.format("%d개 일치 (%d원)- %d개", FIRST.getMatchNumberCount(), FIRST.getWinningAmount(), stats.get(FIRST)));

    }

    public void printIncomeRatio(double ratio) {
        System.out.println(String.format("총 수익률은 %.2f입니다.", ratio));
    }

}
