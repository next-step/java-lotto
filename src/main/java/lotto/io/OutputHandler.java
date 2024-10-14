package lotto.io;

import lotto.domain.result.LottoStatistics;
import lotto.domain.ticket.LottoTickets;

public interface OutputHandler {

    void showCommentForPurchaseAmount();

    void showNumberOfTicketsBought(int availableLottoTickets);

    void showLottoTickets(LottoTickets lottoTickets);

    void showWinningNumbersText();

    void showLottoStatistics(LottoStatistics lottoStatistics);
}
