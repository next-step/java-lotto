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
            Ticket ticket = Ticket.create();
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

    public Ranks rankedWinningNumbers(WinningTicket winningTicket) {
        List<Rank> ranks = new ArrayList<>();
        for (Ticket ticket : ticketList) {
            ranks.add(matchRank(winningTicket, ticket));
        }
        return new Ranks(ranks, getPurchageAmount());
    }

    public static Rank matchRank(WinningTicket winningTicket, Ticket ticket) {
        int matchCount = getWinningNumbersMatchCount(winningTicket.getTicket(), ticket);
        boolean matchBonus = ticket.getLottoNumbers().contains(winningTicket.getBonusNumber());
        return Rank.of(matchCount, matchBonus);
    }

    public static int getWinningNumbersMatchCount(Ticket winningTicket, Ticket ticket) {
        int matchCount = 0;
        for (LottoNumber tiketNumber : ticket.getLottoNumbers()) {
            matchCount = increaseMatchCount(winningTicket, tiketNumber, matchCount);
        }
        return matchCount;
    }


    public static int increaseMatchCount(Ticket winningTicket, LottoNumber tiketNumber, int matchCount) {
        if (winningTicket.getLottoNumbers().contains(tiketNumber)) {
            matchCount++;
        }
        return matchCount;
    }

    public int getPurchageAmount(){
        return ticketList.size() * Lotto.TICKET_AMOUNT;
    }




}
