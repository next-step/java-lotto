package step3.view;

import step3.domain.lotto.WinningNumbers;
import step3.domain.lotto.firstcollection.LottoTickets;

public interface ResultView {
    void drawTicket(LottoTickets tickets);
    void drawWinningStatistics(LottoTickets tickets, WinningNumbers winningNumbers);
    void drawRevenueRate(LottoTickets tickets, WinningNumbers winningNumbers);
}
