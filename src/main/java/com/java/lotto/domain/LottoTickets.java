package com.java.lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoTickets {
    private final List<LottoTicket> lottotickets;

    public LottoTickets(List<LottoTicket> tickets) {
        this.lottotickets = tickets;
    }

    public int count() {
        return lottotickets.size();
    }

    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(lottotickets);
    }

}
