package com.nextstep.camp.lotto.domain.entity;

import com.nextstep.camp.lotto.domain.exception.LottoTicketsCannotBeEmptyException;
import com.nextstep.camp.lotto.domain.type.Rank;
import com.nextstep.camp.lotto.domain.vo.WinningNumbers;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {
    private final List<LottoTicket> tickets;

    private LottoTickets(List<LottoTicket> tickets) {
        validate(tickets);
        this.tickets = tickets;
    }

    private static void validate(List<LottoTicket> tickets) {
        if (tickets == null || tickets.isEmpty()) {
            throw new LottoTicketsCannotBeEmptyException();
        }
    }

    public static LottoTickets of(List<LottoTicket> tickets) {
        return new LottoTickets(tickets);
    }

    public int size() {
        return tickets.size();
    }

    public List<LottoTicket> getTickets() {
        return tickets;
    }

    public List<Rank> matchAll(WinningNumbers winning) {
        return tickets.stream()
                .map(ticket -> ticket.match(winning))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return tickets.stream()
                .map(LottoTicket::toString)
                .collect(Collectors.joining("\n"));
    }
}
