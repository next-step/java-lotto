package lotto.game;

import lotto.number.LottoNumbers;
import lotto.strategy.LottoNumberStrategy;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public static final int LOTTO_PRICE = 1000;
    private final LottoNumberStrategy lottoNumberStrategy;

    public LottoMachine(LottoNumberStrategy lottoNumberStrategy) {
        this.lottoNumberStrategy = lottoNumberStrategy;
    }

    public List<LottoNumbers> generateTickets(int amount) {
        int numberOfTickets = amount / LOTTO_PRICE;

        List<LottoNumbers> lottoTickets = new ArrayList<>();

        for (int i = 0; i < numberOfTickets; i++) {
            lottoTickets.add(new LottoNumbers(lottoNumberStrategy.generate()));
        }

        return lottoTickets;
    }
}
