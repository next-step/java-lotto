package lotto.view;

import lotto.domain.LottoTickets;
import lotto.domain.SummaryReport;

public interface ResultViewInterface {
    void printTickets(LottoTickets tickets);

    void printSummary(SummaryReport summary);
}
