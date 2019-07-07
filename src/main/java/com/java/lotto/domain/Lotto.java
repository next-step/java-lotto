package com.java.lotto.domain;

import java.util.List;

public class Lotto {

    private final LottoPurchase lottoPurchase;
    private final LottoTickets lottoTickets;

    public Lotto(LottoPurchase lottoPurchase) {
        this.lottoPurchase = lottoPurchase;
        this.lottoTickets = purchase();
    }

    private LottoTickets purchase() {
        List<LottoTicket> lottoTickets = LottoTicketsGenerator.manualTicketsGenerator(lottoPurchase);
        lottoTickets.addAll(LottoTicketsGenerator.automaticTicketsGenerator(lottoPurchase));
        return new LottoTickets(lottoTickets);
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }

    public int getPurchaseAmount(){
        return lottoPurchase.getPurchaseAmount();
    }

    public int getCountOfAutoLotto(){
        return lottoPurchase.getCountOfAutoLotto();
    }

    public int getCountOfManualLotto(){
        return lottoPurchase.getCountOfManualLotto();
    }

}
