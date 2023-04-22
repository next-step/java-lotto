package lotto;

import lotto.domain.Match;
import lotto.domain.Ticket;
import lotto.present.InputPresent;
import lotto.present.OutputPresent;

import java.util.List;
import java.util.Random;

public class Lotto {
    private final Random RANDOM = new Random();

    public static void main(String[] args) {
        InputPresent inputPresent = new InputPresent();
        OutputPresent outputPresent = new OutputPresent();
        Match match = new Match();
        //Analyst analyst = new Analyst();
        int count = inputPresent.purchaseCount();


        for(int i=0 ; i<count ; i++) {
            match.addTicket(new Ticket(purchaseGame()));
        }
        outputPresent.presentTickets(match.renderingTickets());
        Ticket winningTicket = inputPresent.winningNumber();
        match.winningTicket(winningTicket);
        outputPresent.presentWinner(match.winnerStatus());
        outputPresent.presentReturnRate(match.returnRate());
    }

    private static List<Integer> purchaseGame() {
        throw new RuntimeException("6개 랜덤 숫자 리스트 만들어서 넘겨주기");
    }
}
