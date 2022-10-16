package com.game.lotto.ticket;

import com.game.lotto.number.LottoNumberGenerator;
import com.game.lotto.ui.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyTickets {
    private final List<MyTicket> myTickets;
    private final LottoNumberGenerator numberGenerator;

    public MyTickets(TicketCount ticketCount, LottoNumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        this.myTickets = new ArrayList<>();
        addRandomTicketsByCount(ticketCount);
    }

    private void addRandomTicketsByCount(TicketCount ticketCount) {
        int count = 0;
        while (ticketCount.hasNext()) {
            count++;
            MyTicket randomMyTicket = new MyTicket(numberGenerator);
            ResultView.printTicketNumbers(randomMyTicket);
            this.myTickets.add(randomMyTicket);
            ticketCount.next();
        }
        ResultView.printOutputCountMessage(count);
    }

    public List<MyTicket> getTickets() {
        return myTickets.stream().collect(Collectors.toUnmodifiableList());
    }
}
