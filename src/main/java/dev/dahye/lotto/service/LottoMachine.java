package dev.dahye.lotto.service;

import dev.dahye.lotto.domain.LottoTicket;
import dev.dahye.lotto.domain.Money;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private List<LottoTicket> lottoTickets;
    private final Money money;

    public LottoMachine(int money) {
        this.money = new Money(money);

        initializeTickets();

        int lottoCount = this.money.getLottoCount();
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
