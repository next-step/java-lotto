package com.game.lotto.ticket;

import com.game.lotto.prize.Rank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicketsByRanks {
    private final Map<Rank, List<MyTicket>> ticketsByRanks;

    public TicketsByRanks(WinnerTicket winnerTicket, final List<MyTicket> myTickets) {
        this.ticketsByRanks = new HashMap<>();
        updateStrikesWithWinnerTicket(winnerTicket, myTickets);
    }

    private void updateStrikesWithWinnerTicket(WinnerTicket winnerTicket, List<MyTicket> myTickets) {
        for (MyTicket myTicket : myTickets) {
            Rank rank = myTicket.compareWinnerNumbersAndGetStrikes(winnerTicket);
            addTicketsByRanks(rank, myTicket);
        }
    }

    public List<MyTicket> getTicketsByRank(Rank rank) {
        return ticketsByRanks.getOrDefault(rank, new ArrayList<>());
    }

    private void addTicketsByRanks(Rank rank, MyTicket myTicket) {
        ticketsByRanks.putIfAbsent(rank, new ArrayList<>());
        ticketsByRanks.get(rank).add(myTicket);
    }
}
