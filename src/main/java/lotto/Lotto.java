package lotto;

import lotto.domain.Auditor;
import lotto.domain.Statics;
import lotto.domain.Tickets;
import lotto.domain.WinnerTicket;
import lotto.present.InputPresent;
import lotto.present.OutputPresent;
import lotto.present.dto.IncomePresentDTO;
import lotto.present.dto.WinnerPresentDTO;

public class Lotto {
    public static void main(String[] args) {
        InputPresent inputPresent = new InputPresent();
        OutputPresent outputPresent = new OutputPresent();

        Tickets issueTickets = issueTickets(inputPresent, outputPresent, inputPresent.purchaseCount());
        WinnerTicket winnerTicket = new WinnerTicket(inputPresent.winningNumbers(), inputPresent.bonusNumber());
        Statics statics = new Statics(issueTickets, winnerTicket);

        outputPresent.presentWinners(new WinnerPresentDTO(statics));
        outputPresent.presentIncome(new IncomePresentDTO(statics));
    }

    private static Tickets issueTickets(InputPresent inputPresent, OutputPresent outputPresent, int totalPurchaseCount) {
        Tickets manualTickets = inputPresent.manualPurchases();
        Auditor.manualPurchaseValidation(totalPurchaseCount, manualTickets.count());
        Tickets autoTickets = Tickets.automaticIssue(totalPurchaseCount - manualTickets.count());
        outputPresent.presentTickets(manualTickets, autoTickets);
        return Tickets.composite(manualTickets, autoTickets);
    }
}
