package com.nextstep.camp.lotto.domain.entity;

import java.util.List;
import java.util.stream.Collectors;

import com.nextstep.camp.lotto.domain.exception.LottoTicketsCannotBeEmptyException;
import com.nextstep.camp.lotto.domain.type.MatchResult;
import com.nextstep.camp.lotto.domain.vo.WinningNumbers;

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

    public List<MatchResult> matchAll(WinningNumbers winning) {
        return tickets.stream()
                .map(ticket -> MatchResult.of(ticket.countMatch(winning)))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return tickets.stream()
                .map(LottoTicket::toString)
                .collect(Collectors.joining("\n"));
    }
}
