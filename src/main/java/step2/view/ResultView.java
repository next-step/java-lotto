package step2.view;

import step2.domain.lotto.LottoTickets;
import step2.domain.lotto.WinningNumber;

public interface ResultView {
    void drawTicket(LottoTickets tickets);
    void drawWinningStatistics(LottoTickets tickets, WinningNumber winningNumber);
    void drawRevenueRate(LottoTickets tickets, WinningNumber winningNumber);
}
