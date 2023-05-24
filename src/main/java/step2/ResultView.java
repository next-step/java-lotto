package step2;

import java.util.List;
import java.util.Map;

public class ResultView {

    public void showLottoTickets(List<LottoTicket> lottoTickets) {
        System.out.println(lottoTickets.size() + LottoMessage.BOUGHT_LOTTO_TICKETS);
        lottoTickets.forEach(e -> System.out.println(e.getNumbers()));
        System.out.println("");
    }

    public void startStatistics() {
        System.out.println("");
        System.out.println(LottoMessage.WINNING_STATISTICS);
        System.out.println(LottoMessage.WINNING_STATISTICS_DIVISION);
    }

    public void showStatistics(Map<Integer, List<LottoTicket>> winningTicketCategories) {
        for (Map.Entry<Integer, List<LottoTicket>> entry : winningTicketCategories.entrySet()) {
            showCountAndPrize(entry);
        }
    }

    private void showCountAndPrize(Map.Entry<Integer, List<LottoTicket>> entry) {
        System.out.print(LottoMessage.SAME_NUM_WRAPPER(entry.getKey()) + LottoMessage.PRIZE_WRAPPER(entry.getKey() + LottoMessage.UNIT_PRIZE));
        System.out.println(LottoMessage.DASH + LottoMessage.BLANK + entry.getValue().size() + LottoMessage.UNIT_COUNT);
    }

    public void showProfit(double profit) {
        System.out.println(LottoMessage.PROFIT_RATIO + profit + LottoMessage.END_MSG);
    }
}
