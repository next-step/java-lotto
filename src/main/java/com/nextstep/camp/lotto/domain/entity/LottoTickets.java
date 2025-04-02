package com.nextstep.camp.lotto.domain.entity;

import java.util.List;
import java.util.stream.Collectors;

import com.nextstep.camp.lotto.domain.exception.LottoTicketsCannotBeEmptyException;
import com.nextstep.camp.lotto.domain.strategy.LottoPickStrategy;
import com.nextstep.camp.lotto.domain.type.MatchResult;
import com.nextstep.camp.lotto.domain.vo.WinningNumbers;

public class LottoTickets {
    private final List<LottoTicket> tickets;

    private LottoTickets(LottoPickStrategy pickStrategy) {
        List<LottoTicket> tickets = pickStrategy.pick();
        if (tickets == null || tickets.isEmpty()) {
            throw new LottoTicketsCannotBeEmptyException();
        }
        this.tickets = tickets;
    }

    public static LottoTickets of(LottoPickStrategy pickStrategy) {
        return new LottoTickets(pickStrategy);
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
