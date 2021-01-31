package lotto.view;

import lotto.domain.LottoTicket;
import lotto.domain.WinnerStatistics;

import java.util.List;

public interface OutputView {

    void printLottoTickets(final List<LottoTicket> lottoTickets);

    void printStatistics(final WinnerStatistics winnerStatistics, final int purchaseAmount);

    void printPurchaseCount(final int purchaseCount);
}
