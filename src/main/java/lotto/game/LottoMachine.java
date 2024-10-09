package lotto.game;

import lotto.strategy.LottoNumberStrategy;
import lotto.ticket.LottoTicket;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public static final int LOTTO_PRICE = 1000;
    private final LottoNumberStrategy lottoNumberStrategy;

    public LottoMachine(LottoNumberStrategy lottoNumberStrategy) {
        this.lottoNumberStrategy = lottoNumberStrategy;
    }

    public List<LottoTicket> generateTickets(int amount) {
        int numberOfTickets = amount / LOTTO_PRICE;

        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int i = 0; i < numberOfTickets; i++) {
            lottoTickets.add(LottoTicket.from(lottoNumberStrategy.generate()));
        }

        return lottoTickets;
    }
}
