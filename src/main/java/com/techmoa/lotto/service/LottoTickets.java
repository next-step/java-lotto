package com.techmoa.lotto.service;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    private List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }
    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}
