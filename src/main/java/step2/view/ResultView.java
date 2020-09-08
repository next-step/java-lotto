package step2.view;

import step2.Constant;
import step2.domain.LottoTicket;
import step2.domain.WinningType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultView {

    public void showLottoTickets(List<LottoTicket> lottoTickets) {
        System.out.println(lottoTickets.size() + Constant.BOUGHT_LOTTO_TICKETS);
        lottoTickets.forEach(e -> System.out.println(e.getNumbers()));
        System.out.println("");
    }

    public void showStatistics(Map<Integer, List<LottoTicket>> winningTickets) {
        startStatistics();
        for (Map.Entry entry : winningTickets.entrySet()) {
            showCountAndPrize(entry);
        }
    }

    public void showProfit(double profit) {
        System.out.println(Constant.PROFIT_RATIO + profit);
    }

    private void startStatistics() {
        System.out.println("");
        System.out.println(Constant.WINNING_STATISTICS);
        System.out.println(Constant.WINNING_STATISTICS_DIVISION);
    }

    private void showCountAndPrize(Map.Entry<Integer, List<LottoTicket>> entry) {
        if (entry.getKey() == Constant.LOTTO_PRIZE_SECOND) {
            System.out.println(WinningType.findSameCount(entry.getKey()) + Constant.UNIT_COUNT + Constant.BLANK
                    + Constant.SAME + Constant.BONUS_NUMBER_MESSAGE + Constant.PRIZE_WRAPPER(entry.getKey().toString())
                    + Constant.DASH + entry.getValue().size() + Constant.UNIT_COUNT);
            return;
        }

        System.out.println(WinningType.findSameCount(entry.getKey()) + Constant.UNIT_COUNT + Constant.BLANK
                + Constant.PRIZE_WRAPPER(entry.getKey().toString())
                + Constant.DASH + entry.getValue().size() + Constant.UNIT_COUNT);
    }
}
