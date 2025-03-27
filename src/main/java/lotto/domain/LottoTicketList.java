package lotto.domain;

import java.util.*;

public class LottoTicketList {
    List<LottoTicket> tickets;

    public LottoTicketList() {
        this.tickets = new ArrayList<>();
    }

    public void add(LottoTicket ticket) {
        tickets.add(ticket);
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

    public static LottoTicketList generate(int paidMoney, LottoNumberGenerator generator) {
        int count = paidMoney / LottoTicket.PRICE;

        LottoTicketList list = new LottoTicketList();
        for (int i = 0; i < count; i++) {
            List<LottoNumber> numbers = generator.shuffle();
            list.add(new LottoTicket(numbers));
        }
        return list;
    }
}