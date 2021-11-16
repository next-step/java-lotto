package lotto.model;

import java.util.*;

public class LotteryTickets {

    private final List<LotteryTicket> tickets = new ArrayList<LotteryTicket>();

    public LotteryTickets(int count) {
        for (int cnt = 0 ; cnt < count; cnt++){
            tickets.add(LotteryTicketGenerator.generate());
        }
    }

    public List<LotteryTicket> getTickets(){
        return Collections.unmodifiableList(this.tickets);
    }
}