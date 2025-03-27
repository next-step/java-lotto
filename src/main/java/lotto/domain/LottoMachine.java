package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoMachine {
    private static final int TICKET_PRICE = 1000;
    private final int paidAmount;
    private final List<LottoTicket> tickets;

    public LottoMachine(int paidAmount) {
        this(paidAmount, new ArrayList<>());
    }

    public LottoMachine(int paidAmount, List<LottoTicket> tickets) {
        int ticketCount = paidAmount / TICKET_PRICE;
        if(paidAmount < TICKET_PRICE || ticketCount * TICKET_PRICE != paidAmount)
            throw new IllegalArgumentException(String.format("ticket price is %d. check your amount.", TICKET_PRICE));

        this.paidAmount = paidAmount;
        this.tickets = new ArrayList<>(tickets);
    }

    public List<LottoTicket> issue() {
        if(!tickets.isEmpty())
            throw new UnsupportedOperationException("tickets already issued.");

        int ticketCount = paidAmount / TICKET_PRICE;

        for(int i=0; i<ticketCount; i++) {
            tickets.add(new LottoTicket());
        }
        return tickets;
    }

    public Map<LottoRank, Integer> compare(LottoTicket winningTicket){
        Map<LottoRank, Integer> stats = new HashMap<>();
        for(LottoTicket ticket: tickets) {
            LottoRank rank = ticket.rank(winningTicket);
            stats.put(rank, stats.getOrDefault(rank, 0)+1);
        }
        for(LottoRank rank : LottoRank.values()) {
            if(!stats.containsKey(rank)) {
                stats.put(rank, 0);
            }
        }

        return stats;
    }

    private double calculateRevenue(Map<LottoRank, Integer> stats) {
        int revenue = 0;
        for (LottoRank rank : stats.keySet()) {
            revenue += rank.getWinningAmount() * stats.get(rank);
        }
        return (double) revenue / paidAmount;
    }

}
