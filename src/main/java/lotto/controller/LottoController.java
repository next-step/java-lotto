package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoStore;
import lotto.domain.Rank;
import lotto.dto.RankResult;

public class LottoController {
    private static final LottoStore store = new LottoStore();
    public List<Lotto> buy(int fee) {
        return store.buy(fee);
    }

    public RankResult check(String winningNumbers, List<Lotto> lottos) {
        Lotto winningLotto = Lotto.from(winningNumbers);
        List<Rank> result = new ArrayList<>();
        for (Lotto lotto : lottos) {
            result.add(store.check(lotto, winningLotto));
        }
        return new RankResult(result);
    }
}
