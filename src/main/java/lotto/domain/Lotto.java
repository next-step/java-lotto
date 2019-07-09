package lotto.domain;

import lotto.strategy.LottoNumberStrategy;
import lotto.strategy.LottoRandomStrategy;

import java.util.ArrayList;

public class Lotto {
    LottoTickets tickets;
    static private int PRICE_LOTTO_TICKET = 1000;

    public Lotto(int price) {
        int countTicket = price / PRICE_LOTTO_TICKET;
        tickets = generate(countTicket, new LottoRandomStrategy());
    }

    public LottoTickets generate() {
        return tickets;
    }

    public LottoResult start(String winnerNumbers, int bonusBall) {
        LottoTicket winner = LottoTicket.of(winnerNumbers);

        return tickets.checkWin(winner, bonusBall);
    }

    public LottoTickets generate(int numOfTickets, LottoNumberStrategy strategy) {
        ArrayList<LottoTicket> tickets = new ArrayList<>();

        for (int i = 0; i < numOfTickets; i++) {
            tickets.add(new LottoTicket(strategy.generate()));
        }

        return new LottoTickets(tickets);
    }
}
