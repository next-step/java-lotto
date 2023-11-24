package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> tickets;

    public Lottos(List<Lotto> tickets) {
        this.tickets = tickets;
    }

    public static Lottos issue(int money) {
        int ticketCount = Lotto.calculateTicketCount(money);
        return generate(ticketCount);
    }

    private static Lottos generate(int count) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            tickets.add(new Lotto());
        }
        return new Lottos(tickets);
    }

    public int count() {
        return this.tickets.size();
    }

    public List<Lotto> tickets() {
        return this.tickets;
    }

    public List<LottoRank> ranks(LottoNumbers winningNumber, LottoNumber bonusNumber) {
        List<LottoRank> result = new ArrayList<>();
        for (Lotto ticket : this.tickets) {
            result.add(ticket.rank(winningNumber, bonusNumber));
        }
        return result;
    }
}
