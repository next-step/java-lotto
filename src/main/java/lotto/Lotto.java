package lotto;

import lotto.strategy.LottoNumberStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Lotto {
    static private int PRICE_LOTTO_TICKET = 1000;
    private int ownTickets;

    public Lotto(int input_price) {
        this.ownTickets = input_price / PRICE_LOTTO_TICKET;
    }

    public Map<Integer,Integer> checkWin(LottoTicket winner, List<LottoTicket> purchased) {
        LottoTickets tickets = new LottoTickets(purchased);
        return tickets.checkWin(winner);
    }

    public List<LottoTicket> generate(LottoNumberStrategy strategy) {
        ArrayList<LottoTicket> tickets = new ArrayList<>();

        for (int i = 0; i < ownTickets; i++) {
            tickets.add(new LottoTicket(strategy.generate()));
        }

        return tickets;
    }
}
