package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    public static final int TICKET_AMOUNT = 1000;

    private final List<Ticket> ticketList;

    public Lotto(int amount) {
        int ticketCount = convertAmountToTicketCount(amount);
        this.ticketList = makeTicketList(ticketCount);
    }

    public Lotto(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public static int convertAmountToTicketCount(int amount) {
        return amount / TICKET_AMOUNT;
    }

    public static List<Ticket> makeTicketList(int count) {
        List<Ticket> ticketList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Ticket ticket = new Ticket();
            ticketList.add(ticket);
        }
        return ticketList;
    }

    public int getTicketCount() {
        return ticketList.size();
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public Ranks rankedWinningNumbers(List<Integer> winningNumbers) {
        List<Rank> ranks = new ArrayList<>();
        for (Ticket ticket : ticketList) {
            ranks.add(matchRank(winningNumbers, ticket));
        }
        return new Ranks(ranks, getPurchageAmount());
    }

    public static int getWinningNumbersMatchCount(List<Integer> winningNumbers, Ticket ticket) {
        int matchCount = 0;
        for (Integer tiketNumber : ticket.getLottoNumbers()) {
            matchCount = increaseMatchCount(winningNumbers, tiketNumber, matchCount);
        }
        return matchCount;
    }
    public static Rank matchRank(List<Integer> winningNumbers, Ticket ticket) {
        return Rank.of(getWinningNumbersMatchCount(winningNumbers, ticket));
    }

    public static int increaseMatchCount(List<Integer> winningNumbers, Integer tiketNumber, int matchCount) {
        if (winningNumbers.contains(tiketNumber)) {
            matchCount++;
        }
        return matchCount;
    }

    public int getPurchageAmount(){
        return ticketList.size() * Lotto.TICKET_AMOUNT;
    }




}
