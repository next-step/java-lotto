package step2.view;

import step2.domain.lotto.LottoTickets;
import step2.domain.lotto.WinningNumbers;

public interface ResultView {
    void drawTicket(LottoTickets tickets);
    void drawWinningStatistics(LottoTickets tickets, WinningNumbers winningNumbers);
    void drawRevenueRate(LottoTickets tickets, WinningNumbers winningNumbers);
}
