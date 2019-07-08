package lotto.domain;

import lotto.strategy.LottoNumberStrategy;
import lotto.strategy.LottoRandomStrategy;
import lotto.view.ResultView;

import java.util.ArrayList;

public class Lotto {
    private int willBuyTickets;
    static private int PRICE_LOTTO_TICKET = 1000;

    public Lotto(int price) {
        willBuyTickets = price / PRICE_LOTTO_TICKET;
    }

    public void start(String winnerNumbers, int bonusBall) {
        LottoTickets tickets = generate(willBuyTickets, new LottoRandomStrategy());
        ResultView.println(tickets.toString());

        LottoTicket winner = new LottoTicket(winnerNumbers);

        ResultView.printResult(tickets.checkWin(winner, bonusBall));
    }

    public LottoTickets generate(int numOfTickets, LottoNumberStrategy strategy) {
        ArrayList<LottoTicket> tickets = new ArrayList<>();

        for (int i = 0; i < numOfTickets; i++) {
            tickets.add(new LottoTicket(strategy.generate()));
        }

        return new LottoTickets(tickets);
    }
}
