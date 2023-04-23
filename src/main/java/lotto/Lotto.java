package lotto;

import lotto.domain.Match;
import lotto.domain.Ticket;
import lotto.present.InputPresent;
import lotto.present.OutputPresent;
import lotto.present.vo.IncomePresentVO;
import lotto.present.vo.WinnerPresentVO;

public class Lotto {


    public static void main(String[] args) {
        InputPresent inputPresent = new InputPresent();
        OutputPresent outputPresent = new OutputPresent();
        Match match = new Match();
        //Analyst analyst = new Analyst();
        int count = inputPresent.purchaseCount();


        match.purchase(count);
        outputPresent.presentTickets(match.renderingTickets());
        Ticket winningTicket = inputPresent.winningNumber();
        match.winningTicket(winningTicket);
        outputPresent.presentWinner(new WinnerPresentVO(match.getWinners()));
        outputPresent.presentIncome(new IncomePresentVO(match.getWinners()));
    }



}
