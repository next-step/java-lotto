package com.nextstep.camp.lotto.domain.strategy;

import java.util.List;

import com.nextstep.camp.lotto.domain.entity.LottoTicket;

public class LottoFixedPickStrategy implements LottoPickStrategy {

    private final List<LottoTicket> tickets;

    private LottoFixedPickStrategy(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public static LottoFixedPickStrategy of(List<LottoTicket> tickets) {
        return new LottoFixedPickStrategy(tickets);
    }

    @Override
    public List<LottoTicket> pick() {
        return tickets;
    }
}
