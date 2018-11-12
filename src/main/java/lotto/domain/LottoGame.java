package lotto.domain;

import java.util.List;

public class LottoGame {
    private final List<Lotto> lottos;

    public LottoGame(Money money) {
        this.lottos = AutoLottoGenerator.generateLottos(money);
    }

    public LottoResult match(WinningLotto winningLotto) {
        DefaultLottoResult result = new DefaultLottoResult();
        for (Lotto lotto : lottos) {
            result.putRank(winningLotto.match(lotto));
        }
        return result;
    }
}
