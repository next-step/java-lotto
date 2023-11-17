package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoTickets {
    private List<LottoTicket> tickets = new ArrayList<>();

    public LottoTickets(int numberOfTickets, Random random) {
        for (int i = 0; i < numberOfTickets; i++) {
            LottoFactory lottoFactory = new LottoFactory(random);
            LottoTicket ticket = new LottoTicket(lottoFactory.numbers());
            tickets.add(ticket);
        }
    }

    public int numberOfPurchasedTicket () {
        return tickets.size();
    }

    public List<LottoTicket> tickets() {
        return this.tickets;
    }
}
