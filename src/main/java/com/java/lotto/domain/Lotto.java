package com.java.lotto.domain;

import java.util.List;

public class Lotto {
    public static final int LOTTO_PRICE = 1000;

    LottoTickets lottoTickets;

    public Lotto(int purchaseAmount) {
        this.lottoTickets = purchase(purchaseAmount);
    }

    private LottoTickets purchase(int purchaseAmount) {
        return LottoTicketsGenerator.automaticTicketsGenerator(purchaseAmount / LOTTO_PRICE);
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets.getLottoTickets();
    }

    public int getLottoTicketsCount(){
        return lottoTickets.count();
    }
}
