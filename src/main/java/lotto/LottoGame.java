package lotto;

import java.util.List;

public class LottoGame {
    private final List<Lotto> lottos;

    public LottoGame(Money money, LottoGenerator lottoNumberRandom) {
        this.lottos = lottoNumberRandom.generate(money);
    }

    public LottoResult result(WinningLotto winningLotto) {
        LottoResult result = new LottoResult();
        for (Lotto lotto : lottos) {
            int match = winningLotto.getWinLotto().match(lotto);
            result.putRank(Rank.getRank(match));
        }
        return result;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
