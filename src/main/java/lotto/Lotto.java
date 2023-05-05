package lotto;

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
        Tickets tickets = new Tickets();
        //구매수량
        int totalPurchaseCount = inputPresent.purchaseCount();

        Tickets manualTickets = inputPresent.manualPurchases();
        Tickets autoTickets = Tickets.automaticIssue(totalPurchaseCount - tickets.count());
        outputPresent.presentTickets(manualTickets, autoTickets);

        WinnerTicket winnerTicket = new WinnerTicket(inputPresent.winningNumbers(), inputPresent.bonusNumber());
        Statics statics = new Statics(tickets, winnerTicket);
        outputPresent.presentWinners(new WinnerPresentDTO(statics));
        outputPresent.presentIncome(new IncomePresentDTO(statics));
    }
}
