package lotto.controller;

import java.util.Collections;
import lotto.domain.LottoStore;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.RandomLottoNumberGenerator;
import lotto.domain.WinningLotto;
import lotto.dto.RankResult;

public class LottoController {
    private static final LottoStore store = new LottoStore(new RandomLottoNumberGenerator());

    public Lottos buy(int fee) {
        return store.buy(new Money(fee), Collections.EMPTY_LIST);
    }

    public RankResult check(String winningNumbers, int bonus, Lottos lottos) {
        WinningLotto winningLotto = WinningLotto.of(winningNumbers, bonus);
        return new RankResult(lottos.matchAll(winningLotto));
    }
}
