package lotto.domain;

import lotto.enums.Rank;

import java.util.*;

public class Tickets {
    private List<Ticket> tickets = new ArrayList<>();

    public Tickets() {
    }

    public Tickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void sellTickets(long amount) {
        while (amount >= Ticket.PRICE) {
            this.addTicket(new Ticket());
            amount -= Ticket.PRICE;
        }
    }

    public EnumMap<Rank, Integer> makeStatistics(Numbers winningNumbers) {
        EnumMap<Rank, Integer> countPerPrize = new EnumMap<>(Rank.class);
        initEnumMap(countPerPrize);

        for (Ticket ticket : tickets) {
            Rank.fromCount(ticket.match(winningNumbers)).ifPresent(rank -> countPerPrize.put(rank, countPerPrize.get(rank) + 1));
        }

        return countPerPrize;
    }

    public long calcWinningAmount(Numbers winningNumbers) {
        long totalAmount = 0;
        for (Map.Entry<Rank, Integer> entry : this.makeStatistics(winningNumbers).entrySet()) {
            totalAmount += entry.getKey().calcWinningAmountPerRank(entry.getValue());
        }
        return totalAmount;
    }


    public double calcRateOfReturn(Numbers winningNumbers) {
        return (double) this.calcWinningAmount(winningNumbers) / (this.ticketCount() * Ticket.PRICE);
    }

    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    public int ticketCount() {
        return tickets.size();
    }

    public List<Ticket> getTickets() {
        return Collections.unmodifiableList(this.tickets);
    }

    private void initEnumMap(EnumMap<Rank, Integer> countPerPrize) {
        for (Rank rank : Rank.values()) {
            countPerPrize.put(rank, 0);
        }
    }
}
