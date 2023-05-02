package lotto;

import lotto.domain.Issuer;
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
        Issuer issuer = new Issuer();

        //구매수량
        int totalPurchaseCount = inputPresent.purchaseCount();
        //수동발행
        Tickets tickets = inputPresent.manualPurchases();
        issuer.manualIssue(tickets);
        issuer.automaticIssue(totalPurchaseCount - tickets.count());


        outputPresent.presentTickets(tickets, issuer.issuedTickets());

        WinnerTicket winnerTicket = inputPresent.winningNumbers().winnerTicket(inputPresent.bonusNumber());
        Statics statics = issuer.issuedTicketStatistics(winnerTicket);
        outputPresent.presentWinners(new WinnerPresentDTO(statics));
        outputPresent.presentIncome(new IncomePresentDTO(statics));
    }
}
