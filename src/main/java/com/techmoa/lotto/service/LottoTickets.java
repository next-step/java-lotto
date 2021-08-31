package com.techmoa.lotto.service;

import com.techmoa.lotto.model.LottoWinResult;
import com.techmoa.lotto.model.LottoWinScope;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }
    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }


}
