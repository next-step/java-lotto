package com.nextstep.camp.lotto.domain.strategy;

import com.nextstep.camp.lotto.domain.entity.LottoTicket;

import java.util.List;

public class LottoFixedPicker implements LottoPicker {

    private final List<LottoTicket> tickets;

    private LottoFixedPicker(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public static LottoFixedPicker of(List<LottoTicket> tickets) {
        return new LottoFixedPicker(tickets);
    }

    @Override
    public List<LottoTicket> pick() {
        return tickets;
    }
}
