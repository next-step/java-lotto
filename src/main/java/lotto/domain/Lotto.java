package lotto.domain;

import lotto.strategy.LottoNumberStrategy;
import lotto.strategy.LottoRandomStrategy;
import lotto.view.LottoInputInterface;
import lotto.view.ResultView;

import java.util.ArrayList;

public class Lotto {
    static private int PRICE_LOTTO_TICKET = 1000;

    public void start(LottoIO io) {
        int willBuytickets = io.getNumOfPurchased() / PRICE_LOTTO_TICKET;
        LottoTickets tickets = generate(willBuytickets, new LottoRandomStrategy());
        ResultView.println(tickets.toString());

        LottoTicket winner = new LottoTicket(io.getWinnerNumbers());
        io.printResult(tickets.checkWin(winner));
    }

    public LottoTickets generate(int numOfTickets, LottoNumberStrategy strategy) {
        ArrayList<LottoTicket> tickets = new ArrayList<>();

        for (int i = 0; i < numOfTickets; i++) {
            tickets.add(new LottoTicket(strategy.generate()));
        }

        return new LottoTickets(tickets);
    }
}
