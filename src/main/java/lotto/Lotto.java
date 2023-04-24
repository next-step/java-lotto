package lotto;

import lotto.domain.Issuer;
import lotto.domain.Ticket;
import lotto.domain.Winners;
import lotto.present.InputPresent;
import lotto.present.OutputPresent;
import lotto.present.vo.IncomePresentDTO;
import lotto.present.vo.WinnerPresentDTO;

import java.util.List;

public class Lotto {


    public static void main(String[] args) {
        InputPresent inputPresent = new InputPresent();
        OutputPresent outputPresent = new OutputPresent();
        Issuer issuer = new Issuer();

        int count = inputPresent.purchaseCount();
        issuer.purchaseTickets(count);
        outputPresent.presentTickets(issuer.purchasedTickets());

        Ticket winningTicket = inputPresent.winningNumbers();
        outputPresent.presentTickets(List.of(winningTicket));
        Winners winners = issuer.makeWinners(winningTicket);

        outputPresent.presentWinners(new WinnerPresentDTO(winners));
        outputPresent.presentIncome(new IncomePresentDTO(winners));
    }
}
