package step3.view;

import step3.domain.lotto.firstcollection.LottoTickets;
import step3.domain.lotto.firstcollection.WinningResults;

public interface ResultView {
    void drawTicket(LottoTickets tickets);
    void drawWinningStatistics(WinningResults winningResults);
    void drawRevenueRate(double revenueRate, boolean isRevenue);
}
