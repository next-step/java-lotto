package dev.dahye.lotto.service;

import dev.dahye.lotto.domain.LottoTicket;
import dev.dahye.lotto.domain.LottoMoney;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private List<LottoTicket> lottoTickets;
    private final LottoMoney lottoMoney;

    public LottoMachine(LottoMoney lottoMoney) {
        this.lottoMoney = lottoMoney;

        initializeTickets();

        int lottoCount = this.lottoMoney.getCountOfLotto();
        for (int i = 0; i < lottoCount; i++) {
            lottoTickets.add(LottoTicket.autoIssued());
        }
    }

    private void initializeTickets() {
        this.lottoTickets = new ArrayList<>();
    }

    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

    protected int getTicketsCount() {
        return lottoTickets.size();
    }
}
