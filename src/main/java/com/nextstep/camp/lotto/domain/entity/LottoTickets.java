package com.nextstep.camp.lotto.domain.entity;

import com.nextstep.camp.lotto.domain.type.MatchResult;
import com.nextstep.camp.lotto.domain.vo.WinningNumbers;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {
    private final List<LottoTicket> tickets;

    public LottoTickets(List<LottoTicket> tickets) {
        this.tickets = tickets;
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
