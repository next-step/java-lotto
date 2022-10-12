package com.game.lotto.ticket;

import com.game.lotto.number.LottoNumberGenerator;
import com.game.lotto.ui.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyTickets {
    private final TicketCount ticketCount;
    private final List<MyTicket> myTickets;
    private final LottoNumberGenerator numberGenerator;

    public MyTickets(TicketCount ticketCount, LottoNumberGenerator numberGenerator) {
        this.ticketCount = ticketCount;
        this.numberGenerator = numberGenerator;
        this.myTickets = new ArrayList<>();
        addRandomTicketsByCount(this.ticketCount);
    }

    private void addRandomTicketsByCount(TicketCount ticketCount) {
        for (int index = 0; index < ticketCount.getCount(); index++) {
            MyTicket randomMyTicket = new MyTicket(numberGenerator);
            ResultView.printTicketNumbers(randomMyTicket);
            this.myTickets.add(randomMyTicket);
        }
    }

    public List<MyTicket> getTickets() {
        return myTickets.stream().collect(Collectors.toUnmodifiableList());
    }

    public int getTicketCount() {
        return this.ticketCount.getCount();
    }
}
