package lotto.view;

import lotto.domain.LottoTickets;
import lotto.domain.SummaryReport;

public interface OutputViewInterface {
    void printPrompt(String prompt);

    void printTicketCount(int manualCount, int autoCount);

    void printTickets(LottoTickets tickets);

    void printSummary(SummaryReport summary);
}
