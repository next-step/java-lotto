package com.game.lotto.ticket;

import com.game.lotto.number.LottoNumberGenerator;
import com.game.lotto.ui.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyTickets {
    private final List<Ticket> tickets;
    private final LottoNumberGenerator numberGenerator;

    public MyTickets(long tryCount, LottoNumberGenerator numberGenerator) {
        this.tickets = new ArrayList<>();
        this.numberGenerator = numberGenerator;
        addRandomTicketsByCount(tryCount);
    }

    private void addRandomTicketsByCount(long tryCount) {
        for (int index = 0; index < tryCount; index++) {
            Ticket randomTicket = new Ticket(numberGenerator);
            ResultView.printTicketNumbers(randomTicket);
            this.tickets.add(randomTicket);
        }
    }

    public List<Ticket> getTickets() {
        return tickets.stream().collect(Collectors.toUnmodifiableList());
    }
}
