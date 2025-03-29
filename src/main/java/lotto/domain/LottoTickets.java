package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoTickets {
    List<LottoTicket> tickets;

    public LottoTickets() {
        this.tickets = new ArrayList<>();
    }

    public void add(LottoTicket ticket) {
        tickets.add(ticket);
    }

    public void addAll(LottoTickets tickets) {
        tickets.getTickets().forEach(this::add);
    }

    public List<LottoTicket> getTickets() {
        return tickets;
    }

    public int size() {
        return tickets.size();
    }

    public SummaryReport getSummary(LottoTicket winningTicket, int bonusNumber) {
        List<LottoResult> results = new ArrayList<>();
        for (LottoTicket ticket : tickets) {
            results.add(ticket.matchWinner(winningTicket, bonusNumber));
        }

        Map<PrizeRank, Integer> summary = new HashMap<>();
        for (LottoResult result : results) {
            summary.put(result.getRank(), summary.getOrDefault(result.getRank(), 0) + 1);
        }

        return new SummaryReport(summary);
    }

    public static LottoTickets generate(int paidMoney) {
        int count = paidMoney / LottoTicket.PRICE;

        LottoTickets list = new LottoTickets();
        for (int i = 0; i < count; i++) {
            list.add(AutoTicketGenerator.generate());
        }
        return list;
    }
}