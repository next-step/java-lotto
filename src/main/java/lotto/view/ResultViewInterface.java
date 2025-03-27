package lotto.view;

import lotto.domain.LottoTicketList;
import lotto.domain.SummaryReport;

public interface ResultViewInterface {
    void printTickets(LottoTicketList tickets);

    void printSummary(SummaryReport summary);
}
