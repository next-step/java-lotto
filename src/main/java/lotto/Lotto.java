package lotto;

import lotto.domain.Issuer;
import lotto.domain.Ticket;
import lotto.domain.Winners;
import lotto.present.InputPresent;
import lotto.present.OutputPresent;
import lotto.present.vo.IncomePresentVO;
import lotto.present.vo.WinnerPresentVO;

import java.util.List;

public class Lotto {


    public static void main(String[] args) {
        InputPresent inputPresent = new InputPresent();
        OutputPresent outputPresent = new OutputPresent();
        Issuer issuer = new Issuer();

        int count = inputPresent.purchaseCount();
        issuer.purchaseTickets(count);
        outputPresent.presentTickets(issuer.renderingTickets());

        Ticket winningTicket = inputPresent.winningNumbers();
        outputPresent.presentTickets(List.of(winningTicket.rendering()));
        Winners winners = issuer.makeWinners(winningTicket);

        outputPresent.presentWinners(new WinnerPresentVO(winners));
        outputPresent.presentIncome(new IncomePresentVO(winners));
    }
}
