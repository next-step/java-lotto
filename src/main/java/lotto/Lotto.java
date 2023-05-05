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

        int totalPurchaseCount = inputPresent.purchaseCount();
        Tickets manualTickets = inputPresent.manualPurchases();
        Auditor.manualPurchaseValidation(totalPurchaseCount, manualTickets.count());
        Tickets autoTickets = Tickets.automaticIssue(totalPurchaseCount - manualTickets.count());
        outputPresent.presentTickets(manualTickets, autoTickets);
        autoTickets.add(manualTickets);

        WinnerTicket winnerTicket = new WinnerTicket(inputPresent.winningNumbers(), inputPresent.bonusNumber());
        Statics statics = new Statics(autoTickets, winnerTicket);
        outputPresent.presentWinners(new WinnerPresentDTO(statics));
        outputPresent.presentIncome(new IncomePresentDTO(statics));
    }
}
