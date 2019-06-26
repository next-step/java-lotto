package com.jaeyeonling.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public final class LottoStore {

    private static final LottoGenerator RANDOM_LOTTO_GENERATOR = new RandomLottoGenerator();

    private LottoStore() { }

    public static List<Lotto> buyAutoByRemainingMoney(final Money money) {
        final List<Lotto> lottos = new ArrayList<>();
        while (money.canBuy(Lotto.PRICE)) {
            lottos.add(buyLotto(money, RANDOM_LOTTO_GENERATOR));
        }

        return lottos;
    }

    public static List<Lotto> buyManual(final Money money,
                                        final LottoTicket lottoTicket) {
        final ManualLottoGenerator manualLottoGenerator = new ManualLottoGenerator(lottoTicket);

        final List<Lotto> lottos = new ArrayList<>();
        while (manualLottoGenerator.hasNext()) {
            lottos.add(buyLotto(money, manualLottoGenerator));
        }

        return lottos;
    }

    private static Lotto buyLotto(final Money money,
                                  final LottoGenerator lottoGenerator) {
        final Lotto lotto = lottoGenerator.generate();
        money.buy(lotto);

        return lotto;
    }
}
