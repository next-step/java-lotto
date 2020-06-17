package lotto;

import java.util.ArrayList;
import java.util.List;

public class TicketCollection {
    private int count;
    private final List<LottoTicket> tickets = new ArrayList<>();
    private final RandomPicker randomPicker = new RandomPicker();

    public TicketCollection(int count) {
        this.count = count;
        makeLottoTicket(count);
    }

    public void makeLottoTicket(int count) {
        for (int i = 0; i < count; i++) {
            LottoTicket ticket = new LottoTicket(randomPicker.pickRandomLotto());
            tickets.add(ticket);
        }
    }

    public int calculateStatics(List<Integer> winningNumbers, List<Integer> winningMatcher) {
        int sumPrize = 0;
        for (LottoTicket ticket : tickets) {
            int cnt = ticket.matchWinningNumber(winningNumbers);
            winningMatcher.set(cnt, winningMatcher.get(cnt) + 1);
            sumPrize += Prize.matchPrize(cnt);
        }
        return sumPrize;
    }

    public int getCount() {
        return count;
    }

    public List<LottoTicket> getTickets() {
        return tickets;
    }
}
