package com.java.lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class LottoTickets {
    private List<LottoTicket> lottotickets;

    public LottoTickets(List<LottoTicket> tickets) {
        this.lottotickets = tickets;
    }

    public int count() {
        return lottotickets.size();
    }

    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(lottotickets);
    }
    
    public Stream<LottoTicket> lottoTicketsStream(){
    	return lottotickets.stream();
    }
}
