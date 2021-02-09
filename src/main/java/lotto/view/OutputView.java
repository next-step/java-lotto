package lotto.view;

import lotto.domain.LottoTicket;
import lotto.domain.PurchaseResult;
import lotto.domain.WinnerStatistics;

import java.util.List;

public interface OutputView {

    void printLottoTickets(final List<LottoTicket> lottoTickets);

    void printStatistics(final WinnerStatistics winnerStatistics);

    void printLottoTickets(final PurchaseResult manual, final PurchaseResult auto);
}
