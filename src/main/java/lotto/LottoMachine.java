package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private final LottoNumberStrategy lottoNumberStrategy;

    private LottoMachine(LottoNumberStrategy lottoNumberStrategy) {
        this.lottoNumberStrategy = lottoNumberStrategy;
    }

    public static LottoMachine of(LottoNumberStrategy lottoNumberStrategy) {
        return new LottoMachine(lottoNumberStrategy);
    }

    public List<LottoTicket> generateTickets(int amount) {

        List<LottoTicket> lottoTickets = new ArrayList<>();
        int numberOfTickets = amount / LOTTO_PRICE;
        for (int i = 0; i < numberOfTickets; i++) {
            lottoTickets.add(LottoTicket.from(lottoNumberStrategy.generate()));
        }

        return lottoTickets;
    }
}
