package lotto;

import lotto.domain.Match;
import lotto.domain.Ticket;
import lotto.present.InputPresent;
import lotto.present.OutputPresent;
import lotto.present.vo.IncomePresentVO;
import lotto.present.vo.WinnerPresentVO;

import java.util.List;

public class Lotto {


    public static void main(String[] args) {
        InputPresent inputPresent = new InputPresent();
        OutputPresent outputPresent = new OutputPresent();
        Match match = new Match();

        int count = inputPresent.purchaseCount();
        match.purchase(count);
        outputPresent.presentTickets(match.renderingTickets());

        Ticket winningTicket = inputPresent.winningNumber();
        outputPresent.presentTickets(List.of(winningTicket.rendering()));
        match.winningTicket(winningTicket);

        outputPresent.presentWinner(new WinnerPresentVO(match.getWinners()));
        outputPresent.presentIncome(new IncomePresentVO(match.getWinners()));
    }
}
