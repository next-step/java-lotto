package com.jaeyeonling.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public final class LottoStore {

    private static final LottoGenerator RANDOM_LOTTO_GENERATOR = new RandomLottoGenerator();

    private LottoStore() { }

    public static List<Lotto> buyAutoByRemainingMoney(final Money money) {
        final List<Lotto> lottos = new ArrayList<>();
        while (money.canBuy(Lotto.PRICE)) {
            final Lotto lotto = RANDOM_LOTTO_GENERATOR.generate();

            money.buy(lotto);

            lottos.add(lotto);
        }

        return lottos;
    }

    public static List<Lotto> buyManual(final Money money,
                                        final LottoTicket lottoTicket) {

        return null;
    }
}
