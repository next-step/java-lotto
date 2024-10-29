package lotto.controller;

import lotto.domain.LottoStore;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.dto.RankResult;

public class LottoController {
    private static final LottoStore store = new LottoStore();

    public Lottos buy(int fee) {
        return new Lottos(store.buy(new Money(fee)));
    }

    public RankResult check(String winningNumbers, int bonus, Lottos lottos) {
        WinningLotto winningLotto = WinningLotto.of(winningNumbers, bonus);
        return new RankResult(lottos.matchAll(winningLotto));
    }
}
