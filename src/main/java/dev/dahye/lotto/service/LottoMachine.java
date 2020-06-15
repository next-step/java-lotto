package dev.dahye.lotto.service;

import dev.dahye.lotto.domain.LottoOrder;
import dev.dahye.lotto.domain.LottoTickets;

import java.util.Objects;

public class LottoMachine {
    private final LottoTickets lottoTickets;

    public LottoMachine(LottoOrder lottoOrder) {
        Objects.requireNonNull(lottoOrder, "lottoOrder must not be null");

        lottoTickets = lottoOrder.issued();
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }
}
