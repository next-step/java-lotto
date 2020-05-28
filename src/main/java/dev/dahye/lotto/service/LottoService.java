package dev.dahye.lotto.service;

import dev.dahye.lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private static final int LOTTO_PRICE = 1000;
    private final List<LottoTicket> lottoTickets;

    public LottoService(int money) {
        int lottoCount = money / LOTTO_PRICE;
        this.lottoTickets = new ArrayList<>();
        for(int i = 0; i < lottoCount; i++) {
            lottoTickets.add(LottoTicket.create());
        }
    }

    public int getTotalCount() {
        return lottoTickets.size();
    }
}
