package lotto;

import java.util.List;

public class LottoGame {
    private final List<Lotto> lottos;

    public LottoGame(Money money, LottoGenerator lottoNumberRandom) {
        this.lottos = lottoNumberRandom.generate(money);
    }

    public LottoResult result(Lotto winningLotto) {
        LottoResult result = new LottoResult();
        for (Lotto lotto : lottos) {
            int match = winningLotto.match(lotto);
            result.putRank(Rank.getRank(match));
        }
        return result;
    }
}
