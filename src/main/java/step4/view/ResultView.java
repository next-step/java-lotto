package step4.view;

import step4.lotto.firstcollection.LottoTickets;
import step4.lotto.firstcollection.WinningResults;

public interface ResultView {
    void drawTicket(LottoTickets tickets);
    void drawWinningStatistics(WinningResults winningResults);
    void drawRevenueRate(double revenueRate, boolean isRevenue);
}
